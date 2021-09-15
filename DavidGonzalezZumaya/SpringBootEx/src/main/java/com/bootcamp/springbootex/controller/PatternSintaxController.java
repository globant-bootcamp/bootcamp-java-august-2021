package com.bootcamp.springbootex.controller;

import com.bootcamp.springbootex.dto.ResponseDto;
import com.bootcamp.springbootex.service.PatternSintaxService;
import com.bootcamp.springbootex.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patternSintax")
public class PatternSintaxController {

    @Autowired
    PatternSintaxService patternSintaxService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto<List<String>>> patternSintaxService(@RequestBody String[] patterns) {
        ResponseDto<List<String>> response = new ResponseDto(Constants.ResponseConstants.SUCCESS, Constants.PATERN_SINTAX_RESPONSE_MESSAGE , patternSintaxService.patternValidation(patterns));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
