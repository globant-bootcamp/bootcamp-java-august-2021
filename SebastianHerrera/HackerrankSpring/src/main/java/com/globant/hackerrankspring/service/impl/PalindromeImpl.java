package com.globant.hackerrankspring.service.impl;

import com.globant.hackerrankspring.model.GenericResponse;
import com.globant.hackerrankspring.model.PalindromeRequest;
import com.globant.hackerrankspring.service.PalindromeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 02/09/21
 */
@Service
@Log4j2
public class PalindromeImpl implements PalindromeService {

    @Value("${constans.valid-message}")
    private String validMessage;

    @Value("${constans.not-valid-message}")
    private String notValidMessage;

    @Override
    public GenericResponse validatePalindrome(PalindromeRequest palindromeRequest) {

        String response = notValidMessage;
        String word = palindromeRequest.getWord().toLowerCase();

        if (word.equals(new StringBuilder(word).reverse().toString())) {
            response = validMessage;
            log.info(validMessage);
        } else {
            log.info(notValidMessage);
        }
        return GenericResponse.builder().response(response).build();
    }
}
