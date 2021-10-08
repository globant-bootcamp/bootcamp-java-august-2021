package com.example.globant.springdataproject.dto;

import com.example.globant.springdataproject.utils.Constants;

public class ResponseDTO<T> {

    private Constants.ResponseConstants responseConstants;
    private String message;
    private T content;

    public ResponseDTO(Constants.ResponseConstants responseConstants, String message, T content) {
        this.responseConstants = responseConstants;
        this.message = message;
        this.content = content;
    }

    public Constants.ResponseConstants getResponseConstants() {
        return responseConstants;
    }

    public String getMessage() {
        return message;
    }

    public T getContent() {
        return content;
    }
}
