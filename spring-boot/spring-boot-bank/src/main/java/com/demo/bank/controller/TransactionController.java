package com.demo.bank.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bank.entity.Account;
import com.demo.bank.entity.Transaction;
import com.demo.bank.entity.TransactionLog;
import com.demo.bank.exception.AccountNotFoundException;
import com.demo.bank.repository.AccountRepository;
import com.demo.bank.service.impl.TransactionLogServiceImpl;
import com.demo.bank.service.impl.TransactionServiceImpl;

@RestController
public class TransactionController {

	@Autowired
	private TransactionServiceImpl transactionService;
	@Autowired
	private TransactionLogServiceImpl transactionLogServiceImpl;
	
	@Autowired
	private AccountRepository accountRepository;

	@PostMapping("/transaction")
	public String TransferFunds(@RequestBody Transaction transaction) throws  AccountNotFoundException {
		Account sender = accountRepository.findByAccNumber(transaction.getSenderAccountNumber());
		Account receiver = accountRepository.findByAccNumber(transaction.getReceiverAccountNumber());
		if (sender != null && receiver != null && sender.getBalance()-transaction.getTransactionAmount() > 0)
			return transactionService.fundTransfer(transaction, sender, receiver);
		else
			return "Could not find bank Accounts please verify once again";
	}

//	@GetMapping("/transaction")
//	public List<TransactionLog> showStatement(@Valid @RequestParam long accountNumber,
//			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
//			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
//		return transactionLogServiceImpl.retrieveStatement(accountNumber,fromDate, toDate);
//
//	}
	
	@GetMapping("/transaction")
	public List<TransactionLog> showStatement(@Valid @RequestParam long accountNumber,@RequestParam String fromDate,@RequestParam String toDate) throws ParseException {
		return transactionLogServiceImpl.retrieveStatement(accountNumber,fromDate, toDate);

	}
}
