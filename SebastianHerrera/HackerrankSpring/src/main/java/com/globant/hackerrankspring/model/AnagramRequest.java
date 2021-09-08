package com.globant.hackerrankspring.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 05/09/21
 */
@Data
public class AnagramRequest {

    @NotBlank(message = "firstWord is null")
    private String firstWord;
    @NotBlank(message = "secondWord is null")
    private String secondWord;

}
