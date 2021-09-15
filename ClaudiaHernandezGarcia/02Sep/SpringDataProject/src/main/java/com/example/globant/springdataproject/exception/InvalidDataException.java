package com.example.globant.springdataproject.exception;

import java.io.IOException;

public class InvalidDataException extends IOException {

    public InvalidDataException(String message) {
        super(message);
    }
}
