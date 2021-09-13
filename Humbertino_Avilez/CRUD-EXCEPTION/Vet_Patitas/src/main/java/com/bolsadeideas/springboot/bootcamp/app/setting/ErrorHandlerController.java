package com.bolsadeideas.springboot.bootcamp.app.setting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bolsadeideas.springboot.bootcamp.app.entity.Response;
import com.bolsadeideas.springboot.bootcamp.app.exception.AnimalNotFoundException;
import com.bolsadeideas.springboot.bootcamp.app.utils.Constants;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(AnimalNotFoundException.class)
	public ResponseEntity<Response<String>> validationId(AnimalNotFoundException animalNotFoundException) {
		Response responseAnimal = new Response(Constants.ResponseConstants.FAILURE,
				animalNotFoundException.getMessage(), null);
		return new ResponseEntity<>(responseAnimal, HttpStatus.BAD_REQUEST);
	}

}
