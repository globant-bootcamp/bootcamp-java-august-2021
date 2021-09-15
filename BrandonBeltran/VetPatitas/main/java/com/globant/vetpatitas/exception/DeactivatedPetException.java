package com.globant.vetpatitas.exception;

public class DeactivatedPetException extends RuntimeException {
    public DeactivatedPetException(String message) {
        super(message);
    }
}
