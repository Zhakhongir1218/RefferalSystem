package kg.itschool.referalsystem.referalsystem.repositories;

import kg.itschool.referalsystem.referalsystem.models.dtos.SubsPhoneDTO;
import kg.itschool.referalsystem.referalsystem.models.entities.Invite;

import kg.itschool.referalsystem.referalsystem.models.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InviteRepo extends JpaRepository<Invite,Long> {

    @Query(value = "Select Count(sender_id) FROM invites where sender_id = ?1",nativeQuery = true)
    Integer countInviteBySender(Long id, Invite invite);

    @Query(value = "SELECT COUNT(sender_id) FROM invites where sender_id=?1 And receiver_id = ?2", nativeQuery = true)
    Integer countSameSendersAndReceivers(Long id, Long id2);

    @Query(value = "Select sender_id From invites where start_date = ?1 order by id desc limit 1", nativeQuery = true)
    Invite findInviteByDate(Invite invite);

    @Query(value = "SELECT start_date FROM invites where sender_id = ?1 and receiver_id = ?2 order by start_date desc limit 1 ", nativeQuery = true)
    LocalDate findLastDate(Long id, Long id2);



    Invite findDistinctFirstByReceiverPhone(String phone);

    @Query(value = "select start_date FROM invites where sender_id=?1",nativeQuery = true)
    LocalDate findLastForFiveDaysMethod(Long subscriber_id);
}
