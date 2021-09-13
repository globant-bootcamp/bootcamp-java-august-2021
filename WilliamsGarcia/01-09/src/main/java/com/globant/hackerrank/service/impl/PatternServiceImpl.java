package com.globant.hackerrank.service.impl;

import com.globant.hackerrank.dto.PatternDTO;
import com.globant.hackerrank.exception.InvalidPatternException;
import com.globant.hackerrank.service.PatternService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static com.globant.hackerrank.utils.Constants.IS_PATTERN_VALID;
import static com.globant.hackerrank.utils.Constants.NO_PATTERN_VALID;

@Service
public class PatternServiceImpl implements PatternService {

    private static final Logger LOGGER = LogManager.getLogger(PatternServiceImpl.class);

    @Override
    public PatternDTO validPattern(PatternDTO patternDTO) {
        String pattern = patternDTO.getInputString();

        try {
            Pattern.compile(pattern);
            patternDTO.setValid(Boolean.TRUE);
            LOGGER.info(IS_PATTERN_VALID);
        } catch (PatternSyntaxException e) {
            LOGGER.error(NO_PATTERN_VALID);
            throw new InvalidPatternException(NO_PATTERN_VALID);
        }
        return patternDTO;
    }
}
