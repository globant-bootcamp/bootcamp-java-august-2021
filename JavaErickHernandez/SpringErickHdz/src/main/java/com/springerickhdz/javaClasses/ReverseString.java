package com.springerickhdz.javaClasses;

public class ReverseString {
    public static String reverse(String word){
        String reversed = new StringBuilder(word).reverse().toString();
        if(word.equals(reversed)){
            return "Yes";
        }else{
            return "No";
        }
    }
}
