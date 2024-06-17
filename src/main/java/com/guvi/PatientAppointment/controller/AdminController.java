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
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private AppointmentService appointmentService;


    
    @RequestMapping("/user-details")
    public String index(Model model){


        List<Admin> list=adminService.findByRole("ROLE_USER");
        model.addAttribute("user", list);


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
        return "admin/user";
    }

    @RequestMapping("/doctor-details")
    public String doctorDetails(Model model){


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
        List<Admin> list=adminService.findByRole("ROLE_DOCTOR");
        // add to the spring model
        model.addAttribute("user", list);
        return "admin/doctor";
    }

    @RequestMapping("/admin-details")
    public String adminDetails(Model model){

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

        List<Admin> list=adminService.findByRole("ROLE_ADMIN");
        // add to the spring model
        model.addAttribute("user", list);
        return "admin/admin";
    }


    @GetMapping("/add-doctor")
    public String showFormForAdd(Model theModel) {


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

        Admin admin1 = adminService.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();
        String log=now.toString();
        admin1.setLastseen(log);
        adminService.save(admin1);
        // create model attribute to bind form data
        Admin admin = new Admin();
        theModel.addAttribute("doctor", admin);
        return "admin/addDoctor";
    }


    @PostMapping("/save-doctor")
    public String saveEmployee(@ModelAttribute("doctor") Admin admin) {

        // save the employee
        //	admin.setId(0);

        admin.setRole("ROLE_DOCTOR");
        admin.setPassword("default");
        admin.setEnabled(true);
        admin.setConfirmationToken("ByAdmin-Panel");
        System.out.println(admin);
        adminService.save(admin);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/userdetails";
    }



    @GetMapping("/add-admin")
    public String showForm(Model theModel) {


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

        Admin admin1 = adminService.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();
        String log=now.toString();
        admin1.setLastseen(log);
        adminService.save(admin1);

        // create model attribute to bind form data
        Admin admin = new Admin();
        theModel.addAttribute("doctor", admin);
        return "admin/addAdmin";
    }


    @PostMapping("/save-admin")
    public String saveEmploye(@ModelAttribute("doctor") Admin admin) {

        // save the employee
        //	admin.setId(0);

        admin.setRole("ROLE_ADMIN");
        admin.setPassword("default");
        admin.setEnabled(true);
        admin.setConfirmationToken("ByAdmin-Panel");
        System.out.println(admin);
        adminService.save(admin);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/userdetails";
    }

    @GetMapping("/edit-my-profile")
    public String EditForm(Model theModel) {

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

        // get the employee from the service

        Admin admin = adminService.findByEmail(username);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();
        String log=now.toString();
        admin.setLastseen(log);
        adminService.save(admin);
        System.out.println(admin);
        theModel.addAttribute("profile", admin);
        return "admin/updateMyProfile";
    }


    @PostMapping("/update")
    public String update(@ModelAttribute("profile") Admin admin) {
        System.out.println(admin);
        adminService.save(admin);
        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/user-details";
    }


    @RequestMapping("/appointments")
    public String appointments(Model model){


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
        // add to the spring model
        model.addAttribute("app", list);
        return "admin/appointment";
    }
}

