package com.bootcamp.SpringProyect.Service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class AnagramsImp  implements Anagrams{

	public static final String SUCCES_MESSAGE = "Anagrams";
	public static final String FAIL_MESSAGE = "Not Anagrams";
	
	@Override
	public String isAnagram(String firstString, String secondString) {
		
		char[] lowerCaseString1 = firstString.toLowerCase().toCharArray();
        char[] lowerCaseString2 = secondString.toLowerCase().toCharArray();
        
        Arrays.sort(lowerCaseString1);
        Arrays.sort(lowerCaseString2);
           
        boolean result = Arrays.equals(lowerCaseString1,lowerCaseString2);
        
        if (result == true) {
			return SUCCES_MESSAGE;
		}else {
			return FAIL_MESSAGE;
		}
		
	}
  
}