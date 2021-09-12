package com.globant.hackerrank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.hackerrank.dto.RequestDTO;
import com.globant.hackerrank.dto.ResponseDTO;
import com.globant.hackerrank.model.PatternSyntaxRequest;
import com.globant.hackerrank.service.StringService;
import com.globant.hackerrank.util.Constants;
import com.globant.hackerrank.util.ValidatorInputs;

@Validated
@RestController
@RequestMapping("septiembre02")
public class Septiembre02 {

	@Autowired
	private StringService stringService;

	@Autowired
	private ValidatorInputs validator;

	@GetMapping(value = "reverse")
	public ResponseEntity<ResponseDTO<String>> palindromeIssue(@RequestParam(name = "input", defaultValue = "") String inputToDeterminePalindrome) {
		validator.validAtMostNLetters(50, inputToDeterminePalindrome);
		return ResponseEntity.ok().body(new ResponseDTO<String>(Constants.ResponseConstants.SUCCESS,Constants.ResponseConstants.SUCCESS.getDescription(), stringService.isPalindrome(inputToDeterminePalindrome)));
	}

	@GetMapping(value = "anagram")
	public ResponseEntity<ResponseDTO<String>> anagramIssue(@RequestParam(defaultValue = "") String firstWord,@RequestParam(defaultValue = "") String secondWord) {
		validator.validAtMostNLetters(50, firstWord);
		validator.validAtMostNLetters(50, secondWord);
		return ResponseEntity.ok().body(new ResponseDTO<String>(Constants.ResponseConstants.SUCCESS,Constants.GENERIC_MESSAGE_RESPONSE, stringService.wordsAreAnagram(firstWord, secondWord)));
	}

	@PostMapping(value = "check-pattern", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<List<String>>> patternsIssue(@Valid @RequestBody RequestDTO<PatternSyntaxRequest> request) {
		validator.validateNullPaternRequest(request);
		return ResponseEntity.ok().body(new ResponseDTO<List<String>>(Constants.ResponseConstants.SUCCESS,Constants.GENERIC_MESSAGE_RESPONSE, stringService.validatePatternSyntax(request.getData().getPatterns())));
	}

}
