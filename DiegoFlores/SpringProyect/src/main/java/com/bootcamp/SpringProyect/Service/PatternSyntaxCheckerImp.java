package com.bootcamp.SpringProyect.Service;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.stereotype.Service;

@Service
public class PatternSyntaxCheckerImp implements PatternSyntaxChecker{

    public static final String VALID_MESSAGE = "Valid";
    public static final String INVALID_MESSAGE = "Invalid";
    
	@Override
	public String patternChecker(String pattern) {
		
		try {
    		Pattern.compile(pattern);
            return VALID_MESSAGE;
        }catch(PatternSyntaxException e) {
             return INVALID_MESSAGE;
        }
		
	}
    	
}