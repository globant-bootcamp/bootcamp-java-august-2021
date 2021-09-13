package com.bootcamp.springdatacrud.utils;

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
    public static final String USER_ADDED_SUCCESSFULLY = "User added successfully";
    public static final String USER_DELETED_SUCCESSFULLY = "User deleted succesfully";
    public static final String USER_UPDATED_SUCCESSFULLY = "User updated succesfully";
    public static final String USER_DOES_NOT_EXIST = "User doesn't exist";
}
