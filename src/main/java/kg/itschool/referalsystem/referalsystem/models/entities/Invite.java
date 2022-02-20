package kg.itschool.referalsystem.referalsystem.models.entities;

import kg.itschool.referalsystem.referalsystem.models.enums.InviteStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "invites")
public class Invite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    Subscriber sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    Subscriber receiver;

    LocalDate start_date;

    LocalDate end_date;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    InviteStatus inviteStatus;

}
