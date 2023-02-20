package com.example.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet.dto.PetDto;
import com.example.pet.exception.CategoryNotFoundException;
import com.example.pet.model.Pet;
import com.example.pet.service.PetServiceImplementation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController("/api/pets")
public class PetController {

	@Autowired
	PetServiceImplementation petSerivceImpl;

	@GetMapping("/search")
	public ResponseEntity<List<Pet>> searchPet(@Min(value = 3,message = "category name length insufficient") @RequestParam String categoryname) throws CategoryNotFoundException {
		return new ResponseEntity<List<Pet>>(petSerivceImpl.searchByCategory(categoryname), HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<Pet> addPet(@Valid @RequestBody PetDto petDto) {
		return new ResponseEntity<Pet>(petSerivceImpl.addPet(petDto), HttpStatus.OK);
	}
	
	@PutMapping("/quantity")
	public ResponseEntity<Pet> updateQuantity(@RequestParam long petid,@RequestParam int quantity){
		return new ResponseEntity<>(petSerivceImpl.updateQuantity(petid,quantity),HttpStatus.OK);
	}
}
