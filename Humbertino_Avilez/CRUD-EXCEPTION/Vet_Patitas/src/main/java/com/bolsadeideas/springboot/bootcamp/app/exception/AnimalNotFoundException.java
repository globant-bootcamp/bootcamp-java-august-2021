package com.bolsadeideas.springboot.bootcamp.app.exception;

public class AnimalNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public AnimalNotFoundException(String message) {
		super(message);
	}
}
