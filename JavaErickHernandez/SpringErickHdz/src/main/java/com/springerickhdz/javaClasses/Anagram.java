package com.springerickhdz.javaClasses;

import java.util.Arrays;

public class Anagram {
    public static String anagram(String firstWord, String secondWord){
        char[] firstWordArray = firstWord.toCharArray();
        char[] secondWordArray = secondWord.toCharArray();
        Arrays.sort(firstWordArray);
        Arrays.sort(secondWordArray);
        if(Arrays.equals(firstWordArray, secondWordArray)){
            return "Anagram";
        }else {
            return "No Anagram";
        }
    }
}
