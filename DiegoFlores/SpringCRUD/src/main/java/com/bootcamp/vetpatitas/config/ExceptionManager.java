package com.bootcamp.vetpatitas.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bootcamp.vetpatitas.dto.ResponseDTO;
import com.bootcamp.vetpatitas.exception.InvalidDataException;
import com.bootcamp.vetpatitas.utils.Constants.ResponseConstants;

@ControllerAdvice
public class ExceptionManager {
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ResponseDTO<String>> petValidationException(InvalidDataException invalidDataException){
		ResponseDTO responseDTO  = new ResponseDTO(ResponseConstants.FAILURE,invalidDataException.getMessage() , null);
		return new ResponseEntity<>(responseDTO, HttpStatus.EXPECTATION_FAILED);
	}
}
