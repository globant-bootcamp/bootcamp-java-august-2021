package com.globant.hackerrank.utils;

public class Constants {

    public enum ResponseConstants {
        SUCCESS("Successful"), FAILURE("Unsuccessful");

        private final String description;

        ResponseConstants(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static final String IS_PATTERN_VALID = "The word is valid";
    public static final String NO_PATTERN_VALID = "The word isn't valid";
    public static final String IS_PALINDROME = "The word is palindrome";
    public static final String NO_PALINDROME = "The word isn't palindrome";
    public static final String IS_ANAGRAM = "The word is an anagram";
    public static final String NO_ANAGRAM = "The word isn't anagram";
}
