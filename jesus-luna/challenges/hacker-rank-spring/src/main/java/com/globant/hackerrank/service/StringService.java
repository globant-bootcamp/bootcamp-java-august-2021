package com.globant.hackerrank.service;

import java.util.List;

public interface StringService {
	public String isPalindrome(String inputToDeterminePalindrome);
	public String wordsAreAnagram(String firstWord, String secondWord);
	public List<String> validatePatternSyntax(List<String> patterns);
}
