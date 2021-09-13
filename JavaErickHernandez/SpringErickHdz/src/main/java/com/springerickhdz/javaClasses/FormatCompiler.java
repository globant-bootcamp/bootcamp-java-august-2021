package com.springerickhdz.javaClasses;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FormatCompiler {
    public static String compile(String word){
        try {
            Pattern.compile(word);
            return "Valid";
        } catch (PatternSyntaxException exception) {
            return "Invalid";
        }
    }
}
