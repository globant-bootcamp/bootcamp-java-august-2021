package com.bolsadeideas.springboot.bootcamp.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.bootcamp.app.services.JavaAnagramsService;
import com.bolsadeideas.springboot.bootcamp.app.services.JavaPatternSyntaxChecker;
import com.bolsadeideas.springboot.bootcamp.app.services.JavaStringReverseService;

@RestController
public class HackerrankController {

	@Autowired
	JavaStringReverseService javaStringReverseService;

	@Autowired
	JavaAnagramsService javaAnagramsService;

	@Autowired
	JavaPatternSyntaxChecker javaPatternSyntaxChecker;

	@GetMapping("/JavaStringReverse/{word}")
	public String getJavaStringReverse(@PathVariable String word) {
		return javaStringReverseService.palindromeWord(word);
	}

	@GetMapping("/JavaAnagrams/{word}/{anagram}")
	public String validateAnagram(@PathVariable String word, @PathVariable String anagram) {
		return javaAnagramsService.validateAnagram(word, anagram);
	}

	@GetMapping("/JavaPatternSyntax/{pattern}")
	public String validSyntax(@PathVariable String pattern) {
		return javaPatternSyntaxChecker.validatePatternRedex(pattern);
	}
}
