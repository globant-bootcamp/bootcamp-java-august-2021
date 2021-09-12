package com.globant.vet.util.constants;

public enum ResponseConstants {
	SUCCESS("everything goes well"), FAILURE("Something went wrong");
	
	private String description;
	
	private ResponseConstants(final String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}		
}
