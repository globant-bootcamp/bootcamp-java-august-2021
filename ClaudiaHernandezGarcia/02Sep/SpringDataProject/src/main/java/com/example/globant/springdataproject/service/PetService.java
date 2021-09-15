package com.example.globant.springdataproject.service;

import com.example.globant.springdataproject.dto.PetDTO;

import java.util.List;

public interface PetService {
    PetDTO addPet(PetDTO petDTO);
    List<PetDTO> getPets();
    PetDTO getPetByID(Long petId);
    void deletePetByID(Long petId);
    PetDTO editPetByID(Long petId, PetDTO petDTO);
}
