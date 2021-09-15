package com.globant.vetpatitas.mapper;

import com.globant.vetpatitas.dto.PetDTO;
import com.globant.vetpatitas.entity.Pet;
import org.springframework.stereotype.Component;

@SuppressWarnings("DuplicatedCode")
@Component
public class PetMapper {
    public Pet petDTOToEntity(PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setId(petDTO.getId());
        pet.setName(petDTO.getName());
        pet.setOwnerFirstName(petDTO.getOwnerFirstName());
        pet.setOwnerLastName(petDTO.getOwnerLastName());
        pet.setOwnerPhoneNumber(petDTO.getOwnerPhoneNumber());
        pet.setAdmitted(petDTO.getAdmitted());
        pet.setActive(petDTO.getActive());
        return pet;
    }

    public PetDTO petEntityToDTO(Pet pet) {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setName(pet.getName());
        petDTO.setOwnerFirstName(pet.getOwnerFirstName());
        petDTO.setOwnerLastName(pet.getOwnerLastName());
        petDTO.setOwnerPhoneNumber(pet.getOwnerPhoneNumber());
        petDTO.setAdmitted(pet.getAdmitted());
        petDTO.setActive(pet.getActive());
        return petDTO;
    }
}
