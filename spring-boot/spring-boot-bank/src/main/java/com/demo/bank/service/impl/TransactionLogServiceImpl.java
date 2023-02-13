package com.demo.bank.service.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bank.entity.Transaction;
import com.demo.bank.entity.TransactionLog;
import com.demo.bank.repository.AccountRepository;
import com.demo.bank.repository.TransactionLogRepository;
import com.demo.bank.service.TransactionLogService;

@Service
public class TransactionLogServiceImpl implements TransactionLogService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	TransactionLogRepository transactionLogRepository;
//	public List<TransactionLog> retrieveStatement(long accountNumber, LocalDate fromDate, LocalDate toDate) {
//		if (accountRepository.findByAccNumber(accountNumber) != null) {
//			return transactionLogRepository.findByAccountNumberAndDateBetween(accountNumber,fromDate, toDate);
//		}
//		return null;
//	}

	public List<TransactionLog> retrieveStatement(long accountNumber, String fromDate, String toDate)
			throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yyyy", Locale.ENGLISH);
//		LocalDate fromDate2 = LocalDate.parse(fromDate, formatter);				
//		LocalDate toDate2 = LocalDate.parse(toDate, formatter);
		LocalDate fromDate2 = LocalDate.parse("01-" + fromDate, DateTimeFormatter.ofPattern("d-MMM-yyyy"));
		LocalDate toDate2 = LocalDate.parse("01-" + toDate, DateTimeFormatter.ofPattern("d-MMM-yyyy"));
		if (accountRepository.findByAccNumber(accountNumber) != null) {
			return transactionLogRepository.findByAccountNumberAndDateBetween(accountNumber, fromDate2, toDate2);
		}
		return null;
	}
}
