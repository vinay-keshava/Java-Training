package com.example.medication.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DoctorDto {

	@NotNull(message = "First Name is Required")
	@Pattern(regexp = "[a-zA-z ]+",message = "Please Enter a Valid First Name")
	@Size(min=5,max = 20)
	private String firstName;
	
	@NotNull(message = "Last Name is required")
	@Pattern(regexp = "[a-zA-Z ]+",message = "Please Enter a valid last name")
	@Size(min=5,max = 20)
	private String lastName;
	
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
	
	@NotNull(message = "Contact number is a required field")
	@Pattern(regexp = "[6789][0-9]{9}",message = "Enter a valid indian contact number")
	@Column(unique = true)
	private String contactNumber;
	
	@Min(24)
	@Max(60)
	private int age;
	
}
