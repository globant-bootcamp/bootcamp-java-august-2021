package com.globant.hackerrank.util;

public class Constants {
	
	public enum ResponseConstants {
		SUCCESS("Successful"), FAILURE("Unsuccessful");
		
		private String description;
		
		private ResponseConstants(final String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}		
	}
	
	public static final String GENERIC_MESSAGE_RESPONSE = "Inputs were processed";
	public static final String CONSTRAINT_STRING_RANGE_ATMOST_INVALID = "Input lenght size must be within 1 - %d letters.";
	public static final String STRING_IS_PALINDROME = "The input %s is a palindrome";
	public static final String STRING_IS_NOT_PALINDROME = "The input %s is not a palindrome";
	public static final String WORDS_ARE_ANAGRAMS = "'%s' IS anagram of '%s'";
	public static final String WORDS_ARE_NOT_ANAGRAMS = "'%s' IS NOT anagram of '%s'";
}
