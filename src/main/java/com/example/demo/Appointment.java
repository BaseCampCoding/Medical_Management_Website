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

    @Column(nullable = false, length = 10)
    String time;

    @Column(nullable = false, length = 10)
    String newPatient;

    @Column(nullable = false, length = 10)
    String sick;

    @Column(nullable = false, length = 10)
    String newPCP;

    @Column(nullable = false, length = 60)
    String clinic;

    @Column(nullable = false, length = 60)
    String doctor;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNewPatient() {
        return newPatient;
    }

    public void setNewPatient(String newPatient) {
        this.newPatient = newPatient;
    }

    public String getSick() {
        return sick;
    }

    public void setSick(String sick) {
        this.sick = sick;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getReason() {
        return reason;
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

    public String getNewPCP() {
        return newPCP;
    }

    public void setNewPCP(String newPCP) {
        this.newPCP = newPCP;
    }

    public int getWait() {
        return wait;
    }

    public void setWait(int wait) {
        this.wait = wait;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public void waitTime() {
        if (this.urgent){
            this.wait = num.nextInt(2);
        } else {
            this.wait = num.nextInt(8);
        }
    }
    public void urgency(){
        this.urgent = this.sick.equalsIgnoreCase("yes");
    }
    public void appointmentDetails() {
        System.out.println("\ntime: " + this.time);
        System.out.println("newPatient: " + this.newPatient);
        System.out.println("New PCP: " + this.newPCP);
        System.out.println("sick: " + this.sick);
        System.out.println("clinic: " + this.clinic);
        System.out.println("doctor: " + this.doctor);
        System.out.println("reason: " + this.reason);
        if (this.insurancePlan.equals("null")){
            System.out.println("insurancePlan: N/A");
        } else {
            System.out.println("insurancePlan: " + this.insurancePlan);

        }
        if (this.medicalRecords.equals("null")){
            System.out.println("medicalRecords: N/A");
        } else {
            System.out.println("medicalRecords: " + this.medicalRecords);

        }
        if (this.medication.equals("null")){
            System.out.println("medication: N/A\n");
        } else {
            System.out.println("medication: " + this.medication + "\n");

        }
    }
}
