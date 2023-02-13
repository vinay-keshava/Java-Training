package com.demo.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByAccNumber(long accountNumber);
	

	//boolean findByAccNumberContains(long accountNumber);
}
