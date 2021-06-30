package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String username);

    @Query("SELECT u FROM User u WHERE u.id = ?1 AND role = 'doctor'")
    public User findDoctorById(Long id);

    @Query("SELECT u FROM User u WHERE u.id = ?1 AND role = 'patient'")
    public User findPatientById(Long id);

    @Query("SELECT u FROM User u WHERE role = 'doctor' ORDER BY last_name ASC")
    public <List>User findAllDoctors();
}