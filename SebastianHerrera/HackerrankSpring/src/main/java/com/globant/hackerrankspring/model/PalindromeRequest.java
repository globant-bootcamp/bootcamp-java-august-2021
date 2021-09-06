package com.globant.hackerrankspring.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 05/09/21
 */
@Data
public class PalindromeRequest {

    @NotBlank(message = "Word is null")
    private String word;

}
