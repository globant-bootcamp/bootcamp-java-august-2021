package com.example.globant.springdataproject.config;

import com.example.globant.springdataproject.dto.ResponseDTO;
import com.example.globant.springdataproject.exception.InvalidDataException;
import com.example.globant.springdataproject.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ResponseDTO<String>> userValidationException(InvalidDataException invalidDataException) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.FAILURE, invalidDataException.getMessage(), null);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
