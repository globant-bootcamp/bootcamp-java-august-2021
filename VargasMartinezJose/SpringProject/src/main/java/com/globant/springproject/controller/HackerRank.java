package com.globant.springproject.controller;

import com.globant.springproject.services.JavaAnagramService;
import com.globant.springproject.services.JavaPatternSyntaxChecker;
import com.globant.springproject.services.JavaStringReverseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HackerRank {
    @Autowired
    JavaStringReverseService javaStringReverseService;
    @Autowired
    JavaAnagramService javaAnagramService;
    @Autowired
    JavaPatternSyntaxChecker javaPatternSyntaxChecker;

    @GetMapping("/JavaStringReverse/{word}")
    public String getJavaStringReverse(@PathVariable String word) {
        return javaStringReverseService.palindromeWord(word);
    }

    @GetMapping("/JavaAnagrams/{word}/{anagram}")
    public String validateAnagram(@PathVariable String word, @PathVariable String anagram) {
        return javaAnagramService.validateAnagram(word, anagram);
    }

    @GetMapping("/JavaPatternSyntax/{pattern}")
    public String validSyntax(@PathVariable String pattern) {
        return javaPatternSyntaxChecker.validatePattern(pattern);
    }
}
