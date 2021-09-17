package com.globant.vet.util.constants;

public enum PetTypeConstants {
	CANINE("Canine"),
	FELINE("Feline"),
	BIRD("Bird");
	
	private String type;
	
	private PetTypeConstants(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
