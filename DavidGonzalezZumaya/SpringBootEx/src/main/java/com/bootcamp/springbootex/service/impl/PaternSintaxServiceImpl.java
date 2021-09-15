package com.bootcamp.springbootex.service.impl;

import com.bootcamp.springbootex.service.PatternSintaxService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Service
public class PaternSintaxServiceImpl implements PatternSintaxService {

    public List<String> patternValidation(String[] patterns) {

        List<String> responseList = new ArrayList<>();

        int size = patterns.length;

        for (int index = 0; index < size; index++) {
            try {
                Pattern.compile(patterns[index]);
                responseList.add("Valid");
            } catch (PatternSyntaxException e) {
                responseList.add("Invalid");
            }
        }
        return responseList;
    }
}
