package com.bootcamp.springbootex.controller;

import com.bootcamp.springbootex.utils.Constants;
import com.bootcamp.springbootex.dto.ResponseDto;
import com.bootcamp.springbootex.service.StringReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("stringReverse")
public class StringReverseController {

    @Autowired
    StringReverseService stringReverseService;

    @GetMapping
    public ResponseEntity<ResponseDto<String>> stringReverseService(@RequestBody String palindrome){
        ResponseDto<String> response = new ResponseDto<>( Constants.ResponseConstants.SUCCESS, Constants.STRING_REVERSE_RESPONSE_MESSAGE , stringReverseService.stringReverse(palindrome));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
