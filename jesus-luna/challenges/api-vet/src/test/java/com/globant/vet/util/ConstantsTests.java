package com.globant.vet.util;

import java.time.LocalDateTime;
import java.time.Month;

public class ConstantsTests {
	public static final int ID_PET = 10;
	public static final String NAME_PET = "Riley";
	public static final String TYPE_PET = "Canine";
	public static final int AGE_PET = 1;
	public static final LocalDateTime MEETING_PET = LocalDateTime.of(2021, Month.DECEMBER, 29, 19, 30, 00);
	
	public static final int ID_CUSTOMER = 20;
	public static final String NAME_CUSTOMER = "Fulanito";
	
	public static final String PET_NOT_FOUND = "None pet have been found with id: %d";
	
}
