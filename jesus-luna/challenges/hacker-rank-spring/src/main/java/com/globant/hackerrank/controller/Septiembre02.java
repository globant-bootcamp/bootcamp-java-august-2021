package com.globant.hackerrank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.hackerrank.dto.ResponseDTO;
import com.globant.hackerrank.service.StringService;
import com.globant.hackerrank.util.Constants;
import com.globant.hackerrank.util.ValidatorInputs;

@RestController
@RequestMapping("septiembre02")
public class Septiembre02 {
	
	@Autowired
	private StringService stringService;
	
	@Autowired
	private ValidatorInputs validator;

	@GetMapping(value = "reverse")
	public ResponseEntity<ResponseDTO<String>> palindromeIssue(@RequestParam(name = "input",defaultValue = "") String inputToDeterminePalindrome) {
		validator.validAtMostNLetters(50, inputToDeterminePalindrome);
		return ResponseEntity.ok().body(new ResponseDTO<String>(Constants.ResponseConstants.SUCCESS,Constants.ResponseConstants.SUCCESS.getDescription() , stringService.isPalindrome(inputToDeterminePalindrome)));
	}
	
	@GetMapping(value = "anagram")
	public ResponseEntity<ResponseDTO<String>> anagramIssue(@RequestParam(defaultValue = "") String firstWord, @RequestParam(defaultValue = "") String secondWord) {
		validator.validAtMostNLetters(50, firstWord);
		validator.validAtMostNLetters(50, secondWord);
		return ResponseEntity.ok().body(new ResponseDTO<String>(Constants.ResponseConstants.SUCCESS,Constants.GENERIC_MESSAGE_RESPONSE,stringService.wordsAreAnagram(firstWord, secondWord)));
	}

}
