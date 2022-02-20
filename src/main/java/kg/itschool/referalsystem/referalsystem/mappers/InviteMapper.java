package kg.itschool.referalsystem.referalsystem.mappers;

import kg.itschool.referalsystem.referalsystem.models.dtos.InviteDTO;
import kg.itschool.referalsystem.referalsystem.models.entities.Invite;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

//@Mapper
public interface InviteMapper {
    InviteMapper INSTANCE = Mappers.getMapper(InviteMapper.class);
    Invite inviteDTOToInvite(InviteDTO inviteDTO);

    InviteDTO inviteTOInviteDTO(Invite invite);
}
