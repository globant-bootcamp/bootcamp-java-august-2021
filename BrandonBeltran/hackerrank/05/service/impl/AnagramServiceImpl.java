package com.globant.bootcamp.service.impl;

import com.globant.bootcamp.dto.AnagramDTO;
import com.globant.bootcamp.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.globant.bootcamp.utils.StringUtils.stringToMap;

@Service
public class AnagramServiceImpl implements AnagramService {


    @Override
    public AnagramDTO evaluateAnagram(AnagramDTO anagramDTO) {

        if (anagramDTO.getWordOne().length() != anagramDTO.getWordTwo().length()) {
            anagramDTO.setAnagram(Boolean.FALSE);
        } else {
            Map<Character, Integer> wordOneStringMap = stringToMap(anagramDTO.getWordOne().toLowerCase());
            Map<Character, Integer> wordTwoStringMap = stringToMap(anagramDTO.getWordTwo().toLowerCase());

            anagramDTO.setAnagram(wordOneStringMap.equals(wordTwoStringMap));

        }
        return anagramDTO;
    }
}
