package com.oswaldo.springboot.service.impl;

import com.oswaldo.springboot.dto.StringReverseDTO;
import com.oswaldo.springboot.service.StringReverseService;
import org.springframework.stereotype.Service;

import static com.oswaldo.springboot.utils.Constants.NO;
import static com.oswaldo.springboot.utils.Constants.YES;

@Service
public class StringReverseServiceImpl implements StringReverseService {

    @Override
    public StringReverseDTO isPalindrome(StringReverseDTO javaStringReverseDTO) {

        String phrase = javaStringReverseDTO.getInputString();
        String reversedPhrase = new StringBuilder(phrase).reverse().toString();

        javaStringReverseDTO.setPalindrome((phrase.equals(reversedPhrase))? YES:NO);

        return javaStringReverseDTO;
    }

}
