package com.globant.crudvetpet.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 09/09/21
 */
@Data
public class ClientRequest {

    private Long idClient;

    @NotBlank(message = "The name is null")
    private String nameClient;

    @NotBlank(message = "The phone is null")
    private String phoneClient;

}
