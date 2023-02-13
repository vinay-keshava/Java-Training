package com.example.medication.service;

import com.example.medication.dto.MedicationDto;
import com.example.medication.dto.MedicationUpdate;
import com.example.medication.model.Medication;

import jakarta.validation.Valid;

public interface MedicationService {

	Medication newMedication(@Valid MedicationDto medicationDto);

	Medication updateMedication(@Valid MedicationUpdate medicationUpdate, Long medicationId, String name);

}
