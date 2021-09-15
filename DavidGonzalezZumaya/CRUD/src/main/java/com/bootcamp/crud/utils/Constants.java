package com.bootcamp.crud.utils;

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
        public static final String OWNER_CREATED_MESSAGE = "Owner was added succesfully";
        public static final String OWNER_DELETED_MESSAGE = "Owner was deleted succesfully";
        public static final String OWNER_UPDATED_MESSAGE = "Owner was updated succesfully";

}
