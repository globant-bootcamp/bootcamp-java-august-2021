package com.bootcamp.springbootex.utils;

public class Constants {

    public enum ResponseConstants{
        SUCCESS("Successful"), FAILURE("Unsuccessful");

        private String description;

        ResponseConstants(final String description){
            this.description = description;
        }

        public String getDescription(){
            return description;
        }
    }

    public static final String YES = "Yes";
    public static final String NO = "No";
    public static final String STRING_REVERSE_RESPONSE_MESSAGE = "Palindrome was verified";
    public static  final String IS_ANAGRAM_RESPONSE_MESSAGE = "Words was analized succesfully";
    public static  final String PATERN_SINTAX_RESPONSE_MESSAGE = "Patterns sintax was validated";
}
