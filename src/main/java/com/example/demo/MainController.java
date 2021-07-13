package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MainController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentService appService;



    @GetMapping("")
    public String viewSignupAndLogin() {
        return "start";
    }

    @GetMapping("/content")
    public String viewAppointmentAndNotesPage(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails)auth.getPrincipal();
        Long patientId = customUser.getId();

        model.addAttribute("appointmentList", appointmentRepository.findAppointmentByPatientId(patientId));
        return "content";
    }

    @GetMapping("/scheduling")
    public String showAppointmentForm(Model model){

        model.addAttribute("doctorList", userRepository.findAllDoctors());
        model.addAttribute("appointment", new Appointment());


        return "appointment_form";
    }

    @PostMapping("/process_appointment")
    public String processAppointment(Appointment appointment) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails)auth.getPrincipal();
        Long patientId = customUser.getId();

        User patient = userRepository.findPatientById(patientId);

        appointment.setPatient(patient);

        if (appointment.getInsurancePlan().isEmpty()) {
            appointment.setInsurancePlan(null);
        }
        if (appointment.getMedicalRecords().isEmpty()) {
            appointment.setMedicalRecords(null);
        }
        if (appointment.getMedication().isEmpty()) {
            appointment.setMedication(null);
        }

        appointmentRepository.save(appointment);

        return "redirect:/content";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "register_success";
    }

    @GetMapping("/users")
    public  String listUsers(Model model) {
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }
}
