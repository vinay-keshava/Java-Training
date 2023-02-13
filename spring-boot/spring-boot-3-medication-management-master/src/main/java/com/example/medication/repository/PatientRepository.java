package com.example.medication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medication.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	Optional<Patient> findByEmail(String email);

	Patient findByEmailAndPatientId(String email,Long userId);

	Patient findPatientByPatientId(Long patientId);


}
