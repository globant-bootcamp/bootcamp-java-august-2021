package com.example.globant.springdataproject.service;

import com.example.globant.springdataproject.dto.PetDTO;
import com.example.globant.springdataproject.exception.InvalidDataException;

import java.util.List;

public interface PetService {
    PetDTO addPet(PetDTO petDTO) throws InvalidDataException;
    List<PetDTO> getPets();
    PetDTO getPetByID(Long petId) throws InvalidDataException;
    void deletePetByID(Long petId) throws InvalidDataException;
    PetDTO editPetByID(Long petId, PetDTO petDTO) throws InvalidDataException;
}
