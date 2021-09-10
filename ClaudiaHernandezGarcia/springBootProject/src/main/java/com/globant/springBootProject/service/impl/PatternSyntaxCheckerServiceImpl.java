package com.globant.springBootProject.service.impl;

import com.globant.springBootProject.dto.PatternSyntaxCheckerDTO;
import com.globant.springBootProject.service.PatternSyntaxCheckerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Service
public class PatternSyntaxCheckerServiceImpl implements PatternSyntaxCheckerService {

    @Override
    public PatternSyntaxCheckerDTO Solution(PatternSyntaxCheckerDTO patternSyntaxCheckerDTO) {
        List<String> results = new ArrayList<String>();

        for (String pattern: patternSyntaxCheckerDTO.getPatterns()) {
            try {
                Pattern.compile(pattern);
                results.add("Valid");
            } catch (PatternSyntaxException exception) {
                results.add("Invalid");
            }
        };

        patternSyntaxCheckerDTO.setIsValidPattern(results.toArray(new String[0]));
        return patternSyntaxCheckerDTO;
    }

}
