package com.bootcamp.springdatajpa.config;

import com.bootcamp.springdatajpa.dto.ResponseDTO;
import com.bootcamp.springdatajpa.exception.InvalidDataException;
import com.bootcamp.springdatajpa.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ExceptionManager {

  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  public ResponseEntity<ResponseDTO<String>> sqlDataValidationException(SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException) {
    ResponseDTO<String> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.FAILURE, sqlIntegrityConstraintViolationException.getMessage(), null);
    return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InvalidDataException.class)
  public ResponseEntity<ResponseDTO<String>> sqlDataValidationException(InvalidDataException invalidDataException) {
    ResponseDTO<String> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.FAILURE, invalidDataException.getMessage(), null);
    return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
  }

}
