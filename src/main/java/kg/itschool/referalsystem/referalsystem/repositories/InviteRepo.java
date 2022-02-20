package kg.itschool.referalsystem.referalsystem.repositories;

import kg.itschool.referalsystem.referalsystem.models.entities.Invite;

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
    Integer countSameSendersAndReceivers(Long id, Long id2, Invite invite);






}