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
	

	public static final String PET_ADDED_SUCCESSFULLY = "Pet added to data base successfully";
	public static final String PET_ADDED_ERROR = "Pet was not added to data base";
	public static final String PET_FOUNDED_SUCCESSFULLY = " The pet was founded successfully";
	public static final String PET_UPDATED_SUCCESSFULLY = " The pet was updated successfully";
	public static final String PET_DELETED_SUCCESSFULLY = " The pet was deleted successfully";
	public static final String PET_INVALID_PHONE = "Phone number must have 10 digits";
	public static final String PET_NULL_NAME = "Name can't be null";
	public static final String PET_NULL_TYPE = "Type can't be null";
	public static final String PET_NULL_AGE = "Age can't be null";
	public static final String PET_NULL_OWNER = "Owner can't be null";
	
}
