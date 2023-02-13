package com.demo.bank.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TransactionLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long transactionId;
	private String withDrawalOrDeposit;
	private long accountNumber;
	private long transactionDetails;
	private float transactionAmount;
	private LocalDate date;
	private float currentBalance;
}
