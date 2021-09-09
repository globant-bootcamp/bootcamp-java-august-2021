package com.globant.hackerrank.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.globant.hackerrank.dto.ResponseDTO;
import com.globant.hackerrank.exceptions.ConstraintViolationException;
import com.globant.hackerrank.util.Constants;

@ControllerAdvice
public class ExceptionManager {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseDTO<String>> invalidConstraintValidation(ConstraintViolationException constraintViolated){
		ResponseDTO<String> response = new ResponseDTO<>(Constants.ResponseConstants.FAILURE, constraintViolated.getMessage(), null);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
