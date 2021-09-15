package com.globant.vetpatitas.config;

import com.globant.vetpatitas.dto.ResponseDTO;
import com.globant.vetpatitas.exception.InvalidDeactivationRequest;
import com.globant.vetpatitas.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(InvalidDeactivationRequest.class)
    public ResponseEntity<ResponseDTO<String>> userValidationException(InvalidDeactivationRequest invalidDeactivationRequest){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.FAILURE, invalidDeactivationRequest.getMessage(), null);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
