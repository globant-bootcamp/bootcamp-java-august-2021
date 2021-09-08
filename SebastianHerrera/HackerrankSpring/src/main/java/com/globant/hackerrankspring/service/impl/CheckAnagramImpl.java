package com.globant.hackerrankspring.service.impl;

import com.globant.hackerrankspring.model.AnagramRequest;
import com.globant.hackerrankspring.model.GenericResponse;
import com.globant.hackerrankspring.service.CheckAnagramService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 03/09/21
 */
@Log4j2
@Service
public class CheckAnagramImpl implements CheckAnagramService {

    @Value("${constans.valid-message}")
    private String validMessage;

    @Value("${constans.not-valid-message}")
    private String notValidMessage;

    @Value("${constans.not-valid-length}")
    private String notValidLength;

    @Override
    public GenericResponse checkAnagram(AnagramRequest anagramRequest) {

        String response = notValidMessage;

        String firstWord = anagramRequest.getFirstWord().toLowerCase();
        String secondWord = anagramRequest.getSecondWord().toLowerCase();

        if (firstWord.length() == secondWord.length()) {
            char[] firstArray = firstWord.toCharArray();
            char[] secondArray = secondWord.toCharArray();
            Arrays.sort(firstArray);
            Arrays.sort(secondArray);
            String firstStringWord = new String(firstArray);
            String secondStringWord = new String(secondArray);
            if (firstStringWord.equals(secondStringWord)) {
                response = validMessage;
                log.info(validMessage);

            } else {
                log.info(notValidMessage);

            }
        } else {
            response = notValidLength;
            log.info(notValidLength);

        }
        return GenericResponse.builder().response(response).build();
    }
}
