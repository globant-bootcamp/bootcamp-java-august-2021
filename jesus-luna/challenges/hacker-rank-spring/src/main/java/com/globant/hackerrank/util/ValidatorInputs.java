package com.globant.hackerrank.util;

import org.springframework.stereotype.Component;

import com.globant.hackerrank.dto.RequestDTO;
import com.globant.hackerrank.exceptions.ConstraintViolationException;
import com.globant.hackerrank.model.PatternSyntaxRequest;

@Component
public class ValidatorInputs {
	public void validAtMostNLetters(int atMostConstraint, String inputToValidate) {
		if(inputToValidate.isEmpty() || inputToValidate.length() > atMostConstraint) {
			throw new ConstraintViolationException(String.format(Constants.CONSTRAINT_STRING_RANGE_ATMOST_INVALID, atMostConstraint));
		}
	}
	
	public void validateNullRequestData(RequestDTO<?> request) {
		if (request == null || request.getData() == null) {
			throw new ConstraintViolationException(Constants.REQUEST_DATA_ERROR);
		}
	}
	
	public void validateNullPaternRequest(RequestDTO<PatternSyntaxRequest> request) {
		//validateNullRequestData(request);
		if (request.getData().getPatterns() == null || request.getData().getPatterns().isEmpty()) {
			throw new ConstraintViolationException(Constants.PATTERNS_ERROR);
		}
	}
}
