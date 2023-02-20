package com.example.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet.dto.LoginDto;
import com.example.pet.dto.Response;
import com.example.pet.dto.UserDto;
import com.example.pet.model.User;
import com.example.pet.service.UserServiceImplementation;

import jakarta.validation.Valid;

@RestController("/api/user")
public class UserController {

	@Autowired
	UserServiceImplementation userServiceImpl;

	@PutMapping("/login")
	public ResponseEntity<Response> userLogin(@Valid @RequestBody LoginDto loginDto) {
		return new ResponseEntity<>(userServiceImpl.login(loginDto), HttpStatus.OK);
	}

	@PutMapping("/logout")
	public ResponseEntity<Response> userLogout(@Valid @RequestBody LoginDto logoutDto) {
		return new ResponseEntity<>(userServiceImpl.logout(logoutDto), HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<User> newUser(@Valid @RequestBody UserDto userDto) {
		return new ResponseEntity<>(userServiceImpl.newUser(userDto), HttpStatus.OK);
	}

}
