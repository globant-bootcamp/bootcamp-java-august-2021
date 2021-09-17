package com.bootcamp.springtest.service.impl;

import com.bootcamp.springtest.service.PatternSyntaxService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static com.bootcamp.springtest.utils.Constants.VALID_SYNTAX;
import static com.bootcamp.springtest.utils.Constants.INVALID_SYNTAX;

@Service
public class PatterSyntaxServiceImpl implements PatternSyntaxService {
    private static final Logger LOG = Logger.getLogger(PatterSyntaxServiceImpl.class);

    @Override
    public String validateSyntax(String pattern) {
        try {
            Pattern.compile(pattern);
            LOG.info(VALID_SYNTAX);
            return VALID_SYNTAX;
        } catch (PatternSyntaxException e) {
            LOG.info(INVALID_SYNTAX);
            return INVALID_SYNTAX;
        }
    }
}
