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
	public static final String REQUEST_DATA_ERROR = "The requested data can not be nor null nor empty";
	public static final String PATTERNS_ERROR = "The patterns can not be nor null nor empty";
	public static final String VALID_PATTERN = "%s - VALID";
	public static final String INVALID_PATTERN = "%s - INVALID";
}
