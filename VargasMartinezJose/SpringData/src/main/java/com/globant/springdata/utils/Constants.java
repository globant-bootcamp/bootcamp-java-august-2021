package com.globant.springdata.utils;

public class Constants {
    public enum ResponseConstants{
        SUCCESS("Successful"),FAILURE("Unsuccessful");
        private final String description;
        ResponseConstants(final String description){
            this.description=description;
        }
        public String getDescription(){
            return description;
        }
    }
    public static final String USER_ADDED_SUCCESSFULLY="The user was added successfully";
    public static final String SPECIES_NOT_VALID="Please, enter a valid species";
    public static final String DOG="DOG";
    public static final String DELETED_USER="DELETED_USER";
    public static final String USER_WAS_NOT_FOUND="USER_WAS_NOT_FOUND";
    public static final String ANIMAL_UPDATED="ANIMAL_UPDATED";
    public static final String SET_APOINTMENT="SET_APOINTMENT";
}

