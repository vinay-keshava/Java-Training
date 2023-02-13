package com.demo.bank.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bank.entity.Account;
import com.demo.bank.entity.Transaction;
import com.demo.bank.entity.TransactionLog;
import com.demo.bank.repository.AccountRepository;
import com.demo.bank.repository.TransactionLogRepository;
import com.demo.bank.repository.TransactionRepository;
import com.demo.bank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private TransactionLogRepository transactionLogRepository;

	@Override
	public String fundTransfer(Transaction transaction, Account sender, Account receiver) {
		LocalDate presentDate = LocalDate.now();

		TransactionLog transaction1 = new TransactionLog();
		TransactionLog transaction2 = new TransactionLog();
		transaction.setDate(presentDate);
		transactionRepository.save(transaction);

		transaction1.setAccountNumber(sender.getAccNumber());
		transaction1.setTransactionDetails(receiver.getAccNumber());
		transaction1.setDate(presentDate);
		transaction1.setTransactionAmount(transaction.getTransactionAmount());
		transaction1.setTransactionId(transaction.getTransactionId());
		transaction1.setWithDrawalOrDeposit("Withdrawal");
		// sender-> receiver sender -> withdrawal receiver-> deposit
		receiver.setBalance(receiver.getBalance() + transaction.getTransactionAmount());
		sender.setBalance(sender.getBalance() - transaction.getTransactionAmount());
		transaction1.setCurrentBalance(sender.getBalance());

		transaction2.setTransactionId(transaction.getTransactionId());
		transaction2.setTransactionDetails(sender.getAccNumber());
		transaction2.setAccountNumber(receiver.getAccNumber());
		transaction2.setCurrentBalance(receiver.getBalance());
		transaction2.setWithDrawalOrDeposit("Deposit");
		transaction2.setCurrentBalance(receiver.getBalance());
		transaction2.setDate(presentDate);
		transaction2.setTransactionAmount(transaction.getTransactionAmount());

		transactionLogRepository.save(transaction1);
		transactionLogRepository.save(transaction2);
		return "Successfully transferred";

	}

//	public List<Transaction> retrieveStatement(long accountNumber, LocalDate endDate, LocalDate startDate){
//		if(accountRepository.findByAccNumber(accountNumber)!=null) {
//			return transactionRepository.findAllByDateBetween(endDate, startDate);
//		}
//		return null;
//	}

}
