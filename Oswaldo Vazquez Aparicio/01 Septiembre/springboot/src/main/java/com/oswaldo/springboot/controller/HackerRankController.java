package com.oswaldo.springboot.controller;

import com.oswaldo.springboot.dto.AnagramDTO;
import com.oswaldo.springboot.dto.PatternDTO;
import com.oswaldo.springboot.dto.StringReverseDTO;
import com.oswaldo.springboot.dto.ResponseDTO;
import com.oswaldo.springboot.service.AnagramService;
import com.oswaldo.springboot.service.PatternService;
import com.oswaldo.springboot.service.StringReverseService;
import com.oswaldo.springboot.service.impl.PatternServiceImpl;
import com.oswaldo.springboot.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.oswaldo.springboot.utils.Constants.*;

@RestController
public class HackerRankController {

    @Autowired
    private StringReverseService stringReverseService;

    @Autowired
    private AnagramService anagramService;

    @Autowired
    private PatternService patternService;

    @PostMapping(path = "/palindrome", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<StringReverseDTO>> validatePalindrome(@RequestBody StringReverseDTO javaStringReverseDTO) {
        ResponseDTO<StringReverseDTO> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, VALIDATION_PALINDROME, stringReverseService.isPalindrome(javaStringReverseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/anagrams", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AnagramDTO>> validateAnagram(@RequestBody AnagramDTO anagramDTO){
        ResponseDTO<AnagramDTO> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, VALIDATION_ANAGRAM, anagramService.areAnagram(anagramDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(path = "/pattern", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PatternDTO>> validatePattern(@RequestBody PatternDTO patternDTO){
        ResponseDTO<PatternDTO> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, VALIDATION_PATTERN, patternService.isValidRegex(patternDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
