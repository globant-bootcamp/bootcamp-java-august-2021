package com.globant.hackerrank.controller;

import com.globant.hackerrank.dto.AnagramDTO;
import com.globant.hackerrank.dto.PatternDTO;
import com.globant.hackerrank.dto.ResponseDTO;
import com.globant.hackerrank.dto.StringReverseDTO;
import com.globant.hackerrank.service.AnagramService;
import com.globant.hackerrank.service.PalindromeService;
import com.globant.hackerrank.service.PatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.globant.hackerrank.utils.Constants.ResponseConstants;

import static com.globant.hackerrank.utils.Constants.IS_ANAGRAM;
import static com.globant.hackerrank.utils.Constants.IS_PATTERN_VALID;
import static com.globant.hackerrank.utils.Constants.IS_PALINDROME;

@RestController
@RequestMapping("Hackerrank")
public class HackerRankController {

    @Autowired
    private AnagramService anagramService;

    @Autowired
    private PatternService patternService;

    @Autowired
    private PalindromeService palindromeService;

    @PostMapping(path = "/Anagram", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AnagramDTO>> getResultAnagram(@RequestBody AnagramDTO anagramDTO) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, IS_ANAGRAM, anagramService.validAnagram(anagramDTO));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/Pattern", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PatternDTO>> getResultPattern(@RequestBody PatternDTO patternDTO) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, IS_PATTERN_VALID, patternService.validPattern(patternDTO));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/Palindrome", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<StringReverseDTO>> getResultPalindrome(@RequestBody StringReverseDTO stringReverseDTO) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, IS_PALINDROME, palindromeService.validPalindrome(stringReverseDTO));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}
