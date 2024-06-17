package com.guvi.PatientAppointment.repository;

import com.guvi.PatientAppointment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findByConfirmationToken(String confirmationToken);

    List<User> findAll();

}
