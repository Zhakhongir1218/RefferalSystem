package kg.itschool.referalsystem.referalsystem.models.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubscriberDTO {
    Long subscriber_id;
    String phone;
    Boolean active;
    LocalDate edit_date;
}
