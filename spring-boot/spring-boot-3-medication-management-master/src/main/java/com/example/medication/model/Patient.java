package com.example.medication.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;

	@NotNull(message = "First Name is Required")
	@Pattern(regexp = "[a-zA-z ]+",message = "Please Enter a Valid First Name")
	@Size(min=5,max = 20)
	private String firstName;
	
	@NotNull(message = "First Name is Required")
	@Pattern(regexp = "[a-zA-z ]+",message = "Please Enter a Valid Last Name")
	@Size(min=5,max = 20)
	private String lastName;
	
	@Min(1)
	private int age;
	
	@NotNull(message = "Email is required")
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Enter a valid Email Id")
	private String email;
	
	@NotNull(message = "Address is a mandatory field")
	private String address;
	
	@CreationTimestamp
	@PastOrPresent
	private LocalDateTime dateOfAdmission;

}
