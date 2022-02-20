package kg.itschool.referalsystem.referalsystem.models.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubsPhoneDTO {
    String phone;
}
