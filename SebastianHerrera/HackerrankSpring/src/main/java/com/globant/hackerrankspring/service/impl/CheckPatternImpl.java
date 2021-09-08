package com.globant.hackerrankspring.service.impl;

import com.globant.hackerrankspring.model.GenericResponse;
import com.globant.hackerrankspring.model.PatternSyntaxRequest;
import com.globant.hackerrankspring.service.CheckPatternService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 03/09/21
 */
@Log4j2
@Service
public class CheckPatternImpl implements CheckPatternService {

    @Value("${constans.valid-message}")
    private String validMessage;

    @Value("${constans.not-valid-message}")
    private String notValidMessage;

    @Override
    public GenericResponse checkPattern(PatternSyntaxRequest patternSyntaxRequest) {

        String response = notValidMessage;
        String stringSyntaxPattern = patternSyntaxRequest.getPattern();
        Pattern.compile(stringSyntaxPattern);
        response = validMessage;
        log.info(validMessage);

        return GenericResponse.builder().response(response).build();
    }
}
