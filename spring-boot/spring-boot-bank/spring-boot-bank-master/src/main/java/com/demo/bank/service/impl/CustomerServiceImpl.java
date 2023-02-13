package com.demo.bank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bank.entity.Account;
import com.demo.bank.entity.Customer;
import com.demo.bank.repository.AccountRepository;
import com.demo.bank.repository.CustomerRepository;
import com.demo.bank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private AccountRepository accRepo;
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public String insertNewCustomer(Customer customer, String accountType, float balance, Long accountNumber) {
		customerRepo.save(customer);
		Account a1 = new Account();
		a1.setAccNumber(accountNumber);
		a1.setCustomerId(customer.getCustId());
		a1.setAccType(accountType);
		a1.setBalance(balance);
		accRepo.save(a1);
		return accountType;

	}

	@Override
	public List<Customer> findAllCustomer() {
		return customerRepo.findAll();
	}

}
