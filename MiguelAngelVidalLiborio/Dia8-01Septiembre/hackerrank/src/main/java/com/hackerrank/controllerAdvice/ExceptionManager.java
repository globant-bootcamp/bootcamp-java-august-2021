package com.hackerrank.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.hackerrank.dto.ResponseDTO;
import com.hackerrank.exception.PatternException;
import com.hackerrank.utils.Constants;

@ControllerAdvice
public class ExceptionManager {

	@ExceptionHandler(PatternException.class)
	public ResponseEntity<ResponseDTO<String>> patternValidation(PatternException patternException) {
		ResponseDTO<String> response = new ResponseDTO<String>(Constants.EXERCISE_MSG_FAIL,
				patternException.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
