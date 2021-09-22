package com.globant.springdata.dto;

import com.globant.springdata.utils.Constants.ResponseConstants;

public class ResponseDTO<T> {

    private ResponseConstants responseConstants;
    private String message;
    private T contents;
    private String userAddedSuccessfully;
    private UserDTO addUser;

    public ResponseDTO(ResponseConstants responseConstants, String userAddedSuccessfully, UserDTO addUser) {
        this.responseConstants=responseConstants;
        this.userAddedSuccessfully = userAddedSuccessfully;
        this.addUser = addUser;
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

    public T getContents() {
        return contents;
    }

    public void setContents(T contents) {
        this.contents = contents;
    }

    public String getUserAddedSuccessfully() {
        return userAddedSuccessfully;
    }

    public void setUserAddedSuccessfully(String userAddedSuccessfully) {
        this.userAddedSuccessfully = userAddedSuccessfully;
    }

    public UserDTO getAddUser() {
        return addUser;
    }

    public void setAddUser(UserDTO addUser) {
        this.addUser = addUser;
    }
}
