package com.globant.springBootProject.service.impl;

import com.globant.springBootProject.dto.AnagramsDTO;
import com.globant.springBootProject.service.AnagramsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AnagramsServiceImpl implements AnagramsService {

    @Override
    public AnagramsDTO solution(AnagramsDTO anagramsDTO) {
        char[] line1Array = anagramsDTO.getLine1().toCharArray();
        char[] line2Array = anagramsDTO.getLine2().toCharArray();
        Map<Character, Integer> lettersFromMLine1 = getHashMap(line1Array);
        Map<Character, Integer> lettersFromMLine2 = getHashMap(line2Array);

        if (lettersFromMLine1.equals(lettersFromMLine2)) {
            anagramsDTO.setAnagram(Boolean.TRUE);
        } else {
            anagramsDTO.setAnagram(Boolean.FALSE);
        }

        return anagramsDTO;
    }

    private static Map<Character, Integer> getHashMap(char[] line) {
        Map<Character, Integer> lettersHashMap = new HashMap<Character, Integer>();

        for (char letter : line) {
            letter = Character.toUpperCase(letter);
            if (lettersHashMap.containsKey(letter)) {
                lettersHashMap.put(letter, lettersHashMap.get(letter) + 1);
            } else {
                lettersHashMap.put(letter, 1);
            }
        }

        return lettersHashMap;
    }
}
