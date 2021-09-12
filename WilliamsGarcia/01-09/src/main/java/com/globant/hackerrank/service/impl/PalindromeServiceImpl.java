package com.globant.hackerrank.service.impl;

import com.globant.hackerrank.dto.StringReverseDTO;
import com.globant.hackerrank.exception.IsNotPalindromeException;
import com.globant.hackerrank.service.PalindromeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import static com.globant.hackerrank.utils.Constants.IS_PALINDROME;
import static com.globant.hackerrank.utils.Constants.NO_PALINDROME;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    private static final Logger LOGGER = LogManager.getLogger(PalindromeServiceImpl.class);

    @Override
    public StringReverseDTO validPalindrome(StringReverseDTO stringReverseDTO) {

        if (stringReverseDTO.getInputString().length() <= 50) {
            final String inputStringLowerCase = stringReverseDTO.getInputString().toLowerCase();
            StringBuilder inputStringReverse = new StringBuilder(inputStringLowerCase);

            if (inputStringLowerCase.equals(inputStringReverse.reverse().toString())) {
                stringReverseDTO.setPalindrome(Boolean.TRUE);
                LOGGER.info(IS_PALINDROME);
            } else {
                LOGGER.error(NO_PALINDROME);
                throw new IsNotPalindromeException(NO_PALINDROME);
            }
        }
        return stringReverseDTO;
    }
}
