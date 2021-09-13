package com.oswaldo.springboot.dto;

public class AnagramDTO {

    private String inputStringOne;
    private String inputStringTwo;
    private String result;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
