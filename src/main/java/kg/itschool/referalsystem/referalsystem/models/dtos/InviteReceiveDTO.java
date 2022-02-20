package kg.itschool.referalsystem.referalsystem.models.dtos;

import kg.itschool.referalsystem.referalsystem.models.entities.Subscriber;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InviteReceiveDTO {
    Subscriber receiver;
}
