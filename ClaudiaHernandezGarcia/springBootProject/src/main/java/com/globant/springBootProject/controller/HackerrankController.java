package com.globant.springBootProject.controller;

import com.globant.springBootProject.dto.AnagramsDTO;
import com.globant.springBootProject.dto.PatternSyntaxCheckerDTO;
import com.globant.springBootProject.dto.ResponseDTO;
import com.globant.springBootProject.dto.StringReverseDTO;
import com.globant.springBootProject.service.AnagramsService;
import com.globant.springBootProject.service.PatternSyntaxCheckerService;
import com.globant.springBootProject.service.StringReverseService;
import com.globant.springBootProject.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hackerrank")
public class HackerrankController {
    @Autowired
    private StringReverseService stringReverseService;

    @Autowired
    private AnagramsService anagramsService;

    @Autowired
    private PatternSyntaxCheckerService patternSyntaxCheckerService;

    @PostMapping(path = "stringReverse", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<StringReverseDTO>> getIsPalindrome(@RequestBody StringReverseDTO stringReverseDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, stringReverseService.solution(stringReverseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(path = "anagrams", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AnagramsDTO>> getIsAnagram(@RequestBody AnagramsDTO anagramsDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, anagramsService.solution(anagramsDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(path = "patternSyntaxChecker", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PatternSyntaxCheckerDTO>> getIsValidPattern(@RequestBody PatternSyntaxCheckerDTO patternSyntaxCheckerDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, patternSyntaxCheckerService.solution(patternSyntaxCheckerDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
