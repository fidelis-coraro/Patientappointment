package com.guvi.PatientAppointment.service;

import com.guvi.PatientAppointment.entity.Appointment;
import com.guvi.PatientAppointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public void save(Appointment app) {
        appointmentRepository.save(app);
    }


    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }




}

