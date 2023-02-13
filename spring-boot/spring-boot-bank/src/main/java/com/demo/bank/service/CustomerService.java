package com.demo.bank.service;


import java.util.List;

import com.demo.bank.entity.Customer;

public interface CustomerService {

	String insertNewCustomer(Customer customer, String accountType, float balance, Long accountNumber);
	
	List<Customer> findAllCustomer();
}
