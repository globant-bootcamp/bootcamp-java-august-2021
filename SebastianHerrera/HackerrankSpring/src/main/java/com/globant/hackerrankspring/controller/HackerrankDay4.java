package com.globant.hackerrankspring.controller;

import com.globant.hackerrankspring.model.AnagramRequest;
import com.globant.hackerrankspring.model.GenericResponse;
import com.globant.hackerrankspring.model.PalindromeRequest;
import com.globant.hackerrankspring.model.PatternSyntaxRequest;
import com.globant.hackerrankspring.service.CheckAnagramService;
import com.globant.hackerrankspring.service.CheckPatternService;
import com.globant.hackerrankspring.service.PalindromeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 02/09/21
 */
@Validated
@RestController
@RequestMapping(value = "${request.api}")
public class HackerrankDay4 {

    private PalindromeService palindromeValidate;

    private CheckPatternService syntaxChecker;

    private CheckAnagramService checkAnagram;

    public HackerrankDay4(PalindromeService palindromeValidate, CheckPatternService syntaxChecker,
                          CheckAnagramService checkAnagram) {
        this.palindromeValidate = palindromeValidate;
        this.syntaxChecker = syntaxChecker;
        this.checkAnagram = checkAnagram;
    }

    @PostMapping(value = "${api.url.check-palindrome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> getWord(@Valid @RequestBody PalindromeRequest word) {
        return new ResponseEntity<>(palindromeValidate.validatePalindrome(word), HttpStatus.OK);
    }

    @PostMapping(value = "${api.url.check-pattern}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> getPattern(@Valid @RequestBody PatternSyntaxRequest pattern) {
        return new ResponseEntity<>(syntaxChecker.checkPattern(pattern), HttpStatus.OK);
    }

    @PostMapping(value = "${api.url.check-anagram}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> getAnagram(@Valid @RequestBody AnagramRequest anagram) {
        return new ResponseEntity<>(checkAnagram.checkAnagram(anagram), HttpStatus.OK);
    }


}
