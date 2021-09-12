package com.globant.vet.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.globant.vet.dto.ResponseDTO;
import com.globant.vet.exception.BootstrapException;
import com.globant.vet.exception.EntityNotFound;
import com.globant.vet.util.constants.ResponseConstants;

@ControllerAdvice
public class ExceptionManager extends ResponseEntityExceptionHandler {
	
	private ResponseEntity<ResponseDTO<String>> getBadResponse(RuntimeException error){
		ResponseDTO<String> response = new ResponseDTO<>(ResponseConstants.FAILURE,ResponseConstants.FAILURE.getDescription(),error.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		
	}

	@ExceptionHandler(BootstrapException.class)
	public ResponseEntity<ResponseDTO<String>> bootstrapError(BootstrapException bootstrapError) {
		ResponseDTO<String> response = new ResponseDTO<>(ResponseConstants.FAILURE,ResponseConstants.FAILURE.getDescription(),bootstrapError.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<ResponseDTO<String>> entityNotFound(EntityNotFound error) {
		return getBadResponse(error);
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
		ResponseDTO<List<String>> response = new ResponseDTO<>(ResponseConstants.FAILURE,ResponseConstants.FAILURE.getDescription(), errors);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
