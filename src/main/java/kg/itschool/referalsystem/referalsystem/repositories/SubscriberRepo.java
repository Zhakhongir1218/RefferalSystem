package kg.itschool.referalsystem.referalsystem.repositories;

import kg.itschool.referalsystem.referalsystem.models.entities.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepo extends JpaRepository<Subscriber,Long> {
    Subscriber findByPhoneContains(String phone);
    Subscriber findByPhone(String phone);

}
