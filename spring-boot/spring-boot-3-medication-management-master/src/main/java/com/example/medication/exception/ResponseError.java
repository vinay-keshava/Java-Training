package com.example.medication.exception;

import java.util.List;

import lombok.Data;

@Data
public class ResponseError {


	private List<String> errorDetails;
	
	public ResponseError( List<String> errorDetails) {
		super();
		this.errorDetails = errorDetails;
	}

	public ResponseError() {
		super();
	}
}
