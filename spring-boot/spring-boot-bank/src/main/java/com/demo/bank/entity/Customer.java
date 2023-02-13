package com.demo.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long custId;

	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String panCard;
	private String email;
	private String phone;
	private String city;
	private String State;

}
