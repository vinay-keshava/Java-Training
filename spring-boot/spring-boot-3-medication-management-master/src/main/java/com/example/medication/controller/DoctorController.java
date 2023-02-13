package com.example.medication.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.medication.dto.DoctorDto;
import com.example.medication.dto.DoctorUpdate;
import com.example.medication.model.Doctor;
import com.example.medication.service.impl.DoctorServiceImpl;

import jakarta.validation.Valid;

@RestController("/doctor")
public class DoctorController {

	@Autowired
	DoctorServiceImpl doctorServiceImpl;
	
	@PostMapping("/add-doctor")
	public  ResponseEntity<Doctor> newDoctorEntry(@Valid @RequestBody DoctorDto doctorDto) {
		return new ResponseEntity<>(doctorServiceImpl.createNewDoctor(doctorDto),HttpStatus.OK);
	}
	
	@GetMapping("/{DoctorId}")
	public ResponseEntity<Optional<Doctor>> getDoctorById(@PathVariable("DoctorId") Long doctorId){
		return new ResponseEntity<>(doctorServiceImpl.getDoctorById(doctorId),HttpStatus.OK);

	}
	//putting some endpoint due to ambigous mapping exception (?) 
	@PutMapping("/updateDoctor")
	public ResponseEntity<Doctor> updateDoctor(@Valid @RequestBody DoctorUpdate doctorUpdate,@RequestParam String ContactNumber){
		return new ResponseEntity<>(doctorServiceImpl.updateExistingDoctorInformation(doctorUpdate, ContactNumber),HttpStatus.OK);
	}
}
