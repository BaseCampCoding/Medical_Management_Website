package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AppointmentRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppointmentRepository apptRepository;

    @Test
    public void testCreateAppointment() {
        User doctor = userRepository.findDoctorById(2L);
        User patient = userRepository.findPatientById(1L);
        Appointment appointment = new Appointment();

        appointment.setTime("1:00PM");
        appointment.setNewPatient(true);
        appointment.setSick(true);
        appointment.setNewPCP(false);
        appointment.setClinic("Takemi Medical Clinic");
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setReason("I need new medication");
        appointment.setInsurancePlan(null);
        appointment.setMedicalRecords(null);
        appointment.setMedication(null);

        Appointment savedAppointment = apptRepository.save(appointment);

        Appointment existAppointment = entityManager.find(Appointment.class, savedAppointment.getId());

        assertThat(appointment.getDoctor().getFirstName().equals(existAppointment.getDoctor().getFirstName()));
        assertThat(appointment.getDoctor().getLastName().equals(existAppointment.getDoctor().getLastName()));

    }
}
