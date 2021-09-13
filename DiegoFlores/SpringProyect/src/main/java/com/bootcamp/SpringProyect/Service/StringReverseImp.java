package com.bootcamp.SpringProyect.Service;

import org.springframework.stereotype.Service;

@Service
public class StringReverseImp implements StringReverse{
	
	public static final String SUCCESS_MESSAGE = "Yes";
	public static final String FAIL_MESSAGE = "No";
	
	@Override
	public String reverseString(String firstString) {
		
		StringBuilder strbuilder = new StringBuilder(firstString);
	    String reverseString = strbuilder.reverse().toString();
	               
	    if( firstString.equals(reverseString) ){
	    	return SUCCESS_MESSAGE;
	    }else {
	    	return FAIL_MESSAGE;
	    }
	    
	}
	
}
