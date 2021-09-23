package com.bootcamp.crud.mapper;

import com.bootcamp.crud.dto.PetDTO;
import com.bootcamp.crud.entity.Pet;
import com.bootcamp.crud.service.impl.OwnerServiceImpl;
import com.bootcamp.crud.service.impl.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    @Autowired
    OwnerServiceImpl ownerService;

    public PetDTO petEntityToDTO(Pet pet){
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setIdOwner(pet.getOwner().getId());
        petDTO.setName(pet.getName());
        petDTO.setAge(pet.getAge());
        petDTO.setSpecies((pet.getSpecies()));
        petDTO.setSteril(pet.getIsSteril());
        petDTO.setActive(pet.getIsActive());
        return petDTO;
    }

    public Pet petDTOToEntity(PetDTO petDTO){
        Pet pet = new Pet();
        pet.setId(petDTO.getId());
        pet.setOwner(ownerService.findOwnerById(petDTO.getIdOwner()));
        pet.setName(petDTO.getName());
        pet.setAge(petDTO.getAge());
        pet.setSpecies((petDTO.getSpecies()));
        pet.setIsSteril(petDTO.isSteril());
        pet.setIsActive(petDTO.isActive());
        return pet;
    }
}
