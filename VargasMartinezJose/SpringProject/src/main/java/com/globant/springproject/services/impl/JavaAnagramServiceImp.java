package com.globant.springproject.services.impl;

import com.globant.springproject.services.JavaAnagramService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class JavaAnagramServiceImp implements JavaAnagramService {
    private static final Logger LOGGER = Logger.getLogger(JavaAnagramServiceImp.class);
    HashMap<Character,Integer> hashMapOne = new HashMap<Character,Integer>();
    HashMap<Character,Integer> hashMapTwo = new HashMap<Character,Integer>();
    private static final String VALID_OUTPUT = "Anagram";
    private static final String INVALID_OUTPUT = "Not Anagram";

    @Override
    public String validateAnagram(String word, String anagram) {
        char originalWord[] = word.toCharArray();
        char anagramWord[] = anagram.toCharArray();
        Anagrams(originalWord, hashMapOne);
        Anagrams(anagramWord, hashMapTwo);
        if (hashMapOne.equals(hashMapTwo)) {
            return VALID_OUTPUT;
        }
        else {
            return INVALID_OUTPUT;
        }
    }
    private void Anagrams(char[] array, HashMap<Character, Integer> hashMapWord) {
        for (int index = 0; index < array.length; index++) {
            if (hashMapWord.get(array[index]) == null)
                hashMapWord.put(array[index], 1);
            else {
                int d = hashMapWord.get(array[index]);
                hashMapWord.put(array[index], ++d);
            }
        }
    }


}

