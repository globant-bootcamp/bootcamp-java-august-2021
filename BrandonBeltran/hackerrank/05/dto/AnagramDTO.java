package com.globant.bootcamp.dto;

public class AnagramDTO {
    private String wordOne;
    private String wordTwo;
    private Boolean isAnagram;

    public String getWordOne() {
        return wordOne;
    }

    public void setWordOne(String wordOne) {
        this.wordOne = wordOne;
    }

    public String getWordTwo() {
        return wordTwo;
    }

    public void setWordTwo(String wordTwo) {
        this.wordTwo = wordTwo;
    }

    public Boolean getAnagram() {
        return isAnagram;
    }

    public void setAnagram(Boolean anagram) {
        isAnagram = anagram;
    }
}
