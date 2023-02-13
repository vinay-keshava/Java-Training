package com.example.medication.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medication.dto.DoctorDto;
import com.example.medication.dto.DoctorUpdate;
import com.example.medication.model.Doctor;
import com.example.medication.repository.DoctorRepository;
import com.example.medication.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DoctorRepository doctorRepository;
	
	@Override
	public Doctor createNewDoctor(DoctorDto doctorDto) {
		Doctor doctor=new Doctor();
		BeanUtils.copyProperties(doctorDto, doctor);
		return doctorRepository.save(doctor);
	}
	
	@Override
	public Doctor updateExistingDoctorInformation(DoctorUpdate doctorUpdate,String contactNumber) {
		Doctor doctor=doctorRepository.findByContactNumber(contactNumber);
		BeanUtils.copyProperties(doctorUpdate, doctor);
		return doctorRepository.save(doctor);
	}
	@Override
	public Optional<Doctor> getDoctorById(Long doctorId) {
		return doctorRepository.findById(doctorId);
	}
}
