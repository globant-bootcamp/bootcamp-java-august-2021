package com.bootcamp.springtest.service.impl;

import com.bootcamp.springtest.service.PalindromeService;

import static com.bootcamp.springtest.utils.Constants.MSG_PALINDROME;
import static com.bootcamp.springtest.utils.Constants.YES;
import static com.bootcamp.springtest.utils.Constants.NO;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PalindromeServiceImpl implements PalindromeService {
    private static final Logger LOG = Logger.getLogger(PalindromeServiceImpl.class);

    @Override
    public String validatePalindrome(String wordToEvaluate) {
        String wordReverse = "";
        for (int pointer = wordToEvaluate.length() - 1; pointer >= 0; pointer--) {
            wordReverse = wordReverse + wordToEvaluate.charAt(pointer);
        }

        if (wordReverse.equals(wordToEvaluate)) {
            LOG.info(MSG_PALINDROME + YES);
            return MSG_PALINDROME + YES;
        } else {
            LOG.info(MSG_PALINDROME + NO);
            return MSG_PALINDROME + NO;
        }
    }
}
