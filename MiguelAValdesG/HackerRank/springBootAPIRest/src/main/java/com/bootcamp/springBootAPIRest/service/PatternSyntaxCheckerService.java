package com.bootcamp.springBootAPIRest.service;

import java.util.List;

public interface PatternSyntaxCheckerService {

  List<String> patternSyntaxChecker(String[] patterns);
}
