package com.bootcamp.springdatacrud.mapper;

import com.bootcamp.springdatacrud.dto.PetDTO;
import com.bootcamp.springdatacrud.entity.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {
    public Pet petDTOToEntity(PetDTO petDTO){
        Pet pet = new Pet();
        pet.setName(petDTO.getName());
        pet.setAge(petDTO.getAge());
        pet.setBreed(petDTO.getBreed());
        pet.setWeight(petDTO.getWeight());
        return pet;
    }

    public PetDTO petEntityToDTO(Pet pet){
        PetDTO petDTO = new PetDTO();
        petDTO.setName(pet.getName());
        petDTO.setAge(pet.getAge());
        petDTO.setAge(pet.getAge());
        petDTO.setBreed(pet.getBreed());
        petDTO.setWeight(pet.getWeight());
        return petDTO;
    }
}
