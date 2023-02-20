package com.example.pet.service;

import com.example.pet.dto.LoginDto;
import com.example.pet.dto.Response;
import com.example.pet.dto.UserDto;
import com.example.pet.model.User;

public interface UserService {

	User newUser(UserDto userDto);

	Response login(LoginDto loginDto);

}
