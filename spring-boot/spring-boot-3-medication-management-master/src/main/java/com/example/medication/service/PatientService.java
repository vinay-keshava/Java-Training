package com.example.medication.service;

import java.util.Optional;

import com.example.medication.dto.PatientDto;
import com.example.medication.dto.PatientUpdate;
import com.example.medication.model.Patient;

import jakarta.validation.Valid;

public interface PatientService {

	Patient newPatient(@Valid  PatientDto patientDto);

	Patient particularPatient(Long userId);

	Optional<Patient> deletePatient(String email);

	Patient updatePatient(@Valid PatientUpdate patientUpdate, String email, Long userID);

}
