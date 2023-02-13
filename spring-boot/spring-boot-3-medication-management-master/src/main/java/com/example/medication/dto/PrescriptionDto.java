package com.example.medication.dto;

import java.util.List;

import com.example.medication.model.Doctor;
import com.example.medication.model.Medication;
import com.example.medication.model.Patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PrescriptionDto {

	@NotNull(message = "Notes or remarks is a mandotory field")
	private String notes;
	
	@Valid
	private Patient patient;

	@Valid
	private Doctor doctor;
	
	@Valid
	private List<Medication> medicationId;
}
