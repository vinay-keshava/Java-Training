package com.example.medication.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Entity
@Data
public class Medication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long medicationId;

	private String name;
	private String description;
	private String dosage;
	
	@Min(1)
	private int frequency;
	
	@PastOrPresent
	private LocalDate startDate;
	
	@FutureOrPresent
	private LocalDate endDate;
	
	@AssertTrue
	// annotated boolean field must be true for the validation to pass
	private Boolean active;
	
}

