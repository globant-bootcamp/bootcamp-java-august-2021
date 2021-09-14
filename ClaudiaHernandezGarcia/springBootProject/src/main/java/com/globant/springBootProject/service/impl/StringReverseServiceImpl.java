package com.globant.springBootProject.service.impl;

import com.globant.springBootProject.dto.StringReverseDTO;
import com.globant.springBootProject.service.StringReverseService;
import org.springframework.stereotype.Service;

@Service
public class StringReverseServiceImpl implements StringReverseService {

    @Override
    public StringReverseDTO solution(StringReverseDTO stringReverseDTO) {
        StringBuilder inputStringReverse = new StringBuilder();

        for (int i = stringReverseDTO.getWordToEvaluate().length() - 1; i >= 0; i --) {
            inputStringReverse.append(stringReverseDTO.getWordToEvaluate().charAt(i));
        }

        if (stringReverseDTO.getWordToEvaluate().equals(inputStringReverse.toString())) {
            stringReverseDTO.setPalindrome(Boolean.TRUE);
        } else {
            stringReverseDTO.setPalindrome(Boolean.FALSE);
        }

        return stringReverseDTO;
    }
}
