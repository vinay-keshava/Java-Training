package com.demo.bank.repository;

import com.demo.bank.entity.Transaction;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//	List<Transaction> findByAccountNumberAndDateBetween(long accountNumber, LocalDate endDate, LocalDate startDate);


}
