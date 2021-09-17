package com.globant.springBootProject.dto;

public class StringReverseDTO {
    private String wordToEvaluate;
    private Boolean isPalindrome;

    public String getWordToEvaluate() {
        return wordToEvaluate;
    }

    public void setWordToEvaluate(String wordToEvaluate) {
        this.wordToEvaluate = wordToEvaluate;
    }

    public Boolean getPalindrome() {
        return isPalindrome;
    }

    public void setPalindrome(Boolean palindrome) {
        isPalindrome = palindrome;
    }
}
