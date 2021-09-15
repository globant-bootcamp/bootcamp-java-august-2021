package com.globant.vetpatitas.exception;

public class NonexistantAppointmentException extends RuntimeException {
    public NonexistantAppointmentException (String message) {
        super(message);
    }
}
