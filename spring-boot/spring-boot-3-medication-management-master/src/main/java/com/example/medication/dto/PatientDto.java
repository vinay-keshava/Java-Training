package com.example.medication.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientDto {

	@NotNull(message = "First Name is Required")
	@Pattern(regexp = "[a-zA-z ]+",message = "Please Enter a Valid First Name")
	@Size(min=5,max = 20)
	private String firstName;
	
	@NotNull(message = "First Name is Required")
	@Pattern(regexp = "[a-zA-z ]+",message = "Please Enter a Valid Last Name")
	@Size(min=5,max = 20)
	private String lastName;
	
	private int age;
	
	@NotNull(message = "Email is required")
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Enter a valid Email Id")
	private String email;
	
	private String address;
	
	
}
