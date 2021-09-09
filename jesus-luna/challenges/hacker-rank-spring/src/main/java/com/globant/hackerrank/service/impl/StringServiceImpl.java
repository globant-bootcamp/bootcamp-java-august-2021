package com.globant.hackerrank.service.impl;

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


}
