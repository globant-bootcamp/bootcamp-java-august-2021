package com.globant.bootcamp.service.impl;

import com.globant.bootcamp.dto.PalindromeDTO;
import com.globant.bootcamp.service.PalindromeService;
import org.springframework.stereotype.Service;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    @Override
    public PalindromeDTO palindromeCheck(PalindromeDTO palindromeDTO) {
        palindromeDTO.setPalindrome(Boolean.TRUE);
        String stringToEvaluate = palindromeDTO.getString();
        for (int index = 0; index < stringToEvaluate.length() / 2; index++) {
            if (stringToEvaluate.charAt(index) != stringToEvaluate.charAt(stringToEvaluate.length() - 1 - index)) {
                palindromeDTO.setPalindrome(Boolean.FALSE);
                break;
            }
        }
        return palindromeDTO;
    }
}
