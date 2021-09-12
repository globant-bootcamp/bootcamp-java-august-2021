package com.bootcamp.springtest.controller;

import com.bootcamp.springtest.dto.UserDTO;
import com.bootcamp.springtest.service.AnagramsService;
import com.bootcamp.springtest.service.PalindromeService;
import com.bootcamp.springtest.service.PatternSyntaxService;
import com.bootcamp.springtest.service.UserService;
import com.bootcamp.springtest.service.impl.PalindromeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hackerrank")
public class controller {

    @Autowired
    UserService userService;

    @Autowired
    private PalindromeService palindromeServiceImp;

    @Autowired
    private AnagramsService anagramServiceImpl;

    @Autowired
    private PatternSyntaxService syntaxServiceImpl;


    @RequestMapping("/{id}")
    public String hackerrank(@PathVariable Integer id, @RequestParam String name) {
        return "hola mundo!" + name;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUser(@RequestBody UserDTO userDTO) {
        return userDTO;
    }

    @PostMapping(path = "/bootcamp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUserBootcamp(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.validateUserBootcamp(userDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/palindrome/{wordToEvaluate}")
    public String validatePalindrome(@PathVariable String wordToEvaluate) {
        return palindromeServiceImp.validatePalindrome(wordToEvaluate);
    }

    @GetMapping(path = "/anagram/{wordToEvaluateOne}/{wordToEvaluateTwo}")
    public String validateAnagram(@PathVariable String wordToEvaluateOne, @PathVariable String wordToEvaluateTwo) {
        return anagramServiceImpl.validateAnagram(wordToEvaluateOne, wordToEvaluateTwo);
    }

    @GetMapping(path = "/syntax/{patternToEvaluate}")
    public String validateSyntax(@PathVariable String patternToEvaluate) {
        return syntaxServiceImpl.validateSyntax(patternToEvaluate);
    }

}
