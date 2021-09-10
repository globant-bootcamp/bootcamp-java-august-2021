package com.globant.springBootProject.dto;

public class PatternSyntaxCheckerDTO {
    private Integer numberOfTestCases;
    private String[] patterns;
    private String[] isValidPattern;

    public Integer getNumberOfTestCases() {
        return numberOfTestCases;
    }

    public void setNumberOfTestCases(Integer numberOfTestCases) {
        this.numberOfTestCases = numberOfTestCases;
    }

    public String[] getPatterns() {
        return patterns;
    }

    public void setPatterns(String[] patterns) {
        this.patterns = patterns;
    }

    public String[] getIsValidPattern() {
        return isValidPattern;
    }

    public void setIsValidPattern(String[] isValidPattern) {
        this.isValidPattern = isValidPattern;
    }
}
