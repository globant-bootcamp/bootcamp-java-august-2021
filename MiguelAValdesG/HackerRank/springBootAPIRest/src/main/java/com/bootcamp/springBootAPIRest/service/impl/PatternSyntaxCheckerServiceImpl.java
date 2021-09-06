package com.bootcamp.springBootAPIRest.service.impl;

import com.bootcamp.springBootAPIRest.service.PatternSyntaxCheckerService;
import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Service
public class PatternSyntaxCheckerServiceImpl implements PatternSyntaxCheckerService {

  @Override
  public String patternSyntaxChecker(String[] patterns) {
    Logger log = Logger.getLogger("PatternSyntaxChecker");
    final String VALID = "Valid";
    final String INVALID = "Invalid";
    StringBuilder response = new StringBuilder();

    for (String pattern : patterns) {
      try {
        Pattern.compile(pattern);
        response.append(VALID).append(System.lineSeparator());
      } catch(PatternSyntaxException e) {
        response.append(INVALID).append(System.lineSeparator());
        log.fatal(e);
      }
    }

    return response.toString();
  }
}
