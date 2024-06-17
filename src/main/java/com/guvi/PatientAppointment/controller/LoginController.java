package com.guvi.PatientAppointment.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/showMyLoginPage", method = RequestMethod.GET)
public class LoginController {

    public String showHome() {
        return "login";
    }
}
