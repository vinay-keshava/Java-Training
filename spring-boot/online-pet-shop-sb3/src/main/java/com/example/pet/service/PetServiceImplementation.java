package com.example.pet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet.dto.PetDto;
import com.example.pet.exception.CategoryNotFoundException;
import com.example.pet.model.Pet;
import com.example.pet.repository.PetRepository;

@Service
public class PetServiceImplementation implements PetService {

	@Autowired
	PetRepository petRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Pet> searchByCategory(String categoryName) throws CategoryNotFoundException {
		List<Pet> list = new ArrayList<>();
		String categoryNameRegex = "%" + categoryName + "%";
		list.addAll(petRepository.findAllByCategoryLikeIgnoreCase(categoryNameRegex));

		if (list == null || list.size() == 0) {
			throw new CategoryNotFoundException("Category Not Found Or not Available");
		} else {
			return list;
		}
	}

	@Override
	public Pet addPet(PetDto petDto) {
		Pet pet = new Pet();
		BeanUtils.copyProperties(petDto, pet);
		return petRepository.save(pet);
	}

	@Override
	public Pet updateQuantity(long petid, int quantity) {
		Pet pet = petRepository.findBypetid(petid);
		if (pet == null) {
			logger.warn("Pet not found");
			throw new NoSuchElementException("No such pet found");
		} else {
			pet.setQuantity(quantity);
			return petRepository.save(pet);
		}
	}

}
