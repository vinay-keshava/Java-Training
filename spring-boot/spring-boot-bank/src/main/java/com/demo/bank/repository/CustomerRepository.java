package com.demo.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bank.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
