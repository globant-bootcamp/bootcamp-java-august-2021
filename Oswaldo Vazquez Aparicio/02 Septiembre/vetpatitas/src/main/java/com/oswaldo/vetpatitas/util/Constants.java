package com.oswaldo.vetpatitas.util;

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

    public static final String PET_ADDED_SUCCESS = "Pet created successfully";
    public static final String PET_UPDATED_SUCCESS = "Pet updated successfully";
    public static final String PET_RETRIEVED_SUCCESS = "Pet retrieved successfully";
    public static final String PET_ALL_RETRIEVED_SUCCESS = "All pets retrieved successfully";
    public static final String PET_DELETED_SUCCESS = "Pet deleted successfully";
    public static final String PET_NOT_FOUND = "Pet doesn't exists";
    public static final String PET_ALREADY_EXISTS = "Pet already exists";

    public static final String OWNER_ADDED_SUCCESS = "Owner created successfully";
    public static final String OWNER_UPDATED_SUCCESS = "Owner updated successfully";
    public static final String OWNER_RETRIEVED_SUCCESS = "Owner retrieved successfully";
    public static final String OWNER_ALL_RETRIEVED_SUCCESS = "All owners retrieved successfully";
    public static final String OWNER_DELETED_SUCCESS = "Owner deleted successfully";
    public static final String OWNER_PET_ASSIGNED_SUCCESS = "Pet assigned to owner successfully";
    public static final String OWNER_NOT_FOUND = "Owner doesn't exists";
    public static final String OWNER_ALREADY_EXISTS = "Owner already exists";

}
