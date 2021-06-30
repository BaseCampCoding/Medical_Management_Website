package com.example.demo;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "appointments")
public class Appointment {

    static Random num = new Random();
    int wait;
    boolean urgent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    User doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    User patient;

    @Column(nullable = false, length = 10)
    String time;

    @Column(nullable = false)
    boolean newPatient;

    @Column(nullable = false)
    boolean sick;

    @Column(nullable = false)
    boolean newPCP;

    @Column(nullable = false, length = 60)
    String clinic;

    @Column(nullable = false)
    String reason;

    @Column(nullable = true, length = 60)
    String insurancePlan;

    @Column(nullable = true)
    String medicalRecords;

    @Column(nullable = true)
    String medication;


    public static Random getNum() {
        return num;
    }

    public static void setNum(Random num) {
        Appointment.num = num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNewPatient() {
        return newPatient;
    }

    public void setNewPatient(boolean newPatient) {
        this.newPatient = newPatient;
    }

    public boolean isSick() {
        return sick;
    }

    public void setSick(boolean sick) {
        this.sick = sick;
    }

    public boolean isNewPCP() {
        return newPCP;
    }

    public void setNewPCP(boolean newPCP) {
        this.newPCP = newPCP;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public String getReason() {
        return reason;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getInsurancePlan() {
        return insurancePlan;
    }

    public void setInsurancePlan(String insurancePlan) {
        this.insurancePlan = insurancePlan;
    }

    public String getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(String medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public void waitTime() {
        if (this.urgent){
            this.wait = num.nextInt(2);
        } else {
            this.wait = num.nextInt(8);
        }
    }
    public void urgency(){
        this.urgent = this.sick;
    }
    public StringBuilder appointmentDetails() {
        StringBuilder appointStr = new StringBuilder();


        appointStr.append("Time: ").append(this.time);
        if (this.newPatient) {
            appointStr.append("\nNew Patient: Yes");
        } else {
            appointStr.append("\nNew Patient: no");
        }
        if (this.newPCP) {
            appointStr.append("\nNew PCP: Yes");
        } else {
            appointStr.append("\nNew PCP: no");
        }
        if (this.sick) {
            appointStr.append("\nSick: Yes");
        } else {
            appointStr.append("\nSick: no");
        }
        appointStr.append("\nClinic: ").append(this.clinic);
        appointStr.append("\nDoctor: ").append(this.doctor.getFullName());
        appointStr.append("\nReason: ").append(this.reason);
        if (this.insurancePlan == null){
            appointStr.append("\ninsurancePlan: N/A");
        } else {
            appointStr.append("\ninsurancePlan: ").append(this.insurancePlan);

        }
        if (this.medicalRecords == null){
            appointStr.append("\nmedicalRecords: N/A");
        } else {
            appointStr.append("\nmedicalRecords: ").append(this.medicalRecords);

        }
        if (this.medication == null){
            appointStr.append("\nmedication: N/A");
        } else {
            appointStr.append("\nmedication: ").append(this.medication);

        }
        return appointStr;
    }
}
