package com.example.globant.springdataproject.utils;

public class Constants {
    public enum ResponseConstants {
        SUCCESS("Successful"),
        FAILURE("Unsuccessful");

        private String description;

        ResponseConstants(final String description) {
            this.description = description;
        }
    }

    public static final String CLIENT_ADDED_SUCCESSFULLY = "The client was added successfully";
    public static final String CLIENT_EDITED_SUCCESSFULLY = "The client was edited successfully";
    public static final String CLIENT_DELETED_SUCCESSFULLY = "The client was successfully removed";
    public static final String MISSING_CLIENT_FIELDS = "Some fields are missing to be able to add a new client";
    public static final String CLIENT_ID_NOT_NULL = "Customer id cannot be null";

    public static final String PET_ADDED_SUCCESSFULLY = "The pet was added successfully";
    public static final String PET_EDITED_SUCCESSFULLY = "The pet was edited successfully";
    public static final String PET_DELETED_SUCCESSFULLY = "The pet was successfully eliminated";
    public static final String MISSING_PET_FIELDS = "Some fields are missing to be able to add a new pet";
    public static final String PET_ID_NOT_NULL = "Pet id cannot be null";

    public static final String INVALID_CLIENT_ID = "Invalid client id";
    public static final String INVALID_PET_ID = "Invalid pet id";
}
