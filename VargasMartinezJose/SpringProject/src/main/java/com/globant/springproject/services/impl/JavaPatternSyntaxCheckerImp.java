package com.globant.springproject.services.impl;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.globant.springproject.services.JavaPatternSyntaxChecker;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class JavaPatternSyntaxCheckerImp implements JavaPatternSyntaxChecker {
    private static final Logger LOGGER = Logger.getLogger(JavaPatternSyntaxCheckerImp.class);
    private static final String VALID_INPUT = "Valid Input";
    private static final String INVALID_INPUT = "Invalid Input";
    @Override
    public String validatePattern(String patternToValidate) {
        try {
                Pattern pattern = null;
                Pattern.compile(patternToValidate);
                LOGGER.debug(VALID_INPUT);
                return VALID_INPUT;
            } catch (PatternSyntaxException exception) {
                LOGGER.debug(INVALID_INPUT);
                return INVALID_INPUT;
            }
        }
}
