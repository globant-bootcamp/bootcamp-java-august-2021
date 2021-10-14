package com.bootcamp.springdatajpa.utils;

import com.bootcamp.springdatajpa.entity.Address;
import com.bootcamp.springdatajpa.entity.Owner;

public class Constants {

  public static final int ZERO = 0;
  public static final int ONE = 1;

  public static final Long ADDRESS_ID = 1L;
  public static final String ADDRESS_STREET = "GenericStreet";
  public static final int ADDRESS_EXT_NUMBER = 123;
  public static final int ADDRESS_INT_NUMBER = 456;
  public static final String ADDRESS_COLONY = "GenericColony";
  public static final String ADDRESS_MUNICIPALITY = "GenericMunicipality";
  public static final String ADDRESS_STATE = "GenericState";
  public static final int ADDRESS_ZIP_CODE = 11111;
  public static final String ADDRESS_STREET_UPDATE = "UpdateStreet";
  public static final int ADDRESS_EXT_NUMBER_UPDATE = 789;
  public static final int ADDRESS_INT_NUMBER_UPDATE = 123;
  public static final String ADDRESS_COLONY_UPDATE = "UpdateColony";
  public static final String ADDRESS_MUNICIPALITY_UPDATE = "UpdateMunicipality";
  public static final String ADDRESS_STATE_UPDATE = "UpdateState";
  public static final int ADDRESS_ZIP_CODE_UPDATE = 22222;

  public static final Long OWNER_ID = 1L;
  public static final Address OWNER_ADDRESS = new Address(ADDRESS_ID, ADDRESS_STREET, ADDRESS_EXT_NUMBER,
    ADDRESS_INT_NUMBER, ADDRESS_COLONY, ADDRESS_MUNICIPALITY, ADDRESS_STATE, ADDRESS_ZIP_CODE);
  public static final String OWNER_FIRST_NAME = "GenericFirstName";
  public static final String OWNER_LAST_NAME = "GenericLastName";
  public static final int OWNER_AGE = 18;
  public static final String OWNER_EMAIL = "generic@test.com";
  public static final String OWNER_PHONE = "3344556677";
  public static final boolean OWNER_ACTIVE = true;
  public static final Address OWNER_ADDRESS_UPDATE = new Address(ADDRESS_ID, ADDRESS_STREET_UPDATE,
    ADDRESS_EXT_NUMBER_UPDATE, ADDRESS_INT_NUMBER_UPDATE, ADDRESS_COLONY_UPDATE, ADDRESS_MUNICIPALITY_UPDATE,
    ADDRESS_STATE_UPDATE, ADDRESS_ZIP_CODE_UPDATE);
  public static final String OWNER_FIRST_NAME_UPDATE = "UpdateFirstName";
  public static final String OWNER_LAST_NAME_UPDATE = "UpdateLastName";
  public static final int OWNER_AGE_UPDATE = 28;
  public static final String OWNER_EMAIL_UPDATE = "update@test.com";
  public static final String OWNER_PHONE_UPDATE = "4455667788";

  public static final Long PET_ID = 1L;
  public static final Long PET_ID_OWNER = 1L;
  public static final Owner PET_OWNER = new Owner(OWNER_ID, OWNER_ADDRESS, OWNER_FIRST_NAME, OWNER_LAST_NAME,
    OWNER_AGE, OWNER_EMAIL, OWNER_PHONE, OWNER_ACTIVE);
  public static final String PET_NAME = "GenericName";
  public static final int PET_AGE = 10;
  public static final String PET_SPECIES = "GenericSpecies";
  public static final String PET_BREED = "GenericBreed";
  public static final String PET_COLOR = "GenericColor";
  public static final double PET_WEIGHT = 10.8;
  public static final boolean PET_ACTIVE = true;
  public static final Long PET_ID_OWNER_UPDATE = 2L;
  public static final Owner PET_OWNER_UPDATE = new Owner(OWNER_ID, OWNER_ADDRESS_UPDATE, OWNER_FIRST_NAME_UPDATE, OWNER_LAST_NAME_UPDATE,
    OWNER_AGE_UPDATE, OWNER_EMAIL_UPDATE, OWNER_PHONE_UPDATE, OWNER_ACTIVE);
  public static final String PET_NAME_UPDATE = "UpdateName";
  public static final int PET_AGE_UPDATE = 11;
  public static final String PET_SPECIES_UPDATE = "UpdateSpecies";
  public static final String PET_BREED_UPDATE = "UpdateBreed";
  public static final String PET_COLOR_UPDATE = "UpdateColor";
  public static final double PET_WEIGHT_UPDATE = 5.8;

}
