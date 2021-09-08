package com.bootcamp.SpringProyect.Hackerrancker;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternSyntaxChecher
{
    public static final String VALID_MESSAGE = "Valid";
    public static final String INVALID_MESSAGE = "Invalid";
    
	public static void main(String[] args){
        
		Scanner sc = new Scanner(System.in);
        
		int testCases = Integer.parseInt(sc.nextLine());
		
		while(testCases>0){
		
			String pattern = sc.nextLine();
          	
            try {
                Pattern.compile(pattern);
                System.out.println(VALID_MESSAGE);
            } catch(PatternSyntaxException e) {
                System.out.println(INVALID_MESSAGE);
            }
            
            testCases --;
            sc.close();
		}
	}
}