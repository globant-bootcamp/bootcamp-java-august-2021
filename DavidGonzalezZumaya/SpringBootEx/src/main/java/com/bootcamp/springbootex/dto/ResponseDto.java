package com.bootcamp.springbootex.dto;

import com.bootcamp.springbootex.utils.Constants.ResponseConstants;

public class ResponseDto<T> {

    private ResponseConstants responseConstants;
    private String message;
    private T result;

    public ResponseDto(ResponseConstants responseConstants, String message, T content) {
        this.responseConstants = responseConstants;
        this.message = message;
        this.result = content;
    }

    public ResponseConstants getResponseConstants() {
        return responseConstants;
    }

    public void setResponseConstants(ResponseConstants responseConstants) {
        this.responseConstants = responseConstants;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return result;
    }

    public void setContent(T result) {
        this.result = result;
    }
}
