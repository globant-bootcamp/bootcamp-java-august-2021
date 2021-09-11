package com.bootcamp.vetPatitas.utils;

public class Constants {

	public enum ResponseConstants{
		SUCCESS("Successful"), FAILURE("Unsuccessful");
		
		private String description;
		
		ResponseConstants(final String description) {
			this.description = description;
		}
		
		public String getDescription() {
			return description;
		}
		 
	}
	
	public static final String VALIDATION_USER = "The user was validated success";
	public static final String POSITIVE = "POSITIVE";
	public static final String USER_ADDED_SUCCESSFULLY = "User added to data base successfully";
	public static final String PET_ADDED_SUCCESSFULLY = "Pet added to data base successfully";
	public static final String PET_FOUNDED_SUCCESSFULLY = " The pet was founded successfully";
	public static final String PET_UPDATED_SUCCESSFULLY = " The pet was updated successfully";
	public static final String PET_DELETED_SUCCESSFULLY = " The pet was deleted successfully";
	
}
