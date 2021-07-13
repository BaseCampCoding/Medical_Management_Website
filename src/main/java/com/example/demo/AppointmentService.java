package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AppointmentService {

    @Autowired
    private AppointmentRepository appRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Appointment> listAll(Long ID) {return appRepo.findAppointmentByPatientId(ID);}

    public Appointment get(Long id) {
        return appRepo.findById(id).get();
    }


}
