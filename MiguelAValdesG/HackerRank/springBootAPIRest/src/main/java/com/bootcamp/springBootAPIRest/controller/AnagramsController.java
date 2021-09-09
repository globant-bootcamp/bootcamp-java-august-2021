package com.bootcamp.springBootAPIRest.controller;

import com.bootcamp.springBootAPIRest.dto.ResponseDTO;
import com.bootcamp.springBootAPIRest.service.AnagramsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.bootcamp.springBootAPIRest.utils.Constants.*;

@RestController
@RequestMapping("anagrams")
public class AnagramsController {

  @Autowired
  AnagramsService anagramsService;

  @GetMapping("")
  public ResponseEntity<ResponseDTO<String>> anagrams(@RequestParam(name = "firstWord") String firstWord, @RequestParam(name = "secondWord") String secondWord) {
    ResponseDTO<String> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      STRING_REVERSE_RESPONSE_MESSAGE,
      anagramsService.anagrams(firstWord, secondWord)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }
}
