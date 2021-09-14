package com.oswaldo.vetpatitas.mapper;

import com.oswaldo.vetpatitas.dto.PetDTO;
import com.oswaldo.vetpatitas.entity.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    public Pet petDTOToEntity(PetDTO petDTO){
        Pet pet = new Pet();
        pet.setId(petDTO.getId());
        pet.setName(petDTO.getName());
        pet.setAge(petDTO.getAge());
        return pet;
    }

    public PetDTO petEntityToPetDTO(Pet pet){
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setName(pet.getName());
        petDTO.setAge(pet.getAge());
        return petDTO;
    }

}
