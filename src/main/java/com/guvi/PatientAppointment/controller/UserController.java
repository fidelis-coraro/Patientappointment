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
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

        @Autowired
        private UserService userService;
        @Autowired
        private AppointmentService appointmentService;

        @Autowired
        private AdminService adminService;

    public UserController(AppointmentService obj1, AdminService obj ) {
        appointmentService= obj1;
        adminService=obj;

    }

    @GetMapping("/index")
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

        Appointment obj=new Appointment();

        obj.setName(admin.getFirstName()+" "+admin.getLastName());
        obj.setEmail(admin.getEmail());
        System.out.println(obj);
        model.addAttribute("app",obj);
        return "user/index";
    }

    @PostMapping("/save-app")
    public String saveEmploye(@ModelAttribute("app") Appointment obj) {
        appointmentService.save(obj);
        // use a redirect to prevent duplicate submissions
        return "redirect:/user/index";
    }


    @GetMapping("/about")
    public String about(Model model){

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

        Appointment obj=new Appointment();

        obj.setName(admin.getFirstName()+" "+admin.getLastName());
        obj.setEmail(admin.getEmail());
        System.out.println(obj);
        model.addAttribute("app",obj);

        return "user/about";
    }

    @GetMapping("/blog-single")
    public String bs(Model model){

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

        Appointment obj=new Appointment();

        obj.setName(admin.getFirstName()+" "+admin.getLastName());
        obj.setEmail(admin.getEmail());
        System.out.println(obj);
        model.addAttribute("app",obj);
        return "user/blog-single";
    }

    @GetMapping("/blog")
    public String blog(Model model){

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

        Appointment obj=new Appointment();

        obj.setName(admin.getFirstName()+" "+admin.getLastName());
        obj.setEmail(admin.getEmail());
        System.out.println(obj);

        model.addAttribute("app",obj);
        return "user/blog";
    }

    @GetMapping("/contact")
    public String contact(Model model){

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



        Appointment obj=new Appointment();
        obj.setName(admin.getFirstName()+" "+admin.getLastName());
        obj.setEmail(admin.getEmail());
        System.out.println(obj);
        model.addAttribute("app",obj);
        return "user/contact";
    }


    @GetMapping("/department-single")
    public String d(Model model){

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



        Appointment obj=new Appointment();
        obj.setName(admin.getFirstName()+" "+admin.getLastName());
        obj.setEmail(admin.getEmail());
        System.out.println(obj);
        model.addAttribute("app",obj);


        return "user/department-single";
    }

    @GetMapping("/departments")
    public String dep(Model model){

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


        Appointment obj=new Appointment();
        obj.setName(admin.getFirstName()+" "+admin.getLastName());
        obj.setEmail(admin.getEmail());
        System.out.println(obj);
        model.addAttribute("app",obj);
        return "user/departments";
    }

    @GetMapping("/doctor")
    public String doctor(Model model){

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

        Appointment obj=new Appointment();
        obj.setName(admin.getFirstName()+" "+admin.getLastName());
        obj.setEmail(admin.getEmail());
        System.out.println(obj);
        model.addAttribute("app",obj);
        return "user/doctor";
    }
}


