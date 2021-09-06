package com.bootcamp.springBootAPIRest.controller;

import com.bootcamp.springBootAPIRest.service.AnagramsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anagrams")
public class AnagramsController {

  @Autowired
  AnagramsService anagramsService;

  @GetMapping("")
  public String anagrams(@RequestParam(name = "firstWord") String firstWord, @RequestParam(name = "secondWord") String secondWord) {
    return anagramsService.anagrams(firstWord, secondWord);
  }
}
