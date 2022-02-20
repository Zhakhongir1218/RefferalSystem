package kg.itschool.referalsystem.referalsystem.services;

import kg.itschool.referalsystem.referalsystem.exceptions.SubscriberExeptions;
import kg.itschool.referalsystem.referalsystem.models.dtos.SubsPhoneDTO;
import kg.itschool.referalsystem.referalsystem.models.entities.Subscriber;

public interface SubscriberService {
    SubsPhoneDTO registerNewSub(SubsPhoneDTO subsPhoneDTO) throws SubscriberExeptions;


    Subscriber findByPhone(String phone);
}
