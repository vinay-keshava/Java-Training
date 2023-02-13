package com.example.medication.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medication.dto.MedicationDto;
import com.example.medication.dto.MedicationUpdate;
import com.example.medication.model.Medication;
import com.example.medication.repository.MedicationRepository;
import com.example.medication.service.MedicationService;

@Service
public class MedicationSerImpl implements MedicationService{
	
	@Autowired
	MedicationRepository medicationRepository;
	
	@Override
	public Medication newMedication(MedicationDto medicationDto) {
		Medication medication=new Medication();
		BeanUtils.copyProperties(medicationDto, medication);
		return medicationRepository.save(medication);
	}

	@Override
	public Medication updateMedication(MedicationUpdate medicationUpdate,Long medicationId,String name) {
		Medication medication = medicationRepository.findByMedicationIdAndName(medicationId,name);
		BeanUtils.copyProperties(medicationUpdate, medication);
		return medicationRepository.save(medication);
	}
}
