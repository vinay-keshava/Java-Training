package com.example.medication.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DoctorUpdate {

	@NotNull(message = "Speciality is required")
	@Pattern(regexp = "[a-zA-Z ]+",message = "Please Enter a valid speciality")
	private String speciality;
	
	@NotNull(message = "Address is a required field")
	@Size(max = 100)
	private String address;
	
	@NotNull(message = "Email is required")
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Enter a valid Email Id")
	@Column(unique = true)
	private String email;

}
