package com.example.pet.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long purchaseId;
	
	@NotNull(message = "Pet id is a required filed")
	private long petId;
	
	@NotNull(message = "User ID is a required filed")
	private long userId;
	
	@CreationTimestamp
	private LocalDateTime purchaseDate;
	
	@Min(1)
	@Max(100)
	private int quantity;
}
