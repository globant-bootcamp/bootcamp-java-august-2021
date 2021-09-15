package com.globant.vetpatitas.exception;

public class InvalidDeactivationRequest extends RuntimeException {
    public InvalidDeactivationRequest(String message) {
        super(message);
    }
}
