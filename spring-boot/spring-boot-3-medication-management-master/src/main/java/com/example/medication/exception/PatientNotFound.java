package com.example.medication.exception;

public class PatientNotFound  extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	private String message;

	public PatientNotFound(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
