package com.example.pet.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pet.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long>{
	List<Pet> findBycategory(String categoryName);

	Collection<? extends Pet> findAllByCategoryLikeIgnoreCase(String categoryName);

	Pet findBypetid(long petid);

}
