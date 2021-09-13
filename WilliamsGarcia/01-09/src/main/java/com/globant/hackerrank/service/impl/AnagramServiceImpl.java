package com.globant.hackerrank.service.impl;

import com.globant.hackerrank.dto.AnagramDTO;
import com.globant.hackerrank.exception.IsNotAnagramException;
import com.globant.hackerrank.service.AnagramService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static com.globant.hackerrank.utils.Constants.IS_ANAGRAM;
import static com.globant.hackerrank.utils.Constants.NO_ANAGRAM;

@Service
public class AnagramServiceImpl implements AnagramService {

    private static final Logger LOGGER = LogManager.getLogger(AnagramServiceImpl.class);

    @Override
    public AnagramDTO validAnagram(AnagramDTO anagramDTO) {
        char[] inputStringOneChars = anagramDTO.getInputStringOne().toLowerCase().toCharArray();
        char[] inputStringTwoChars = anagramDTO.getInputStringTwo().toLowerCase().toCharArray();

        if (inputStringOneChars.length == inputStringTwoChars.length) {
            Arrays.sort(inputStringOneChars);
            Arrays.sort(inputStringTwoChars);
            anagramDTO.setInputStringOne(new String(inputStringOneChars));
            anagramDTO.setInputStringTwo(new String(inputStringTwoChars));

            if (anagramDTO.getInputStringOne().equals(anagramDTO.getInputStringTwo())) {
                anagramDTO.setAnagram(Boolean.TRUE);
                LOGGER.info(IS_ANAGRAM);
            } else {
                LOGGER.error(NO_ANAGRAM);
                throw new IsNotAnagramException(NO_ANAGRAM);
            }
        } else {
            LOGGER.error(NO_ANAGRAM);
            throw new IsNotAnagramException(NO_ANAGRAM);
        }
        return anagramDTO;
    }
}
