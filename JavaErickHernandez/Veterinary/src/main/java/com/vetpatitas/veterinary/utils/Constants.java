package com.vetpatitas.veterinary.utils;

public class Constants {
    public enum ResponseConstants {
        SUCCESS("Successful"), FAILURE("Unsuccessful");

        private final String description;

        public String getDescription() {
            return description;
        }

        ResponseConstants(final String description) {
            this.description = description;
        }
    }

    public static final String ANIMAL_ADDED_SUCCESSFULLY = "The animal was added successfully";
    public static final String ANIMAL_DELETED_SUCCESSFULLY = "The animal was deleted successfully";
    public static final String ANIMAL_SELECTED_SUCCESSFULLY = "The animal was selected successfully";
    public static final String ANIMAL_EDITED_SUCCESSFULLY = "The animal was edited successfully";
    public static final String ANIMAL_INVALID_DATA = "Invalid animal data, please try again";

    public static final String OWNER_ADDED_SUCCESSFULLY = "The owner was added successfully";
    public static final String OWNER_DELETED_SUCCESSFULLY = "The owner was deleted successfully";
    public static final String OWNER_SELECTED_SUCCESSFULLY = "The owner was selected successfully";
    public static final String OWNER_EDITED_SUCCESSFULLY = "The owner was edited successfully";
    public static final String OWNER_INVALID_DATA = "Invalid owner data, please try again";

    public static final String TREATMENT_ADDED_SUCCESSFULLY = "The treatment was added successfully";
    public static final String TREATMENT_DELETED_SUCCESSFULLY = "The treatment was deleted successfully";
    public static final String TREATMENT_SELECTED_SUCCESSFULLY = "The treatment was selected successfully";
    public static final String TREATMENT_EDITED_SUCCESSFULLY = "The treatment was edited successfully";
    public static final String TREATMENT_INVALID_DATA = "Invalid treatment data, please try again";
}
