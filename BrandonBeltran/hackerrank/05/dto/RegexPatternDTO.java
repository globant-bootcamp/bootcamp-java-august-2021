package com.globant.bootcamp.dto;

public class RegexPatternDTO {
    private String pattern;
    private Boolean isValid;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }
}
