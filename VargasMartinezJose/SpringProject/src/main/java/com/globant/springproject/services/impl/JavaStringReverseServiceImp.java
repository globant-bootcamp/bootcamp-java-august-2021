package com.globant.springproject.services.impl;

import com.globant.springproject.services.JavaStringReverseService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class JavaStringReverseServiceImp implements JavaStringReverseService {
    private static final Logger LOGGER= Logger.getLogger(JavaStringReverseServiceImp.class);
    private static final String VALID_OUTPUT = "Yes, your input can be read it backwards, as well.";
    private static final String INVALID_OUTPUT = "Sorry, look for another word";
    @Override
    public String palindromeWord(String word) {
        String newWord=word.toLowerCase();
        int index = 0, indexReset=newWord.length()-1;
        while(newWord.charAt(index)==newWord.charAt(indexReset) && (index++)<=(indexReset--));
            if(index>indexReset){
                LOGGER.debug(VALID_OUTPUT);
                return VALID_OUTPUT;
            }
            else{
                LOGGER.debug(INVALID_OUTPUT);
                return INVALID_OUTPUT;
            }
        }
    }
