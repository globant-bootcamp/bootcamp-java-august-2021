package com.globant.bootcamp.dto;

public class PalindromeDTO {
    private String string;
    private Boolean isPalindrome;

    public Boolean getPalindrome() {
        return isPalindrome;
    }

    public void setPalindrome(Boolean palindrome) {
        isPalindrome = palindrome;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
