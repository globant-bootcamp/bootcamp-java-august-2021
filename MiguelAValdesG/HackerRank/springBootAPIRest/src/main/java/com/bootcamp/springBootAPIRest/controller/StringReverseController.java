package com.bootcamp.springBootAPIRest.controller;

import com.bootcamp.springBootAPIRest.dto.ResponseDTO;
import com.bootcamp.springBootAPIRest.service.StringReverseService;
import com.bootcamp.springBootAPIRest.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bootcamp.springBootAPIRest.utils.Constants.GENERIC_RESPONSE_MESSAGE;

@RestController
@RequestMapping("string-reverse")
public class StringReverseController {

  @Autowired
  StringReverseService stringReverseService;

  @GetMapping("/{characterSequence}")
  public ResponseEntity<ResponseDTO<String>> stringReverse(@PathVariable String characterSequence) {
    ResponseDTO<String> responseDTO = new ResponseDTO<>(
      Constants.ResponseConstants.SUCCESS,
      GENERIC_RESPONSE_MESSAGE,
      stringReverseService.stringReverse(characterSequence)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}
