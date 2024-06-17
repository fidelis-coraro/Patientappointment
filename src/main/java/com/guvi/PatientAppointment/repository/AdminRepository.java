package com.guvi.PatientAppointment.repository;

import com.guvi.PatientAppointment.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByEmail(String user);

    List<Admin> findByRole(String user);
}
