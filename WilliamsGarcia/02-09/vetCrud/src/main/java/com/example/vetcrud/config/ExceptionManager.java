package com.example.vetcrud.config;

import com.example.vetcrud.dto.ResponseDTO;
import com.example.vetcrud.exception.EmptyListException;
import com.example.vetcrud.exception.NotFoundException;
import com.example.vetcrud.utils.Constants.ResponseConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDTO> notFoundException(NotFoundException notFoundException) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.FAILURE, notFoundException.getMessage(), null);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<ResponseDTO> emptyListException(EmptyListException emptyListException) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.FAILURE, emptyListException.getMessage(), null);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
