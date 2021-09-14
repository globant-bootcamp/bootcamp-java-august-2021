package com.example.vetcrud.dto;

import lombok.Data;

@Data
public class PetDTO {

    private Long id;
    private String name;
    private Integer age;
    private String specie;
    private String race;
    private Boolean vaccinated;
    private Integer ownerId;
}
