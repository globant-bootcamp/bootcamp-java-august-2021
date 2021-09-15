package com.veterinary.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.veterinary.dto.ResponseDTO;
import com.veterinary.exception.EmptyInputException;
import com.veterinary.exception.ModelNotFoundException;
import com.veterinary.utils.Constants;

@ControllerAdvice
public class ExceptionManager {

	@ExceptionHandler(ModelNotFoundException.class)
	public ResponseEntity<ResponseDTO<String>> handleModelNotFound(ModelNotFoundException modelNotFound) {
		ResponseDTO<String> response = new ResponseDTO<String>(Constants.RESPONSE_FAIL, modelNotFound.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<ResponseDTO<String>> handleEmptyInput(EmptyInputException emptyInput) {
		ResponseDTO<String> response = new ResponseDTO<String>(Constants.REQUEST_FAIL, emptyInput.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
