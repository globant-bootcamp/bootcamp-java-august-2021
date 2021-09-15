package com.bootcamp.springbootex.controller;

import com.bootcamp.springbootex.dto.ResponseDto;
import com.bootcamp.springbootex.service.AnagramService;
import com.bootcamp.springbootex.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("anagram")
public class AnagramController {

    @Autowired
    AnagramService anagramService;

    @GetMapping
    public ResponseEntity<ResponseDto<String>> anagramService(@RequestParam(name = "firstWord") String firstWord, @RequestParam( name= "secondWord") String secondWord) {
        ResponseDto<String> response = new ResponseDto<>(Constants.ResponseConstants.SUCCESS, Constants.IS_ANAGRAM_RESPONSE_MESSAGE, anagramService.isAnagram(firstWord, secondWord));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
