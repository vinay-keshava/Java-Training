package com.example.testPet.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.pet.dto.LoginDto;
import com.example.pet.dto.Response;
import com.example.pet.dto.UserDto;
import com.example.pet.exception.UserNotFoundException;
import com.example.pet.model.User;
import com.example.pet.repository.UserRepository;
import com.example.pet.service.UserServiceImplementation;

@ExtendWith(SpringExtension.class)
class UserServiceImplementationTest {

	@InjectMocks
	UserServiceImplementation userServiceImplementation;

	@Mock
	UserRepository userRepository;

	@Test
	void newUserValid() {
		User user = new User();
		user.setEmail("hello@hello.in");
		user.setLogin("No");
		user.setUsername("micheal");
		user.setPassword("micheal");
		user.setUserId(1L);

		UserDto userDto = new UserDto();
		userDto.setEmail("hello@hello.in");
		userDto.setLogin("No");
		userDto.setUsername("micheal");
		userDto.setPassword("micheal");

		when(userRepository.save(any(User.class))).thenReturn(user);
		User saveduser = userServiceImplementation.newUser(userDto);
		assertEquals(user, saveduser);
	}

	@Test
	void newUserWithNullInput() {
		UserDto userDto = null;
		assertThrows(IllegalArgumentException.class, () -> {
			userServiceImplementation.newUser(userDto);
		});
	}

	@Test
	void testNewUserWithCopiedProperties() {
		UserDto userDto = new UserDto();
		userDto.setEmail("hello@hello.in");
		userDto.setLogin("No");
		userDto.setUsername("micheal");
		userDto.setPassword("micheal");

		User user = new User();
		BeanUtils.copyProperties(userDto, user);

		when(userRepository.save(user)).thenReturn(user);

		User savedUser = userServiceImplementation.newUser(userDto);

		assertEquals(user.getUsername(), savedUser.getUsername());
		assertEquals(user.getEmail(), savedUser.getEmail());
		verify(userRepository, times(1)).save(user);
	}

	@Test
	void loginWithNullInput() {
		LoginDto loginDto = null;
		assertThrows(NullPointerException.class, () -> {
			userServiceImplementation.login(loginDto);
		});
	}

	@Test
	void loginWithValidCredentials() {
		LoginDto loginDto = new LoginDto("hello", "hello");
		User user = new User();
		user.setEmail("vin@vinai.in");
		user.setLogin("No");
		user.setPassword("hello");
		user.setUsername("hello");
		when(userRepository.findByusernameAndPassword(loginDto.getUsername(), loginDto.getPassword())).thenReturn(user);
		Response response = userServiceImplementation.login(loginDto);
		verify(userRepository).save(user);
		assertEquals("Login SuccessFull", response.getMessages().get(0));
		assertEquals("hello", response.getMessages().get(1));
		assertEquals(200, response.getCode());
	}

	@Test
	void testLoginWithInvalidCredentials() {
		LoginDto loginDto = new LoginDto("wrong-username", "wrong-password");
		when(userRepository.findByusernameAndPassword(loginDto.getUsername(), loginDto.getPassword())).thenReturn(null);
		assertThrows(UserNotFoundException.class, () -> {
			userServiceImplementation.login(loginDto);
		});
	}

	@Test
	void testLogoutWithNullInput() {
		LoginDto loginDto = null;
		assertThrows(NullPointerException.class, () -> userServiceImplementation.logout(loginDto));
	}

	@Test
	void testLogoutWithValidCredentials() {
		LoginDto logoutDto = new LoginDto("johndoe", "password");
		User user = new User();
		user.setLogin("Yes");
		when(userRepository.findByusernameAndPassword(logoutDto.getUsername(), logoutDto.getPassword()))
				.thenReturn(user);
		Response response = userServiceImplementation.logout(logoutDto);
		assertNotNull(response);
		assertEquals(200, response.getCode());
		assertEquals("Logout SuccessFull", response.getMessages().get(0));
	}

}
