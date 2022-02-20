package kg.itschool.referalsystem.referalsystem.services.impl;

import kg.itschool.referalsystem.referalsystem.exceptions.SubscriberExeptions;
import kg.itschool.referalsystem.referalsystem.mappers.SubsMapper;
import kg.itschool.referalsystem.referalsystem.models.dtos.SubsPhoneDTO;
import kg.itschool.referalsystem.referalsystem.models.entities.Subscriber;
import kg.itschool.referalsystem.referalsystem.repositories.SubscriberRepo;
import kg.itschool.referalsystem.referalsystem.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


@Service
public class SubscriberServiceImpl implements SubscriberService {
    @Autowired
    private SubscriberRepo subscriberRepo;

    @Override
    public SubsPhoneDTO registerNewSub(SubsPhoneDTO subsPhoneDTO) throws SubscriberExeptions {
        Subscriber subscriber = SubsMapper.INSTANCE.subPhoneDTOToSubscriber(subsPhoneDTO);
        Subscriber containsOrNot = subscriberRepo.findByPhoneContains(subscriber.getPhone());
        if(containsOrNot==null){
            subscriber.setActive(false);
            subscriber.setEdit_date(LocalDate.now());
            subscriberRepo.save(subscriber);
        }else{
            throw new SubscriberExeptions("We  have this phone number already");
        }
        return subsPhoneDTO;
    }

    @Override
    public Subscriber findByPhone(String phone) {
        return subscriberRepo.findByPhone(phone);
    }


}
