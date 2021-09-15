package com.bootcamp.springdatacrud.setting;

import com.bootcamp.springdatacrud.dto.ResponseDTO;
import com.bootcamp.springdatacrud.exception.NotFoundException;
import com.bootcamp.springdatacrud.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDTO<String>> validationId(NotFoundException notFoundException){
        ResponseDTO responsePet = new ResponseDTO(Constants.ResponseConstants.FAILURE, notFoundException.getMessage(), null);
        return new ResponseEntity<>(responsePet, HttpStatus.BAD_REQUEST);
    }
}
