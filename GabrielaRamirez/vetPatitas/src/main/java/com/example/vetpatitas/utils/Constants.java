package com.example.vetpatitas.utils;

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

        public static final String VALIDATION_USER_BOOTCAMP= "The user was validated successfully";
        public static final String USER_ADDED_SUCCESSFULLY= "The user was added successfully";
        public static final String POSITIVE = "POSITIVE";
    }
}
