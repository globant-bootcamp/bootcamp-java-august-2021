package com.globant.springBootProject.dto;

import com.globant.springBootProject.utils.Constants.ResponseConstants;

public class ResponseDTO<T> {

    private ResponseConstants responseConstants;
    private T content;

    public ResponseDTO(ResponseConstants responseConstants, T content) {
        this.responseConstants = responseConstants;
        this.content = content;
    }

    public ResponseConstants getResponseConstants() {
        return responseConstants;
    }

    public void setResponseConstants(ResponseConstants responseConstants) {
        this.responseConstants = responseConstants;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
