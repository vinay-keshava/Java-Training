package com.example.medication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.medication.dto.PrescriptionDto;
import com.example.medication.model.Prescription;
import com.example.medication.service.impl.PrescriptionServImpl;

import jakarta.validation.Valid;

@RestController("/prescription")
public class PrescriptionController {

	@Autowired
	PrescriptionServImpl prescriptionServImpl;
	
	@PostMapping("/add-prescription")
	public ResponseEntity<Prescription> addPrescription(@Valid @RequestBody PrescriptionDto prescriptionDto){
		return new ResponseEntity<>(prescriptionServImpl.newPrescription(prescriptionDto),HttpStatus.OK);
		
	}
}
