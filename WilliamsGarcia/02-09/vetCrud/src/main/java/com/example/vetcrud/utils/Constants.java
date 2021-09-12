package com.example.vetcrud.utils;

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

    public static final String PET_CREATED = "The pet was registered successfully";
    public static final String PET_LIST = "The pet list successfully";
    public static final String EMPTY_PET_LIST = "Sorry, the pet list is empty";
    public static final String PET_SHOW = "The pet was found successfully";
    public static final String PET_UPDATED = "The pet was updated successfully";
    public static final String PET_DELETED = "The pet was deleted successfully";
    public static final String NOT_FOUND_PET = "The pet wasn't found";
    public static final String PET_LIST_BY_USER = "This is the pet list of user";

    public static final String OWNER_CREATED = "The owner was registered successfully";
    public static final String OWNER_LIST = "The owner list successfully";
    public static final String EMPTY_OWNER_LIST = "Sorry, the owner list is empty";
    public static final String OWNER_SHOW = "The owner was found successfully";
    public static final String OWNER_UPDATED = "The owner was updated successfully";
    public static final String OWNER_DELETED = "The owner was deleted successfully";
    public static final String NOT_FOUND_OWNER = "The owner wasn't found";
}
