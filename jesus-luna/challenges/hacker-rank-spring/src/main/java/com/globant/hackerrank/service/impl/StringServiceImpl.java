package com.globant.hackerrank.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.globant.hackerrank.service.StringService;
import com.globant.hackerrank.util.Constants;


@Service
public class StringServiceImpl implements StringService {

	@Override
	public String isPalindrome(String inputToDeterminePalindrome) {
		String intpuLowerCase = inputToDeterminePalindrome.toLowerCase();
		String inputReversed = new StringBuffer(intpuLowerCase).reverse().toString();
		return (intpuLowerCase.equalsIgnoreCase(inputReversed)) ? String.format(Constants.STRING_IS_PALINDROME, intpuLowerCase) : String.format(Constants.STRING_IS_NOT_PALINDROME, intpuLowerCase);
		
	}

	@Override
	public String wordsAreAnagram(String firstWord, String secondWord) {
		String goodResponse = String.format(Constants.WORDS_ARE_ANAGRAMS, firstWord,secondWord);
		String badResponse = String.format(Constants.WORDS_ARE_NOT_ANAGRAMS, firstWord,secondWord);
		if(firstWord.length() != secondWord.length()) {
			return badResponse;
		}
		char[] firsWordChars = firstWord.toLowerCase().toCharArray();
		char[] secondWordChars = secondWord.toLowerCase().toCharArray();
		Arrays.sort(firsWordChars);
    Arrays.sort(secondWordChars);
    return (Arrays.equals(firsWordChars, secondWordChars)) ? goodResponse : badResponse;
	} 


}
