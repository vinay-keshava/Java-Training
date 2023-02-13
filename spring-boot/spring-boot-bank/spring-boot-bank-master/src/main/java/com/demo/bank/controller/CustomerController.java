package com.demo.bank.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bank.entity.Customer;
import com.demo.bank.repository.AccountRepository;
import com.demo.bank.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerServiceImpl;
	@Autowired
	AccountRepository accountRepo;

	@GetMapping("/customers")
	public List<Customer> allCustomers() {
		return customerServiceImpl.findAllCustomer();
	}

	@PostMapping("/customers")
	public String newCustomer(@RequestBody Customer customer, @RequestParam String accountType,
			@RequestParam float balance) {
		if (customer.getAge() >= 18) {
			if (isValidEmail(customer.getEmail())) {
				if (isValidPanCard(customer.getPanCard())) {
					if (isValidPhone(customer.getPhone())) {
						boolean exit = true;
						long accountNumber = (long) (Math.random() * Math.pow(10, 10));
						while (exit) {
							if (accountRepo.findByAccNumber(accountNumber) == null) {
								customerServiceImpl.insertNewCustomer(customer, accountType, balance, accountNumber);
								exit = false;
								return "Successfull, Created Account";
							}
						}
					}
					return "Please Enter proper Phone Number";
				}
				return "Please Enter Valid Pan Card";
			}
			return "Please Enter Valid Email";
		}
		return "Sorry Account cannot be created You should be greater than 18";
	}

	public static boolean isValidEmail(String email) {
		final Pattern emailRegex = Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+$", Pattern.CASE_INSENSITIVE);
		return emailRegex.matcher(email).matches();
	}

	public static boolean isValidPanCard(String panCard) {
		final Pattern panCardRegex = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}", Pattern.CASE_INSENSITIVE);
		return panCardRegex.matcher(panCard).matches();

	}

	public static boolean isValidPhone(String phone) {
		final Pattern phoneRegex = Pattern.compile("(0/91)?[6-9][0-9]{9}");
		return phoneRegex.matcher(phone).matches();
	}
}