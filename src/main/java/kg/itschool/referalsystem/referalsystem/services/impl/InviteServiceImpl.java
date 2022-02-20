package kg.itschool.referalsystem.referalsystem.services.impl;

import kg.itschool.referalsystem.referalsystem.exceptions.SubscriberExeptions;
import kg.itschool.referalsystem.referalsystem.models.dtos.InviteDTO;
import kg.itschool.referalsystem.referalsystem.models.entities.Invite;
import kg.itschool.referalsystem.referalsystem.models.entities.Subscriber;
import kg.itschool.referalsystem.referalsystem.models.enums.InviteStatus;
import kg.itschool.referalsystem.referalsystem.repositories.InviteRepo;
import kg.itschool.referalsystem.referalsystem.services.InviteService;
import kg.itschool.referalsystem.referalsystem.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Objects;

@Service
public class InviteServiceImpl implements InviteService {

    @Autowired
    private InviteRepo inviteRepo;

    @Autowired
    private SubscriberService subscriberService;


    @Override
    public Invite sendInvite(InviteDTO inviteDTO) throws SubscriberExeptions {
        Subscriber sender = subscriberService.findByPhone(inviteDTO.getSender());
        Subscriber receiver = subscriberService.findByPhone(inviteDTO.getReceiver());
        if (Objects.isNull(sender) & Objects.isNull(receiver)) {
            throw new SubscriberExeptions("Subscriber not found");
        }


        Invite invite = new Invite();
        invite.setSender(sender);
        invite.setReceiver(receiver);
        invite.setInviteStatus(InviteStatus.NEW);
        invite.setStart_date(LocalDate.now());
        invite.setEnd_date(LocalDate.now().plusDays(30));
        //Одному подписчику один инвайт от другого подписчика
        sendedBeforeOrNot(invite);

        // Ниже считаем количество отправленных инвайтов у отправителя
        Integer tmp = inviteRepo.countInviteBySender(invite.getSender().getSubscriber_id(), invite);
        if(tmp >= 5){
            invite.setInviteStatus(InviteStatus.CANCELLED);
        }


        inviteRepo.save(invite);
        return invite;
    }


    public Boolean sendedBeforeOrNot(Invite invite) throws SubscriberExeptions {
        Integer counting = inviteRepo.countSameSendersAndReceivers(invite.getSender().getSubscriber_id(),invite.getReceiver().getSubscriber_id(),invite);
        boolean checker;
        if(counting<1){
            checker = true;
            return checker;
        }else {
            throw new SubscriberExeptions("You have send an invite to this user today!");
        }
    }

}
