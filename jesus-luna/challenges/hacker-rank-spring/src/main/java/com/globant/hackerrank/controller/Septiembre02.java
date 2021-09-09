package com.globant.hackerrank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.hackerrank.service.StringService;
import com.globant.hackerrank.util.ValidatorInputs;

@RestController
@RequestMapping("septiembre02")
public class Septiembre02 {
	
	@Autowired
	private StringService stringService;
	
	@Autowired
	private ValidatorInputs validator;

	@GetMapping(value = "reverse")
	public ResponseEntity<Boolean> getMethodName(@RequestParam(name = "input",defaultValue = "") String inputToDeterminePalindrome) {
		validator.validAtMostNLetters(50, inputToDeterminePalindrome);
		return ResponseEntity.ok().body(stringService.isPalindrome(inputToDeterminePalindrome));
	}

}
