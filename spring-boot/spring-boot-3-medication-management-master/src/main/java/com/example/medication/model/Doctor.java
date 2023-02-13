package com.example.medication.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorId;
	
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
	
	@CreationTimestamp
	@PastOrPresent
	private LocalDateTime dateOfJoining;
	
	@NotNull(message = "Contact number is a required field")
	@Pattern(regexp = "[6789][0-9]{9}",message = "Enter a valid indian contact number")
	@Column(unique = true)
	private String contactNumber;
	
	@NotNull(message = "Email is required")
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Enter a valid Email Id")
	@Column(unique = true)
	private String email;
	
	@Min(24)
	@Max(60)
	private int age;

}
