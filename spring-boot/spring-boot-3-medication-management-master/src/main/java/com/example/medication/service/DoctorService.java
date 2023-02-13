package com.example.medication.service;

import java.util.Optional;

import com.example.medication.dto.DoctorDto;
import com.example.medication.dto.DoctorUpdate;
import com.example.medication.model.Doctor;

import jakarta.validation.Valid;

public interface DoctorService {

	Doctor createNewDoctor(DoctorDto doctorDto);

	Doctor updateExistingDoctorInformation(@Valid DoctorUpdate doctorUpdate, String contactNumber);

	Optional<Doctor> getDoctorById(Long doctorId);

}
