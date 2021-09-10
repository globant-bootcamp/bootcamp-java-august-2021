package com.globant.springBootProject.dto;

public class AnagramsDTO {
    private String line1;
    private String line2;
    private Boolean isAnagram;

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public Boolean getAnagram() {
        return isAnagram;
    }

    public void setAnagram(Boolean anagram) {
        isAnagram = anagram;
    }
}
