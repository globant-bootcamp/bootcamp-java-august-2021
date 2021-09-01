package com.bootcamp.daythree.hackerrank.hashtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    public static final String VALID = "Yes";
    public static final String NO_VALID = "No";

    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> words = new HashMap<>();
        
        for (String magazineWord : magazine) {
            words.merge(magazineWord, 1, Integer::sum);
        }
        if (checkNote(words, note)) {
            System.out.println(VALID);
        } else {
            System.out.println(NO_VALID);
        }
    }

    public static boolean checkNote(Map<String, Integer> words, List<String> note) {

        for (String noteWord : note) {
            if (words.containsKey(noteWord) && words.get(noteWord) > 0) {
                words.put(noteWord, words.get(noteWord) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
