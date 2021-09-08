package com.bootcamp.SpringProyect.Hackerrancker;

import java.util.Scanner;

public class StringReverse {
	
	public static final String SUCCESS_MESSAGE = "Yes";
	
	public static void main(String[] args) {
	                
		Scanner sc=new Scanner(System.in);
	    String firstString = sc.next();
	    sc.close();
	        
	    StringBuilder strbuilder = new StringBuilder(firstString);
	    String reverseString = strbuilder.reverse().toString();
	               
	    if( firstString.equals(reverseString) ){
	    	System.out.println("Yes");
	    }else {
	    	System.out.println("No");
	    }
	        
	}
	
}
