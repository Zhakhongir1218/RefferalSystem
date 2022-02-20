package kg.itschool.referalsystem.referalsystem.controllers;

import kg.itschool.referalsystem.referalsystem.exceptions.SubscriberExeptions;
import kg.itschool.referalsystem.referalsystem.models.dtos.SubsPhoneDTO;
import kg.itschool.referalsystem.referalsystem.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sub")
public class SubscriberController {
    @Autowired
    private SubscriberService subscriberService;

    //РАБОТАЕТ
    @PostMapping("/new/sub")
    public SubsPhoneDTO createNewSubscriber(@RequestBody SubsPhoneDTO subsPhoneDTO) throws SubscriberExeptions {
        return subscriberService.registerNewSub(subsPhoneDTO);
    }


}
