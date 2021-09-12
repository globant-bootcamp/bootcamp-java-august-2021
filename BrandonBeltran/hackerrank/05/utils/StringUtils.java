package com.globant.bootcamp.utils;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    public static Map<Character, Integer> stringToMap(String string) {
        Map<Character, Integer> stringMap = new HashMap<>();

        for (int index = 0; index < string.length(); index++) {
            if (!stringMap.containsKey(string.charAt(index))) stringMap.put(string.charAt(index), 0);
            stringMap.put(string.charAt(index), stringMap.get(string.charAt(index)) + 1);
        }
        return stringMap;
    }
}
