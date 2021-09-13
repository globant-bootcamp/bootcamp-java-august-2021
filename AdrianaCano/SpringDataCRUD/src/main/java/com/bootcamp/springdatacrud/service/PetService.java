package com.bootcamp.springdatacrud.service;

import com.bootcamp.springdatacrud.dto.PetDTO;
import com.bootcamp.springdatacrud.dto.PetOwnerDTO;
import com.bootcamp.springdatacrud.entity.Pet;

import java.util.List;

public interface PetService {
    public List<Pet> showList();
    public PetDTO addPet(Long id_owner, PetDTO petDTO);
    public PetDTO getPetById(Long id_pet);
    public void deletePet(Long idPet);
    public PetDTO updatePet(Long id_pet, PetDTO petDTO);

}
