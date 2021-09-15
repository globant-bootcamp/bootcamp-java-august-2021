package com.bootcamp.springdatajpa.exception;

public class InvalidDataException extends RuntimeException {

  public InvalidDataException(String message) {
    super(message);
  }

}
