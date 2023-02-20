package com.example.pet.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PurchaseDto {

	@NotNull(message = "Pet Id is a required filed")
	private long petId;

	@NotNull(message = "User ID is a required filed")
	private String username;
	
	@NotNull(message = "Password is a required filed")
	private String password;
	
	@Min(1)
	@Max(100)
	private int quantity;
}
