package com.guvi.PatientAppointment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "admin", nullable = false, unique = true)
    @NotEmpty(message = "Please provide an e-mail")
    private String email;

    @Column(name = "password")
    @Transient
    private String password;

    @Column(name = "first_name")
    @NotEmpty(message = "Please provide your first name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Please provide your last name")
    private String lastName;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    @Column(name = "gender")
    private String gender;


    @Column(name = "authority")
    private String role;

    @Column(name = "lastseen")
    @Transient
    private String lastseen;
}

