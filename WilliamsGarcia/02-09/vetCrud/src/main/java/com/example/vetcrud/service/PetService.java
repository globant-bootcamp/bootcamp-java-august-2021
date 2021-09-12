package com.example.vetcrud.service;

import com.example.vetcrud.dto.PetDTO;

import java.util.List;

public interface PetService {
    List<PetDTO> getPetsByOwner(long id);

    List<PetDTO> getAllPets();

    PetDTO createPet(PetDTO petDTO);

    PetDTO updatePet(PetDTO petDTO, long id);

    PetDTO getPetById(long id);

    PetDTO deletePet(long id);
}
