package com.example.pet.service;

import java.util.List;

import com.example.pet.dto.PetDto;
import com.example.pet.exception.CategoryNotFoundException;
import com.example.pet.model.Pet;

public interface PetService {


	List<Pet> searchByCategory(String categoryName) throws CategoryNotFoundException;

	Pet addPet(PetDto petDto);

	Pet updateQuantity(long petid, int quantity);

}
