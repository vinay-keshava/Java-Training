package com.example.medication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medication.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	Doctor findByContactNumber(String contactNumber);

	
}
