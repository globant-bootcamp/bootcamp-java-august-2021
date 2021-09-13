package com.bootcamp.springdatacrud.mapper;

import com.bootcamp.springdatacrud.dto.PetOwnerDTO;
import com.bootcamp.springdatacrud.entity.PetOwner;
import org.springframework.stereotype.Component;

@Component
public class PetOwnerMapper {
    public PetOwner petOwnerDTOToEntity(PetOwnerDTO petOwnerDTO){
        PetOwner petOwner = new PetOwner();
        petOwner.setId(petOwnerDTO.getId());
        petOwner.setName(petOwnerDTO.getName());
        petOwner.setAddress(petOwnerDTO.getAddress());
        petOwner.setPhoneNumber(petOwnerDTO.getPhoneNumber());
        return petOwner;
    }

    public PetOwnerDTO petOwnerEntityToDTO(PetOwner petOwner){
        PetOwnerDTO petOwnerDTO = new PetOwnerDTO();
        petOwnerDTO.setId(petOwner.getId());
        petOwnerDTO.setName(petOwner.getName());
        petOwnerDTO.setAddress(petOwner.getAddress());
        petOwnerDTO.setPhoneNumber(petOwner.getPhoneNumber());
        return petOwnerDTO;
    }
}
