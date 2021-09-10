package com.bootcamp.springBootAPIRest.service.impl;

import com.bootcamp.springBootAPIRest.service.PatternSyntaxCheckerService;
import com.bootcamp.springBootAPIRest.utils.Constants;
import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Service
public class PatternSyntaxCheckerServiceImpl implements PatternSyntaxCheckerService {

  @Override
  public List<String> patternSyntaxChecker(String[] patterns) {
    Logger log = Logger.getLogger(Constants.PATTERN_SYNTAX_CHECKER);
    List<String> responseList = new ArrayList<>();

    for (String pattern : patterns) {
      try {
        Pattern.compile(pattern);
        responseList.add(Constants.VALID);
      } catch (PatternSyntaxException e) {
        responseList.add(Constants.INVALID);
        log.fatal(e);
      }
    }

    return responseList;
  }
}
