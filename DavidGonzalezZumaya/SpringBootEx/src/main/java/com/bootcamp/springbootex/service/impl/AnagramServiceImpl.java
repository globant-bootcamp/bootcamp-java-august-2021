package com.bootcamp.springbootex.service.impl;

import com.bootcamp.springbootex.service.AnagramService;
import com.bootcamp.springbootex.utils.Constants;
import org.springframework.stereotype.Service;

@Service
public class AnagramServiceImpl implements AnagramService {

    public String isAnagram(String firstWord, String secondWord){

        int length = firstWord.length();
        String firstWordLower = firstWord.toLowerCase();
        String secondWordLower = secondWord.toLowerCase();
        String isAnagram = Constants.YES;

        for (int index = 0; index < length; index++) {
            char compare = secondWordLower.charAt(index);
            int position = firstWordLower.indexOf(compare);

            if(position == -1 ){
                isAnagram = Constants.NO;
            } else{
                isAnagram = validation(firstWordLower, secondWordLower, length);
            }
        }
        return isAnagram;
    }

    static String validation(String firstWord, String secondWord, int length){

        int sumFirstWordASCII = 0;
        int sumSecondWordASCII = 0;

        for (int index = 0; index < length; index++) {
            sumFirstWordASCII += firstWord.charAt(index);
            sumSecondWordASCII += secondWord.charAt(index);
        }

        if(sumFirstWordASCII == sumSecondWordASCII){
            return Constants.YES;
        }else{
            return Constants.NO;
        }
    }
}
