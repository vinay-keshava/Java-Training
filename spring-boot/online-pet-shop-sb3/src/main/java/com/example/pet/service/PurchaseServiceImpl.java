package com.example.pet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pet.dto.PurchaseDto;
import com.example.pet.dto.Response;
import com.example.pet.exception.NoPurchaseHistoryException;
import com.example.pet.exception.QuantityException;
import com.example.pet.exception.UserNotFoundException;
import com.example.pet.exception.UserNotLoggedInException;
import com.example.pet.model.Pet;
import com.example.pet.model.Purchase;
import com.example.pet.model.User;
import com.example.pet.repository.PetRepository;
import com.example.pet.repository.PurchaseRepository;
import com.example.pet.repository.UserRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	PetRepository petRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PurchaseRepository purchaseRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Response purchasePets(PurchaseDto purchaseDto) throws QuantityException {
		List<String> list = new ArrayList<>();
		User user = userRepository.findByusernameAndPassword(purchaseDto.getUsername(), purchaseDto.getPassword());
		Pet pet = petRepository.findBypetid(purchaseDto.getPetId());

		if (user.getLogin() == "No" || user.getLogin() == "no") {
			logger.error("User not logged in ");
			throw new UserNotLoggedInException("please login before purchasing pet");
		}
		if(pet==null){
			logger.warn("Pet not found with petid -"+purchaseDto.getPetId());
			throw new NoSuchElementException("No such pet found ");
		}

		if ((pet.getQuantity() - purchaseDto.getQuantity() <= 0)
				|| (pet.getQuantity() <= 0)) {
			logger.warn("The quantity requested is not available");
			throw new QuantityException("Quantity not available we have only " + pet.getQuantity());
		}
		Purchase purchase = new Purchase();
		BeanUtils.copyProperties(purchaseDto, purchase);
		
		pet.setQuantity(pet.getQuantity() - purchaseDto.getQuantity());
		petRepository.save(pet);
		purchase.setUserId(user.getUserId());
		purchaseRepository.save(purchase);
		list.add("Purchase Successfull");
		logger.info("Pet Purchased Successfull");
		return new Response(list, 200);

	}

	@Override
	public List<Purchase> petPurchaseHistoryOfUser(String username) {
		User user = userRepository.findByusername(username);
		if (user == null) {
			logger.warn("User is not valid");
			throw new UserNotFoundException("User Not Found please Register");
		}
		if (user.getLogin() == "No" || user.getLogin() == "no") {
			logger.warn("User not logged in");
			throw new UserNotLoggedInException("Please Login before you purchase ");
		}
		if (purchaseRepository.findAllByuserId(user.getUserId()) == null) {
			logger.warn("No purchase history for the user name-"+user.getUsername());
			throw new NoPurchaseHistoryException("No Purchase History with the user name " + user.getUsername());
		}
		List<Purchase> list = new ArrayList<>();
		list.addAll(purchaseRepository.findAllByuserId(user.getUserId()));
		logger.info("Pet Purchase History ");
		return list;
	}

}