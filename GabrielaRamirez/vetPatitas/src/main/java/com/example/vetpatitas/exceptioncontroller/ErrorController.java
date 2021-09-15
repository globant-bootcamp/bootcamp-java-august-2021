package com.example.vetpatitas.exceptioncontroller;

import com.example.vetpatitas.dto.ResponseDTO;
import com.example.vetpatitas.exception.InvalidDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.vetpatitas.utils.Constants;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ResponseDTO<String>> validationAge(InvalidDataException invalidDataException){
        ResponseDTO responsePetAge = new ResponseDTO(Constants.ResponseConstants.FAILURE,invalidDataException.getMessage(), null);
        return new ResponseEntity<>(responsePetAge, HttpStatus.BAD_REQUEST);
    }
}
