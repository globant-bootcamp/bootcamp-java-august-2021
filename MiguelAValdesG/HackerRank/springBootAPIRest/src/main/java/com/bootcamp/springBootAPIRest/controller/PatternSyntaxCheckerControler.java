package com.bootcamp.springBootAPIRest.controller;

import com.bootcamp.springBootAPIRest.dto.ResponseDTO;
import com.bootcamp.springBootAPIRest.service.PatternSyntaxCheckerService;
import com.bootcamp.springBootAPIRest.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.bootcamp.springBootAPIRest.utils.Constants.GENERIC_RESPONSE_MESSAGE;

@RestController
@RequestMapping("pattern-syntax-checker")
public class PatternSyntaxCheckerControler {

  @Autowired
  PatternSyntaxCheckerService patternSyntaxCheckerService;

  @PostMapping()
  public ResponseEntity<ResponseDTO<List<String>>> patternSyntaxChecker(@RequestBody String[] patterns) {
    ResponseDTO<List<String>> responseDTO = new ResponseDTO<List<String>>(
      Constants.ResponseConstants.SUCCESS,
      GENERIC_RESPONSE_MESSAGE,
      patternSyntaxCheckerService.patternSyntaxChecker(patterns)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}
