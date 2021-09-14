package com.oswaldo.vetpatitas.config;

import com.oswaldo.vetpatitas.dto.ResponseDTO;
import com.oswaldo.vetpatitas.exception.RecordAlreadyExistsException;
import com.oswaldo.vetpatitas.exception.RecordNotFoundException;
import com.oswaldo.vetpatitas.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(RecordAlreadyExistsException.class)
    public ResponseEntity<ResponseDTO<Void>> handleRecordAlreadyExistsException(RecordAlreadyExistsException recordAlreadyExistsException){
        ResponseDTO<Void> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.FAILURE, recordAlreadyExistsException.getMessage(), null);
        return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ResponseDTO<Void>> handleRecordNotFoundException(RecordNotFoundException recordNotFoundException){
        ResponseDTO<Void> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.FAILURE, recordNotFoundException.getMessage(), null);
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }

}
