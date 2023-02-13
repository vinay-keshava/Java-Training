package com.example.medication.exception;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        return new ResponseEntity<ApiError>(apiError, apiError.getStatus());
    }
	
	@ExceptionHandler(PatientAlreadyExistsException.class)
	public ResponseEntity<ResponseError> handlePatientAlreadyExistsException(PatientAlreadyExistsException ex,WebRequest req){
		
		List<String> errors = new ArrayList<>();
		errors.add(ex.getLocalizedMessage());
		ResponseError responseError = new ResponseError(errors);
		return new ResponseEntity<>(responseError,HttpStatus.ALREADY_REPORTED);
		
	}
	
	@ExceptionHandler(PatientNotFound.class)
	public ResponseEntity<Object> noSuchPatientFound(PatientNotFound ex,WebRequest req){
		List<String> erros= new ArrayList<>();
		erros.add(ex.getLocalizedMessage());
		ResponseError responseError = new ResponseError(erros);
		return  new ResponseEntity<>(responseError,HttpStatus.NOT_FOUND);
		
	}
}