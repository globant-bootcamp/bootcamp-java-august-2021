package com.globant.springdata.exception;

public class IllegalArgumentException extends RuntimeException{
    public IllegalArgumentException(String message){
        super(String.valueOf(message));
    }
}
