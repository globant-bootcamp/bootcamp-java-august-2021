package com.bootcamp.crud.mapper;

import com.bootcamp.crud.dto.OwnerDTO;
import com.bootcamp.crud.entity.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

    public Owner ownerDTOToEntity(OwnerDTO ownerDTO){
        Owner owner = new Owner();
        owner.setFirstName(ownerDTO.getFirstName());
        owner.setLastName(ownerDTO.getLastName());
        owner.setEmail(ownerDTO.getEmail());
        owner.setPhone(ownerDTO.getPhone());
        owner.setIsActive(ownerDTO.getIsActive());
        return owner;
    }

    public OwnerDTO ownerEntityToDTO(Owner owner){
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(owner.getId());
        ownerDTO.setFirstName(owner.getFirstName());
        ownerDTO.setLastName(owner.getLastName());
        ownerDTO.setEmail(owner.getEmail());
        ownerDTO.setPhone(owner.getPhone());
        ownerDTO.setIsActive(owner.getIsActive());
        return ownerDTO;
    }
}
