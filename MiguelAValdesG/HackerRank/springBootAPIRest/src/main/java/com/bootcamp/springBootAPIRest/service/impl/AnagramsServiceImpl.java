package com.bootcamp.springBootAPIRest.service.impl;

import com.bootcamp.springBootAPIRest.service.AnagramsService;
import com.bootcamp.springBootAPIRest.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnagramsServiceImpl implements AnagramsService {

  static boolean isAnagram(String firstWord, String secondWord) {
    if (firstWord.isEmpty() || secondWord.isEmpty() || firstWord.length() != secondWord.length()) {
      return false;
    } else {
      char[] firstWordArray = firstWord.toLowerCase().toCharArray();
      char[] secondWordArray = secondWord.toLowerCase().toCharArray();

      Arrays.sort(firstWordArray);
      Arrays.sort(secondWordArray);
      return Arrays.equals(firstWordArray, secondWordArray);
    }
  }

  public String anagrams(String firstWord, String secondWord) {
    boolean response = isAnagram(firstWord, secondWord);
    return response ? Constants.ANAGRAMS : Constants.NOT_ANAGRAMS;
  }

}
