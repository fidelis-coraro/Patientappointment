package com.guvi.PatientAppointment.controller;


import com.guvi.PatientAppointment.entity.Admin;
import com.guvi.PatientAppointment.entity.Appointment;
import com.guvi.PatientAppointment.service.AdminService;
import com.guvi.PatientAppointment.service.AppointmentService;
import com.guvi.PatientAppointment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private AppointmentService appointmentService;



    @RequestMapping("/index")
    public String index(Model model){

        // get last seen
        String username="";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
            String Pass = ((UserDetails)principal).getPassword();
            System.out.println("One + "+username+"   "+Pass);


        } else {
            username = principal.toString();
            System.out.println("Two + "+username);
        }

        Admin admin = adminService.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();
        String log=now.toString();
        admin.setLastseen(log);
        adminService.save(admin);

        List<Appointment> list=appointmentService.findAll();

        model.addAttribute("name",admin.getFirstName());
        model.addAttribute("email",admin.getEmail());
        model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
        // add to the spring model
        model.addAttribute("app", list);
        return "doctor/index";
    }


}




