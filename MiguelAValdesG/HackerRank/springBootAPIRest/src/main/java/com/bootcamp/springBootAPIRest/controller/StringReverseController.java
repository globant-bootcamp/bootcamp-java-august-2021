package com.bootcamp.springBootAPIRest.controller;

import com.bootcamp.springBootAPIRest.service.StringReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("string-reverse")
public class StringReverseController {

  @Autowired
  StringReverseService stringReverseService;

  @GetMapping("/{characterSequence}")
  public String stringReverse(@PathVariable String characterSequence) {
    return stringReverseService.stringReverse(characterSequence);
  }

}
