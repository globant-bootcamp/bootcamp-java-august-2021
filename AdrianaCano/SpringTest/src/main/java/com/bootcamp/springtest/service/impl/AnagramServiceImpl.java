package com.bootcamp.springtest.service.impl;

import com.bootcamp.springtest.service.AnagramsService;
import static com.bootcamp.springtest.utils.Constants.MSG_ANAGRAM;
import static com.bootcamp.springtest.utils.Constants.MSG_NO_ANAGRAM;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

@Service
public class AnagramServiceImpl implements AnagramsService {
    private static final Logger LOG = Logger.getLogger(AnagramServiceImpl.class);

    @Override
    public String validateAnagram(String wordOne, String wordTwo) {
        if (wordOne.length() == wordTwo.length()) {
            wordOne = wordOne.toLowerCase();
            wordTwo = wordTwo.toLowerCase();
            Map<Character, Integer> mapWordOne = validateWordOne(wordOne);
            Map<Character, Integer> mapWordTwo = validateWordTwo(wordTwo);
            if (mapWordOne.equals(mapWordTwo)) {
                LOG.info(MSG_ANAGRAM);
                return MSG_ANAGRAM;
            } else {
                LOG.info(MSG_NO_ANAGRAM);
                return MSG_NO_ANAGRAM;
            }
        } else {
            LOG.info(MSG_NO_ANAGRAM);
            return MSG_NO_ANAGRAM;
        }
    }

    public Map<Character, Integer> validateWordOne(String wordOne) {
        Integer counterOne = 0;
        Map<Character, Integer> mapWordOne = new HashMap<>();
        for (int pointer = 0; pointer < wordOne.length(); pointer++) {
            char letterWordOne = wordOne.charAt(pointer);
            if (!mapWordOne.containsKey(letterWordOne)) {
                mapWordOne.put(letterWordOne, 1);
            } else {
                counterOne = mapWordOne.get(letterWordOne);
                mapWordOne.put(letterWordOne, counterOne + 1);
            }
        }
        return mapWordOne;
    }

    public Map<Character, Integer> validateWordTwo(String wordTwo) {
        Integer counterTwo = 0;
        Map<Character, Integer> mapWordTwo = new HashMap<>();
        for (int pointer = 0; pointer < wordTwo.length(); pointer++) {
            char letterWordTwo = wordTwo.charAt(pointer);
            if (!mapWordTwo.containsKey(letterWordTwo)) {
                mapWordTwo.put(letterWordTwo, 1);
            } else {
                counterTwo = mapWordTwo.get(letterWordTwo);
                mapWordTwo.put(letterWordTwo, counterTwo + 1);
            }
        }
        return mapWordTwo;
    }
}
