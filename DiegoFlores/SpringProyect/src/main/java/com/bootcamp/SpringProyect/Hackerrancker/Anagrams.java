package com.bootcamp.SpringProyect.Hackerrancker;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

	public static final String SUCCES_MESSAGE = "Anagrams";
	public static final String FAIL_MESSAGE = "Not Anagrams";
	
    static boolean isAnagram(String firstString, String secondString) {
        
        char[] lowerCaseString1 = firstString.toLowerCase().toCharArray();
        char[] lowerCaseString2 = secondString.toLowerCase().toCharArray();
        
        Arrays.sort(lowerCaseString1);
        Arrays.sort(lowerCaseString2);
           
        return Arrays.equals(lowerCaseString1,lowerCaseString2);
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ?  SUCCES_MESSAGE : FAIL_MESSAGE );
        
    }
  
}