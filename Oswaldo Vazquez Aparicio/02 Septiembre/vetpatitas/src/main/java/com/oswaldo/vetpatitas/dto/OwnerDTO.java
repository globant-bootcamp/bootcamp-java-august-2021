package com.oswaldo.vetpatitas.dto;

import lombok.Data;

import java.util.List;

@Data
public class OwnerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private List<PetDTO> petList;

}
