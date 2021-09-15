package com.globant.vet.util;

import java.time.LocalDateTime;
import java.time.Month;

public class ConstantsTests {
	public static final int ID_PET_1 = 10;
	public static final int ID_PET_2 = 11;
	public static final int ID_PET_4 = 12;
	public static final int ID_PET_3 = 13;
	
	
	public static final int ID_PET_NOT_FOUND = 100;
	public static final int ID_CUSTOMER_NOT_FOUND = 200;
	public static final String NAME_PET = "Riley";
	public static final String TYPE_PET = "Canine";
	public static final int AGE_PET = 1;
	public static final LocalDateTime MEETING_PET = LocalDateTime.of(2021, Month.DECEMBER, 29, 19, 30, 00);
	
	public static final int ID_CUSTOMER = 20;
	public static final String NAME_CUSTOMER = "Fulanito";
	public static final int ID_CUSTOMER_2 = 30;
	public static final String NAME_CUSTOMER_2 = "Menganito";
	
	public static final String PET_NOT_FOUND = "None pet have been found with id: %d";
	public static final String PET_DELETED = "Pet was deleted";
	
	public static final String CUSTOMER_NOT_FOUND = "None customer have been found with id: %d";
	public static final String CUSTOMER_DELETED = "Customer was deleted";
	
}
