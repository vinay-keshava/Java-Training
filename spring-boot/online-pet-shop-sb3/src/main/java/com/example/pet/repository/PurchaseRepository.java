package com.example.pet.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pet.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

	Collection<? extends Purchase> findAllByuserId(long userId);

	

}
