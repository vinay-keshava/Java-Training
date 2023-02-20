package com.example.pet.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PetDto {

	@NotNull(message = "Pet name is a required filed")
	private String petName;
	
	@NotNull(message = "Category name is a required filed")
	private String category;
	
	@Min(1)
	@Max(100)
	private int Quantity;
}
