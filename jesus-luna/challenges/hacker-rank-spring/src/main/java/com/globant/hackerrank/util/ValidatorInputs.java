package com.globant.hackerrank.util;

import org.springframework.stereotype.Component;

import com.globant.hackerrank.exceptions.ConstraintViolationException;

@Component
public class ValidatorInputs {
	public void validAtMostNLetters(int atMostConstraint, String inputToValidate) {
		if(inputToValidate.isEmpty() || inputToValidate.length() > atMostConstraint) {
			throw new ConstraintViolationException(String.format(Constants.CONSTRAINT_STRING_RANGE_ATMOST_INVALID, atMostConstraint));
		}
	}
}
