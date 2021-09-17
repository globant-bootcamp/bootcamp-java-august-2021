package com.globant.crudvetpet.exception;

import lombok.Data;

import java.util.List;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 11/09/21
 */
@Data
public class ErrorMessage {

    private String message;
    private List<String> details;

    public ErrorMessage(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }
}
