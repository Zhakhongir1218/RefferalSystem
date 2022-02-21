package kg.itschool.referalsystem.referalsystem.controllers;

import kg.itschool.referalsystem.referalsystem.exceptions.SubscriberExeptions;
import kg.itschool.referalsystem.referalsystem.models.dtos.InviteDTO;
import kg.itschool.referalsystem.referalsystem.models.dtos.InviteReceiveDTO;
import kg.itschool.referalsystem.referalsystem.models.dtos.SubsPhoneDTO;
import kg.itschool.referalsystem.referalsystem.models.entities.Invite;
import kg.itschool.referalsystem.referalsystem.services.InviteService;
import kg.itschool.referalsystem.referalsystem.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/invite")
public class InviteController {

    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    private InviteService inviteService;

    @PostMapping("/send")
    public Invite sendInvite(@RequestBody InviteDTO inviteDTO) throws SubscriberExeptions {
        return inviteService.sendInvite(inviteDTO);
    }

    @PostMapping("/receive")
    public Invite receiveInvite(@RequestBody SubsPhoneDTO subsPhoneDTO){
        return inviteService.receiveInvite(subsPhoneDTO.getPhone());
    }

}
