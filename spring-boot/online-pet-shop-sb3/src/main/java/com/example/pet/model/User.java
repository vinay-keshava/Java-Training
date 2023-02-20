package com.example.pet.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@NotNull(message = "UserName Required field")
	@Column(unique = true)
	private String username;
	
	@NotNull(message = "required field")
	private String password;
	
	@NotNull(message = "Mandatory Field")
	private String login;

	@NotNull(message = "Email is required field")
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Enter a valid Email Id")
	private String email;
}
