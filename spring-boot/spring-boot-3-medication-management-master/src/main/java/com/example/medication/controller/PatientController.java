package com.example.medication.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.medication.dto.PatientDto;
import com.example.medication.dto.PatientUpdate;
import com.example.medication.model.Patient;
import com.example.medication.service.PatientService;

import jakarta.validation.Valid;

@RestController("/patient")
public class PatientController {

	@Autowired
	PatientService patientServiceImpl;

	@PostMapping("/newPatient")
	public ResponseEntity<Patient> addPatient(@Valid  @RequestBody PatientDto patientCreate) {
		return new ResponseEntity<>(patientServiceImpl.newPatient(patientCreate), HttpStatus.OK);
	}

	@GetMapping("/{patientid}")
	public ResponseEntity<Patient> getParticularPatient(@PathVariable("patientid") Long userId) {
		return new ResponseEntity<>(patientServiceImpl.particularPatient(userId), HttpStatus.OK);
	}

	@DeleteMapping("/{patientEmail}")
	public ResponseEntity<Optional<Patient>> dropPatient(@PathVariable("patientEmail") String email) {
		return new ResponseEntity<>(patientServiceImpl.deletePatient(email), HttpStatus.OK);

	}

	@PutMapping("/update-patient")
	public ResponseEntity<Patient> updatePatient(@Valid @RequestBody PatientUpdate patientUpdate, @RequestParam String email,
			@RequestParam Long userId) {
		return new ResponseEntity<>(patientServiceImpl.updatePatient(patientUpdate, email, userId), HttpStatus.OK);
	}
}
