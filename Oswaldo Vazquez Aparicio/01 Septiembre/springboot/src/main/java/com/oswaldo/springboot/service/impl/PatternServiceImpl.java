package com.oswaldo.springboot.service.impl;

import com.oswaldo.springboot.dto.PatternDTO;
import com.oswaldo.springboot.service.PatternService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static com.oswaldo.springboot.utils.Constants.INVALID;
import static com.oswaldo.springboot.utils.Constants.VALID;

@Service
public class PatternServiceImpl implements PatternService {

    @Override
    public PatternDTO isValidRegex(PatternDTO patternDTO) {
        String regexPattern = patternDTO.getRegexPattern();

        try {
            Pattern.compile(regexPattern);
            patternDTO.setIsValid(VALID);
        }catch (PatternSyntaxException e){
            patternDTO.setIsValid(INVALID);
        }

        return patternDTO;
    }

}
