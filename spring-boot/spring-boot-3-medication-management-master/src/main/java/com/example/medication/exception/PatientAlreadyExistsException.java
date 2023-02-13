package com.example.medication.exception;


public class PatientAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String message;

	public PatientAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
