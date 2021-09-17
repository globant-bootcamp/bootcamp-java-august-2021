package com.vetpatitas.veterinary.dto;

import com.vetpatitas.veterinary.utils.Constants.ResponseConstants;


public class ResponseDTO<T> {
    private ResponseConstants responseConstants;
    private String message;
    private T content;

    public ResponseDTO(ResponseConstants responseConstants, String message, T content) {
        this.responseConstants = responseConstants;
        this.message = message;
        this.content = content;
    }

    public ResponseDTO() {

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
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
