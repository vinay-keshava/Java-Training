package com.example.medication.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PatientUpdate {

	@NotNull(message = "Address is a mandatory field")
	private String address;
	
	@Min(1)
	private int age;
	
}
