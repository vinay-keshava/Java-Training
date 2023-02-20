package com.example.pet.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoPurchaseHistoryException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private final String message;
	public NoPurchaseHistoryException(String message) {
		super();
		this.message = message;
	}
}
