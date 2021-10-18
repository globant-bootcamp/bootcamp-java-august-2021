package com.globant.bootcamp.controller;

import com.globant.bootcamp.dto.AnagramDTO;
import com.globant.bootcamp.dto.PalindromeDTO;
import com.globant.bootcamp.dto.RegexPatternDTO;
import com.globant.bootcamp.dto.ResponseDTO;
import com.globant.bootcamp.service.AnagramService;
import com.globant.bootcamp.service.PalindromeService;
import com.globant.bootcamp.service.PatternSyntaxCheckerService;
import com.globant.bootcamp.utils.Constants.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.globant.bootcamp.utils.Constants.ANAGRAM_EVALUATION;
import static com.globant.bootcamp.utils.Constants.PALINDROME_EVALUATION;
import static com.globant.bootcamp.utils.Constants.REGEX_SYNTAX_EVALUATION;

@RestController
@RequestMapping("hackerrank")
public class HackerrankController {

    @Autowired
    private AnagramService anagramService;

    @Autowired
    private PalindromeService palindromeService;

    @Autowired
    private PatternSyntaxCheckerService patternSyntaxCheckerService;

    @PostMapping(path = "/anagram", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AnagramDTO>> getStringsToEvaluate(@RequestBody AnagramDTO anagramDTO) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, ANAGRAM_EVALUATION, anagramService.evaluateAnagram(anagramDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/palindrome", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PalindromeDTO>> getPalindromeString(@RequestBody PalindromeDTO palindromeDTO) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PALINDROME_EVALUATION, palindromeService.palindromeCheck(palindromeDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/patternSyntaxChecker", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<RegexPatternDTO>> checkPatternSyntax(@RequestBody RegexPatternDTO regexPatternDTO) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, REGEX_SYNTAX_EVALUATION, patternSyntaxCheckerService.syntaxChecker(regexPatternDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
