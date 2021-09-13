package com.oswaldo.springboot.dto;

public class StringReverseDTO {

    private String inputString;
    private String isPalindrome;

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getPalindrome() {
        return isPalindrome;
    }

    public void setPalindrome(String palindrome) {
        isPalindrome = palindrome;
    }

}
