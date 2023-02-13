package com.example.medication.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medication.dto.PrescriptionDto;
import com.example.medication.model.Prescription;
import com.example.medication.repository.PrescriptionRepository;
import com.example.medication.service.PrescriptionService;

@Service
public class PrescriptionServImpl implements PrescriptionService{

	@Autowired
	PrescriptionRepository prescriptionRepository;
	
	public Prescription newPrescription(PrescriptionDto prescriptionDto) {
		Prescription prescription = new Prescription();
		BeanUtils.copyProperties(prescriptionDto, prescription);
		return prescriptionRepository.save(prescription);
	}
	
	
}
