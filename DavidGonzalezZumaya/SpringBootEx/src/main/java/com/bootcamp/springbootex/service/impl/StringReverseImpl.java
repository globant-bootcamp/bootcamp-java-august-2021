package com.bootcamp.springbootex.service.impl;

import com.bootcamp.springbootex.utils.Constants;
import com.bootcamp.springbootex.service.StringReverseService;
import org.springframework.stereotype.Service;

@Service
public class StringReverseImpl implements StringReverseService {

    public String stringReverse(String palindrome) {

        int palindromeLength = palindrome.length();
        int halfOfPalindromeLength = palindromeLength / 2;
        int counter = 0;

        for (int index = 0; index < halfOfPalindromeLength; index++) {
            if (palindrome.charAt(index) == palindrome.charAt(palindromeLength - index - 1)) {
                counter++;
            }
        }

        if (counter == halfOfPalindromeLength) {
            return Constants.YES;
        } else {
            return Constants.NO;
        }
    }
}
