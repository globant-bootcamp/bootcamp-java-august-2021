package com.bootcamp.springdatajpa.utils;

public class Constants {

  public enum ResponseConstants {
    SUCCESS("Successful"),
    FAILURE("Unsuccessful");

    private String description;

    ResponseConstants(final String description) {
      this.description = description;
    }
  }

  public static final String ADDRESS_NOT_FOUND = "The address was not found";
  public static final String ADDRESS_FOUND_SUCCESSFULLY = "The address(es) was found successfully";
  public static final String ADDRESS_ADDED_SUCCESSFULLY = "The address was added successfully";
  public static final String ADDRESS_UPDATED_SUCCESSFULLY = "The address was updated successfully";
  public static final String ADDRESS_DELETED_SUCCESSFULLY = "The address was deleted successfully";
  public static final String ADDRESS_CANNOT_BE_DELETED = "We can't delete an Address who is in relation to a Pet Owner";

  public static final String OWNER_NOT_FOUND = "The owner was not found";
  public static final String OWNER_FOUND_SUCCESSFULLY = "The owner(s) was found successfully";
  public static final String OWNER_ADDED_SUCCESSFULLY = "The owner was added successfully";
  public static final String OWNER_UPDATED_SUCCESSFULLY = "The owner was updated successfully";
  public static final String OWNER_DELETED_SUCCESSFULLY = "The owner was deleted successfully";

  public static final String PET_NOT_FOUND = "The pet was not found";
  public static final String PET_FOUND_SUCCESSFULLY = "The pet(s) was found successfully";
  public static final String PET_ADDED_SUCCESSFULLY = "The pet was added successfully";
  public static final String PET_UPDATED_SUCCESSFULLY = "The pet was updated successfully";
  public static final String PET_DELETED_SUCCESSFULLY = "The pet was deleted successfully";


}
