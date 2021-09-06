package com.bootcamp.springBootAPIRest.service.impl;

import com.bootcamp.springBootAPIRest.service.AnagramsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnagramsServiceImpl implements AnagramsService {

  static boolean isAnagram(String firstWord, String secondWord) {
    if (firstWord.isEmpty() || secondWord.isEmpty() || firstWord.length() != secondWord.length()) {
      return false;
    }

    final int ONE = 1;
    Map<Character, Integer> firstWordMap = new HashMap<>();

    for (int index = 0; index < firstWord.length(); index++) {
      char character = firstWord.toLowerCase().charAt(index);

      if(!firstWordMap.containsKey(character)) {
        firstWordMap.put(character, ONE);
      } else {
        firstWordMap.put(character, firstWordMap.get(character) + ONE);
      }
    }

    for (int index = 0; index < secondWord.length(); index++) {
      char character = secondWord.toLowerCase().charAt(index);

      if (!firstWordMap.containsKey(character)) {
        return false;
      }

      Integer frequencyOfCharacter = firstWordMap.get(character);
      if (frequencyOfCharacter == 0) {
        return false;
      } else {
        firstWordMap.put(character, --frequencyOfCharacter);
      }
    }

    return true;
  }

  public String anagrams(String firstWord, String secondWord) {
    final String ANAGRAMS = "Anagrams";
    final String NOT_ANAGRAMS = "Not Anagrams";

    boolean response = isAnagram(firstWord, secondWord);
    return response ? ANAGRAMS : NOT_ANAGRAMS;
  }

}
