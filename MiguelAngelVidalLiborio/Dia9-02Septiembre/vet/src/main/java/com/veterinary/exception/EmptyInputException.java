package com.veterinary.exception;

public class EmptyInputException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public EmptyInputException(String message) {
		super(message);
	}
}
