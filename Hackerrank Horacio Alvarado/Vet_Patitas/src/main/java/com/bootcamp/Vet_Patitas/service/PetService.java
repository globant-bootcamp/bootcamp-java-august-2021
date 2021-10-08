package com.bootcamp.Vet_Patitas.service;

import com.bootcamp.Vet_Patitas.dto.PetDTO;
import com.bootcamp.Vet_Patitas.entity.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

    PetDTO isDischarged(PetDTO petDTO);
    public List<Pet> petList();
    public Optional<Pet> getPet(Long petId);
    public Optional<Pet> getByPetName(String petName);
    public void savePet(Pet pet);
    public void deletePet(Long petId);
    public boolean existsByPetId(Long petId);
    public boolean existsByPetName(String petName);
}
