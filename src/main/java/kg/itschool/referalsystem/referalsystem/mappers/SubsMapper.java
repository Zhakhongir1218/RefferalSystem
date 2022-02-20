package kg.itschool.referalsystem.referalsystem.mappers;

import kg.itschool.referalsystem.referalsystem.models.dtos.SubsPhoneDTO;
import kg.itschool.referalsystem.referalsystem.models.dtos.SubscriberDTO;
import kg.itschool.referalsystem.referalsystem.models.entities.Subscriber;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubsMapper {
    SubsMapper INSTANCE = Mappers.getMapper(SubsMapper.class);
    Subscriber subPhoneDTOToSubscriber(SubsPhoneDTO subsPhoneDTO);
    Subscriber subscriberDTOToSubscriber(SubscriberDTO subscriberDTO);
}
