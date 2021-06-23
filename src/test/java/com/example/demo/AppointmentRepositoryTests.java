package com.example.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AppointmentRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AppointmentRepository repository;

    @Test
    public void testCreateAppointment() {
        Appointment appointment = new Appointment();

//    @Column(nullable = false, length = 10)
//    String newPatient;
//
//    @Column(nullable = false, length = 10)
//    String sick;
//
//    @Column(nullable = false, length = 10)
//    String newPCP;
//
//    @Column(nullable = false, length = 60)
//    String clinic;
//
//    @Column(nullable = false, length = 60)
//    String doctor;
//
//    @Column(nullable = false)
//    String reason;
//
//    @Column(nullable = true, length = 60)
//    String insurancePlan;
//
//    @Column(nullable = true)
//    String medicalRecords;
//
//    @Column(nullable = true)
//    String medication;
        appointment.setTime("1:00PM");
        appointment.setNewPatient("Yes");
        appointment.setSick("No");
        appointment.setNewPCP("No");
        appointment.setClinic("Takemi Medical Clinic");
        appointment.setDoctor("Tae Takemi");
        appointment.setReason("I need new medication");
        appointment.setInsurancePlan(null);
        appointment.setMedicalRecords(null);
        appointment.setMedication(null);

        Appointment savedAppointment = repository.save(appointment);

        Appointment existUser = entityManager.find(Appointment.class, savedAppointment.getId());
        

    }
}
