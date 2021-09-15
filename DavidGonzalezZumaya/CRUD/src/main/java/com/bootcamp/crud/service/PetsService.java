package com.bootcamp.crud.service;

import com.bootcamp.crud.dto.PetDTO;

public interface PetsService {

    PetDTO addPet(PetDTO petDTO);

    PetDTO updatePet(Long id, PetDTO petDTO);

    PetDTO deletePet(Long id);

}
