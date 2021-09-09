package com.oswaldo.springboot.service.impl;

import com.oswaldo.springboot.dto.AnagramDTO;
import com.oswaldo.springboot.service.AnagramService;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

import static com.oswaldo.springboot.utils.Constants.ANAGRAMS;
import static com.oswaldo.springboot.utils.Constants.NOT_ANAGRAMS;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public AnagramDTO areAnagram(AnagramDTO anagramDTO) {
        String inputOne = anagramDTO.getInputStringOne().toLowerCase();
        String inputTwo = anagramDTO.getInputStringTwo().toLowerCase();

        anagramDTO.setResult(ANAGRAMS);

        if (inputOne.length() != inputTwo.length()) {
            anagramDTO.setResult(NOT_ANAGRAMS);
        } else {

            String[] arrayOne = inputOne.split("");
            String[] arrayTwo = inputTwo.split("");

            Set<String> charactersOne = new HashSet<>(Arrays.asList(arrayOne));
            Set<String> charactersTwo = new HashSet<>(Arrays.asList(arrayTwo));

            charactersTwo.addAll(charactersOne);

            if (charactersOne.size() == charactersTwo.size()) {

                Map<String, Integer> frequencyTableOne = createFrequencyTable(arrayOne);
                Map<String, Integer> frequencyTableTwo = createFrequencyTable(arrayTwo);

                checkSameFrequency(frequencyTableOne, frequencyTableTwo, anagramDTO);

            } else {
                anagramDTO.setResult(NOT_ANAGRAMS);
            }

        }
        return anagramDTO;
    }

    private Map<String, Integer> createFrequencyTable(String[] characters) {
        Map<String, Integer> frequencyTable = new HashMap<>();
        for (String character : characters) {
            Integer frequency = frequencyTable.get(character);
            frequencyTable.put(character, (frequency == null) ? 1 : frequency + 1);
        }
        return frequencyTable;
    }

    private void checkSameFrequency(Map<String, Integer> frequencyTableOne, Map<String, Integer> frequencyTableTwo, AnagramDTO anagramDTO) {
        for (String character : frequencyTableOne.keySet()) {
            Integer currentFrequencyOne = frequencyTableOne.get(character);
            Integer currentFrequencyTwo = frequencyTableTwo.get(character);
            if (!currentFrequencyOne.equals(currentFrequencyTwo)) {
                anagramDTO.setResult(NOT_ANAGRAMS);
                break;
            }
        }
    }


}
