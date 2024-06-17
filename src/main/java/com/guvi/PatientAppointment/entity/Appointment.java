package com.guvi.PatientAppointment.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "app")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;


    @Column(name = "description")
    private String description;


    @Column(name = "regtime")
    @Transient
    private String regtime;

}


