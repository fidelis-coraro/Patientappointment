package com.guvi.PatientAppointment.service;

import com.guvi.PatientAppointment.entity.Admin;
import com.guvi.PatientAppointment.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;


    public List<Admin> findAll() {
        return adminRepository.findAll();
    }


    public void save(Admin admin) {
        adminRepository.save(admin);
    }


    public Admin findByEmail(String user) {
        // TODO Auto-generated method stub
        return adminRepository.findByEmail(user);
    }


    public List<Admin> findByRole(String user) {
        return adminRepository.findByRole(user);
    }


}
