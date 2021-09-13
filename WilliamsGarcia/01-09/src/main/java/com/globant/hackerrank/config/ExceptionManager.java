package com.globant.hackerrank.config;

import com.globant.hackerrank.dto.ResponseDTO;
import com.globant.hackerrank.exception.InvalidPatternException;
import com.globant.hackerrank.exception.IsNotAnagramException;
import com.globant.hackerrank.exception.IsNotPalindromeException;
import com.globant.hackerrank.utils.Constants.ResponseConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(InvalidPatternException.class)
    public ResponseEntity<ResponseDTO> validPatternException(InvalidPatternException invalidPatternException) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.FAILURE, invalidPatternException.getMessage(), null);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IsNotAnagramException.class)
    public ResponseEntity<ResponseDTO> validAnagramException(IsNotAnagramException isNotAnagramException) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.FAILURE, isNotAnagramException.getMessage(), null);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IsNotPalindromeException.class)
    public ResponseEntity<ResponseDTO> validPalindromeException(IsNotPalindromeException isNotPalindromeException) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.FAILURE, isNotPalindromeException.getMessage(), null);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
