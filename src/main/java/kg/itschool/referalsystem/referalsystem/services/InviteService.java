package kg.itschool.referalsystem.referalsystem.services;

import kg.itschool.referalsystem.referalsystem.exceptions.SubscriberExeptions;
import kg.itschool.referalsystem.referalsystem.models.dtos.InviteDTO;
import kg.itschool.referalsystem.referalsystem.models.dtos.InviteReceiveDTO;
import kg.itschool.referalsystem.referalsystem.models.dtos.SubsPhoneDTO;
import kg.itschool.referalsystem.referalsystem.models.entities.Invite;

public interface InviteService {
    Invite sendInvite(InviteDTO inviteDTO) throws SubscriberExeptions;
    Invite receiveInvite(String phone);
}
