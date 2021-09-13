package com.bootcamp.SpringProyect.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.SpringProyect.Service.Anagrams;
import com.bootcamp.SpringProyect.Service.PatternSyntaxChecker;
import com.bootcamp.SpringProyect.Service.StringReverse;

@RestController
@RequestMapping("hackerranker")
public class Controller {
	
	@Autowired
	private Anagrams anagrams;

	@Autowired
	private PatternSyntaxChecker patternChecker;
	
	@Autowired
	private StringReverse stringReverse;	
	
	@GetMapping("/anagrams/{firstString}/{secondString}")
	public String anagramChallenge(@PathVariable String firstString, @PathVariable String secondString) {
		
		return anagrams.isAnagram(firstString, secondString);
		
	}
	
	@GetMapping("/patternChecker/{pattern}")
	public String patternChecher(@PathVariable String pattern) {
		
		return patternChecker.patternChecker(pattern);
	}
	
	@GetMapping("/stringReverse/{stringTocheck}")
	public String stringReverse(@PathVariable String stringTocheck) {
		
		return stringReverse.reverseString(stringTocheck);
		
	}
	
	
}
