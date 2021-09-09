package com.globant.hackerrank.service.impl;

import org.springframework.stereotype.Service;

import com.globant.hackerrank.service.StringService;
import com.globant.hackerrank.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StringServiceImpl implements StringService {

	@Override
	public boolean isPalindrome(String inputToDeterminePalindrome) {
		String intpuLowerCase = inputToDeterminePalindrome.toLowerCase();
		String inputReversed = new StringBuffer(intpuLowerCase).reverse().toString();
		return intpuLowerCase.equalsIgnoreCase(inputReversed);
	} 


}
