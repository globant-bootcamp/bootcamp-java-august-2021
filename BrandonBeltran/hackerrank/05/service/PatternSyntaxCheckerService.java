package com.globant.bootcamp.service;

import com.globant.bootcamp.dto.RegexPatternDTO;

public interface PatternSyntaxCheckerService {
    RegexPatternDTO syntaxChecker(RegexPatternDTO regexPatternDTO);
}
