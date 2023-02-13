package com.example.medication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medication.dto.PatientDto;
import com.example.medication.dto.PatientUpdate;
import com.example.medication.exception.PatientNotFound;
import com.example.medication.model.Patient;
import com.example.medication.repository.PatientRepository;
import com.example.medication.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;

	public List<Patient> getAllPatient() {
		return patientRepository.findAll();
	}

	@Override
	public Patient newPatient(PatientDto patientDto) {
		Patient patient = new Patient();
		BeanUtils.copyProperties(patientDto, patient);
		return patientRepository.save(patient);
	}

	@Override
	public Patient particularPatient(Long patientId) {
		Patient patient= patientRepository.findPatientByPatientId(patientId);
		if(patient==null) {
			throw new PatientNotFound("Patient Not Found");
		}
		return patient;
	}

	@Override
	public Optional<Patient> deletePatient(String email) {
		Patient patient = patientRepository.findByEmail(email).get();
		patientRepository.delete(patient);
		return Optional.of(patient);
	}

	@Override
	public Patient updatePatient(PatientUpdate patientUpdate, String email, Long userID) {
		Patient patient = patientRepository.findByEmailAndPatientId(email, userID);
		BeanUtils.copyProperties(patientUpdate, patient);
		return patientRepository.save(patient);
	}

}
