package com.globant.hackerrank.dto;

public class AnagramDTO {

    private String inputStringOne;
    private String inputStringTwo;
    private Boolean isAnagram;

    public String getInputStringOne() {
        return inputStringOne;
    }

    public void setInputStringOne(String inputStringOne) {
        this.inputStringOne = inputStringOne;
    }

    public String getInputStringTwo() {
        return inputStringTwo;
    }

    public void setInputStringTwo(String inputStringTwo) {
        this.inputStringTwo = inputStringTwo;
    }

    public Boolean getAnagram() {
        return isAnagram;
    }

    public void setAnagram(Boolean anagram) {
        isAnagram = anagram;
    }
}
