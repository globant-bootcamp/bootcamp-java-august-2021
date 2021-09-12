package com.globant.bootcamp.utils;

public class Constants {

    public enum ResponseConstants {
        SUCCESS("Successful"), FAILURE("Unsuccessful");

        private String description;

        ResponseConstants(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public static final String ANAGRAM_EVALUATION = "The anagram vas evaluated successfully";
    public static final String PALINDROME_EVALUATION = "The palindrome vas evaluated successfully";
    public static final String REGEX_SYNTAX_EVALUATION = "The regex pattern vas evaluated successfully";
}
