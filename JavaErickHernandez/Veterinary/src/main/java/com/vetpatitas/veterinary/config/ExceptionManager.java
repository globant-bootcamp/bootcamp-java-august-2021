package com.vetpatitas.veterinary.config;

import com.vetpatitas.veterinary.dto.ResponseDTO;
import com.vetpatitas.veterinary.exception.InvalidDataException;
import com.vetpatitas.veterinary.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ResponseDTO<String>> entityValidationException(InvalidDataException invalidDataException){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.FAILURE, invalidDataException.getMessage(), null);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }


}
