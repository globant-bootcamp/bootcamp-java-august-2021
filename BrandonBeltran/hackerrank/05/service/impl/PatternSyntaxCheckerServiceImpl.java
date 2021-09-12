package com.globant.bootcamp.service.impl;

import com.globant.bootcamp.dto.RegexPatternDTO;
import com.globant.bootcamp.service.PatternSyntaxCheckerService;
import org.springframework.stereotype.Service;

import java.util.regex.PatternSyntaxException;

import static java.util.regex.Pattern.compile;

@Service
public class PatternSyntaxCheckerServiceImpl implements PatternSyntaxCheckerService {

    @Override
    public RegexPatternDTO syntaxChecker(RegexPatternDTO regexPatternDTO) {

        try {
            compile(regexPatternDTO.getPattern());
            regexPatternDTO.setValid(Boolean.TRUE);
        } catch (PatternSyntaxException exception) {
            regexPatternDTO.setValid(Boolean.FALSE);
        }
        return regexPatternDTO;
    }
}
