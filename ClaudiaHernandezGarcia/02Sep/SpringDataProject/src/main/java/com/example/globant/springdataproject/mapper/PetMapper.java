package com.example.globant.springdataproject.mapper;

import com.example.globant.springdataproject.dto.PetDTO;
import com.example.globant.springdataproject.entity.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    public Pet petDTOToEntity(PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setNameOfPet(petDTO.getNameOfPet());
        pet.setSpecies(petDTO.getSpecies());
        pet.setBreed(petDTO.getBreed());
        pet.setDateOfBirth(petDTO.getDateOfBirth());

        return pet;
    }

    public PetDTO petEntityToDTO(Pet pet) {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setNameOfPet(pet.getNameOfPet());
        petDTO.setSpecies(pet.getSpecies());
        petDTO.setBreed(pet.getBreed());
        petDTO.setDateOfBirth(pet.getDateOfBirth());

        return petDTO;
    }
}
