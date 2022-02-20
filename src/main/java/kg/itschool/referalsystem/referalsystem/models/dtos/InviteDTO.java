package kg.itschool.referalsystem.referalsystem.models.dtos;

import kg.itschool.referalsystem.referalsystem.models.entities.Subscriber;
import kg.itschool.referalsystem.referalsystem.models.enums.InviteStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InviteDTO {
    Long id;


    String sender;

    String receiver;

    LocalDate start_date;

    LocalDate end_date;

    InviteStatus inviteStatus;
}
