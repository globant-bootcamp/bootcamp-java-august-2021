package com.example.vetcrud.dto;

import lombok.Data;

import java.util.List;

@Data
public class OwnerDTO {

    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String contact;
    private List<PetDTO> petDTOList;
}
