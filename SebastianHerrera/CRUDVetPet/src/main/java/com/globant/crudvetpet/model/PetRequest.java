package com.globant.crudvetpet.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 06/09/21
 */
@Data
public class PetRequest {

    private Long idPet;
    @NotBlank(message = "The Name is null")
    private String petName;
    @NotBlank(message = "The Type is null")
    private String petType;
    @NotBlank(message = "The Age is null")
    private String petAge;

    private Long idOwner;
}
