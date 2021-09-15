package com.globant.vetpatitas.utils;

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

    public static final String PET_ADDED_SUCCESSFULLY = "The pet was added successfully";
    public static final String PET_UPDATED_SUCCESSFULLY = "The pet was updated successfully";
    public static final String PET_CONSULTED_SUCCESSFULLY = "The pet data was retrieved successfully";
    public static final String PET_APPOINTMENTS_CONSULTED_SUCCESSFULLY = "Pet appointments data retrieved successfully";

    public static final String DEACTIVATED_PET_ERROR = "The operation couldn't be completed. The pet is currently deactivated.";
    public static final String INVALID_DEACTIVATION_REQUEST = "Invalid deactivation request. Pet is admitted";
    public static final String NONEXISTENT_PET = "The pet doesn't exist";
    public static final String NONEXISTENT_APPOINTMENT = "The appointment doesn't exist";


    public static final String APPOINTMENT_ADDED_SUCCESSFULLY = "The appointment was scheduled successfully";
    public static final String APPOINTMENT_UPDATED_SUCCESSFULLY = "The appointment was updated successfully";
    public static final String APPOINTMENT_DELETED_SUCCESSFULLY = "The appointment was deleted successfully";
    public static final String APPOINTMENT_CONSULTED_SUCCESSFULLY = "Appointment data retrieved successfully";
    public static final String APPOINTMENTS_CONSULTED_SUCCESSFULLY = "Retrieved all of the appointments successfully";
}
