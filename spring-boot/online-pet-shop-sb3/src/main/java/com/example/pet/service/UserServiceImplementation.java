package com.example.pet.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet.dto.LoginDto;
import com.example.pet.dto.Response;
import com.example.pet.dto.UserDto;
import com.example.pet.exception.UserNotFoundException;
import com.example.pet.model.User;
import com.example.pet.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User newUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		return userRepository.save(user);
	}

	@Override
	public Response login(LoginDto loginDto) {

		Logger logger = LoggerFactory.getLogger(getClass());
		User user = new User();
		List<String> list = new ArrayList<>();
		user = userRepository.findByusernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		if (user != null) {
			user.setLogin("Yes");
			userRepository.save(user);
			list.add("Login SuccessFull");
			logger.info("User Logged in successfully");
			list.add(user.getUsername());
			return new Response(list, 200);
		} else {
			logger.error("Invalid Credentials or user Not found");
			throw new UserNotFoundException("Invalid Credentials or User Not Found");
		}
	}

	public Response logout(LoginDto logoutDto) {
		List<String> list = new ArrayList<>();
		User user = userRepository.findByusernameAndPassword(logoutDto.getUsername(), logoutDto.getPassword());
		if (user.getLogin() == null)
			throw new UserNotFoundException("User Not Found please Register");
		else { 	 
			user.setLogin("No");
			userRepository.save(user);
			list.add("Logout SuccessFull");
			return new Response(list, 200);
		}
		
	}

}
