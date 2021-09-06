package com.bootcamp.springBootAPIRest.controller;

import com.bootcamp.springBootAPIRest.service.PatternSyntaxCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pattern-syntax-checker")
public class PatternSyntaxCheckerControler {

  @Autowired
  PatternSyntaxCheckerService patternSyntaxCheckerService;

  @PostMapping()
  public String patternSyntaxChecker(@RequestBody String[] patterns) {
    return patternSyntaxCheckerService.patternSyntaxChecker(patterns);
  }

}
