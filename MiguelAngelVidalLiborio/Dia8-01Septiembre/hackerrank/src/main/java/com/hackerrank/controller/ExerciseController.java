package com.hackerrank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hackerrank.dto.ResponseDTO;
import com.hackerrank.service.ExerciseService;
import com.hackerrank.utils.Constants;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

	@Autowired
	ExerciseService exerciseService;

	@GetMapping("/string-reverse")
	public ResponseEntity<ResponseDTO<String>> palindrome(@RequestParam String stringInput) {

		ResponseDTO<String> response = new ResponseDTO<String>(Constants.EXERCISE_MSG_SUCCESS,
				exerciseService.palindrome(stringInput));
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/anagram")
	public ResponseEntity<ResponseDTO<String>> anagram(@RequestParam String myFirstString,
			@RequestParam String mySecondString) {

		ResponseDTO<String> response = new ResponseDTO<String>(Constants.EXERCISE_MSG_SUCCESS,
				exerciseService.anagram(myFirstString, mySecondString));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/pattern-syntax-checker")
	public ResponseEntity<ResponseDTO<String>> patternSyntax(@RequestParam String stringInput) {

		ResponseDTO<String> response = new ResponseDTO<String>(Constants.EXERCISE_MSG_SUCCESS,
				exerciseService.patternSyntaxChecker(stringInput));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
