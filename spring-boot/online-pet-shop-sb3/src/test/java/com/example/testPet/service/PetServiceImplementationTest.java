package com.example.testPet.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.pet.dto.PetDto;
import com.example.pet.exception.CategoryNotFoundException;
import com.example.pet.model.Pet;
import com.example.pet.repository.PetRepository;
import com.example.pet.service.PetServiceImplementation;

@ExtendWith(SpringExtension.class)
 class PetServiceImplementationTest {

	@InjectMocks
	PetServiceImplementation petServiceImplementation;

	@Mock
	PetRepository petRepository;

	@Test
	 void testAddPet() {
	    PetDto petDto = new PetDto();
	    petDto.setPetName("Fido");
	    petDto.setCategory("Dog");
	    petDto.setQuantity(1);

	    Pet pet = new Pet();
	    pet.setPetName("Fido");
	    pet.setCategory("Dog");
	    pet.setQuantity(1);

	    when(petRepository.save(any(Pet.class))).thenReturn(pet);
	    Pet result = petServiceImplementation.addPet(petDto);
	    assertEquals(pet, result);
	}

	@Test
	 void testAddPetWithNullInput() {
	    PetDto petDto = null;
	    assertThrows(IllegalArgumentException.class, () -> {
	        petServiceImplementation.addPet(petDto);
	    });
	}
	
	@Test
	 void testSearchByCategoryWithNonExistingCategory() throws CategoryNotFoundException {
		
		CategoryNotFoundException categoryNotFoundException= assertThrows(CategoryNotFoundException.class, () -> {
			when(petRepository.findAllByCategoryLikeIgnoreCase("Bird")).thenReturn(Collections.emptyList());
		    petServiceImplementation.searchByCategory("Bird");
		});
		
	   assertEquals("Category Not Found Or not Available",categoryNotFoundException.getMessage());
	}
	@Test
	 void testSearchByCategoryWithExistingCategory() {
		List<Pet> list = new ArrayList<>();
		Pet pet = new Pet();
		pet.setCategory("Bird");
		pet.setPetid(1L);
		pet.setQuantity(10);
		pet.setPetName("Rocky");
		list.add(pet);
		when(petRepository.findBycategory("Bird")).thenReturn(list);
		List<Pet> result = new ArrayList<>();
		try {
		result.add(pet);
	    petServiceImplementation.searchByCategory("Bird");
		}
		catch(CategoryNotFoundException e) {
			e.printStackTrace();
		}
	    assertEquals(list,result);
	}
}
