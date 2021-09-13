package com.example.vetcrud.service;

import com.example.vetcrud.dto.PetDTO;
import com.example.vetcrud.exception.NotFoundException;

import java.util.List;

public interface PetService {
    List<PetDTO> getPetsByOwner(long id);

    List<PetDTO> getAllPets();

    PetDTO createPet(PetDTO petDTO);

    PetDTO updatePet(PetDTO petDTO, long id) throws NotFoundException;

    PetDTO getPetById(long id) throws NotFoundException;

    void deletePet(long id) throws NotFoundException;
}
