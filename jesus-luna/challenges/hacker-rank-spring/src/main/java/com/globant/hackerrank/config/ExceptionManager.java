package com.globant.hackerrank.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.globant.hackerrank.exceptions.ConstraintViolationException;

@ControllerAdvice
public class ExceptionManager {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> invalidConstraintValidation(ConstraintViolationException constraintViolated){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(constraintViolated.getMessage());
	}
}
