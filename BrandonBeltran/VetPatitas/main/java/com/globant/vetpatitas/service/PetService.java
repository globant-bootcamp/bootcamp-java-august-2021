package com.globant.vetpatitas.service;

import com.globant.vetpatitas.dto.PetDTO;
import com.globant.vetpatitas.entity.Pet;

public interface PetService {
    Pet findPet(Long id);
    PetDTO getPet(Long id);
    PetDTO addPet(PetDTO petDTO);
    PetDTO updatePet(PetDTO petDTO, Long id);
    PetDTO updatePet(Boolean isActive, Long id);
}
