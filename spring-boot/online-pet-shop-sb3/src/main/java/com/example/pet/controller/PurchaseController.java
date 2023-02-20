package com.example.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pet.dto.PurchaseDto;
import com.example.pet.dto.Response;
import com.example.pet.exception.QuantityException;
import com.example.pet.model.Purchase;
import com.example.pet.service.PurchaseServiceImpl;

import jakarta.validation.Valid;

@RestController("/api/purchase")
public class PurchaseController {

	@Autowired
	PurchaseServiceImpl purchaseServiceImpl;
	
	@PostMapping("/pets")
	public ResponseEntity<Response> purchasePets(@Valid @org.springframework.web.bind.annotation.RequestBody PurchaseDto purchaseDto) throws QuantityException {
		return new ResponseEntity<>(purchaseServiceImpl.purchasePets(purchaseDto), HttpStatus.OK);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Purchase>> petPurchaseHistoryofUser(@RequestParam String username) {
		return new ResponseEntity<>(purchaseServiceImpl.petPurchaseHistoryOfUser(username), HttpStatus.OK);
	}
}
