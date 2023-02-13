package com.example.medication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.medication.dto.MedicationDto;
import com.example.medication.dto.MedicationUpdate;
import com.example.medication.model.Medication;
import com.example.medication.service.impl.MedicationSerImpl;

import jakarta.validation.Valid;

@RestController("/medication")
public class MedicationController {

	@Autowired
	MedicationSerImpl medicationSerImpl;
	
	@PostMapping("/new-medication")
	public ResponseEntity<Medication> newMedication(@Valid @RequestBody MedicationDto medicationDto){

		return new ResponseEntity<>(medicationSerImpl.newMedication(medicationDto),HttpStatus.OK);
	}
	@PutMapping("/update-medication")
	public ResponseEntity<Medication> updateMedication(@Valid @RequestBody MedicationUpdate medicationUpdate,@RequestParam Long medicationId,@RequestParam String name){
		return new ResponseEntity<>(medicationSerImpl.updateMedication(medicationUpdate,medicationId, name),HttpStatus.OK);
	}
}
