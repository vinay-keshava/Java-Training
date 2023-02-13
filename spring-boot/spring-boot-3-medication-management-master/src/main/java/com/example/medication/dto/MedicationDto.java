package com.example.medication.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Data
public class MedicationDto {
	
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
