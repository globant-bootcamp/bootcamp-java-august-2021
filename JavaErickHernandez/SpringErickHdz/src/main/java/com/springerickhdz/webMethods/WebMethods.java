package com.springerickhdz.webMethods;

import com.springerickhdz.javaClasses.Anagram;
import com.springerickhdz.javaClasses.ReverseString;
import com.springerickhdz.javaClasses.FormatCompiler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebMethods {

    @GetMapping("reverse")
    public String reverseString(@RequestParam String word){
        String reversed = ReverseString.reverse(word);
        return reversed;
    }

    @GetMapping("anagram")
    public String anagram(@RequestParam String firstWord, @RequestParam String secondWord){
        String anagram = Anagram.anagram(firstWord, secondWord);
        return anagram;
    }

    @GetMapping("format")
    public String format(@RequestParam int cases,@RequestParam String word){
        String formatWord = "";
        for (int i = 0; i < cases; i++) {
            formatWord = FormatCompiler.compile(word);
        }
        return  formatWord;
    }
}
