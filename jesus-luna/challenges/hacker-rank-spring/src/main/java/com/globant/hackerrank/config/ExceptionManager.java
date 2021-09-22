package com.globant.hackerrank.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.globant.hackerrank.dto.ResponseDTO;
import com.globant.hackerrank.exceptions.ConstraintViolationException;
import com.globant.hackerrank.util.Constants;

@ControllerAdvice
public class ExceptionManager extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseDTO<String>> invalidConstraintValidation(ConstraintViolationException constraintViolated) {
		ResponseDTO<String> response = new ResponseDTO<>(Constants.ResponseConstants.FAILURE,constraintViolated.getMessage(), null);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}
		ResponseDTO<List<String>> response = new ResponseDTO<>(Constants.ResponseConstants.FAILURE,Constants.ResponseConstants.FAILURE.getDescription(), errors);
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}

}
