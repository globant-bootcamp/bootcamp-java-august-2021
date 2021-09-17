package com.globant.crudvetpet.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 11/09/21
 */
@Data
@Builder
public class GenericResponse<T> {

    private String response;
    private T genericResponseObject;
}
