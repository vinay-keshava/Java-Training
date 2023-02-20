package com.example.pet.exception;

public class QuantityException extends Exception {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public QuantityException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
