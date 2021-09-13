package com.oswaldo.springboot.utils;

public class Constants {

    public enum ResponseConstants {
        SUCCESS("Successful"), FAILURE("Unsuccessful");

        private final String description;

        ResponseConstants(final String description){
            this.description = description;
        }

        public String getDescription(){
            return description;
        }
    }

    public static final String VALIDATION_PALINDROME = "Palindrome validation completed successfully";
    public static final String VALIDATION_ANAGRAM = "Anagram validation completed successfully";
    public static final String VALIDATION_PATTERN = "Regex pattern validation completed successfully";

    public static final String YES = "Yes";
    public static final String NO = "No";

    public static final String ANAGRAMS = "Anagrams";
    public static final String NOT_ANAGRAMS = "Not Anagrams";

    public static final String VALID = "Valid";
    public static final String INVALID = "Invalid";

}
