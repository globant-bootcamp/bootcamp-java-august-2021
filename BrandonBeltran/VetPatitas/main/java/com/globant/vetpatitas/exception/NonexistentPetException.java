package com.globant.vetpatitas.exception;

public class NonexistentPetException extends RuntimeException {
    public NonexistentPetException(String message) {
        super(message);
    }
}
