package com.demo.bank.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bank.entity.Transaction;
import com.demo.bank.entity.TransactionLog;

@Repository
public interface TransactionLogRepository  extends JpaRepository<TransactionLog, Long>{

//	List<Transaction> findAllByDateBetween(LocalDate endDate, LocalDate startDate);
//	List<TransactionLog> findByAccountNumberAndDateBetween(long accountNumber,LocalDate endDate, LocalDate startDate);
	List<TransactionLog> findByAccountNumberAndDateBetween(long accountNumber,LocalDate endDate, LocalDate startDate);

}
