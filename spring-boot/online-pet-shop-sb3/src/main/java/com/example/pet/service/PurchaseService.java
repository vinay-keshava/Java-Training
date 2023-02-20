package com.example.pet.service;

import java.util.List;

import com.example.pet.dto.PurchaseDto;
import com.example.pet.dto.Response;
import com.example.pet.exception.QuantityException;
import com.example.pet.model.Purchase;

public interface PurchaseService {

	Response purchasePets(PurchaseDto purchaseDto) throws QuantityException;


	List<Purchase> petPurchaseHistoryOfUser(String username);

}
