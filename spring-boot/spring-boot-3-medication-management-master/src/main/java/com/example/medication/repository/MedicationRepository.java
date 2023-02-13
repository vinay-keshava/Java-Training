package com.example.medication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medication.model.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long>{

	Medication findByMedicationIdAndName(Long medicationId, String name);

}
