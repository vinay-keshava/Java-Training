package com.example.pet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petid;
	
	@NotNull(message = "Pet name is a required filed")
	private String petName;
	
	@NotNull(message = "Category of the pet is a required field")
	@Column(unique = true)
	private String category;
	
	@Min(1)
	@Max(100)
	private int Quantity;
	
}
