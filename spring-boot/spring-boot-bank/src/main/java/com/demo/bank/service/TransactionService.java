package com.demo.bank.service;

import java.time.LocalDate;
import java.util.List;

import com.demo.bank.entity.Account;
import com.demo.bank.entity.Transaction;

public interface TransactionService {

	String fundTransfer(Transaction transaction, Account sender, Account receiver);

	
}
