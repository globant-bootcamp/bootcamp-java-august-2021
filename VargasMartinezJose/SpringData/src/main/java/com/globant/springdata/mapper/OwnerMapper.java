package com.globant.springdata.mapper;

import com.globant.springdata.dto.OwnerDTO;
import com.globant.springdata.entity.Owner;

public class OwnerMapper {

    public Owner userDTOToEntity(OwnerDTO ownerDTO){
        Owner owner = new Owner();
        owner.setName(ownerDTO.getName());
        owner.setPhone(ownerDTO.getPhone());

        return owner;
}
    public OwnerDTO userEntityToDTO(Owner owner){
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(owner.getId());
        ownerDTO.setName(owner.getName());
        ownerDTO.setPhone(owner.getPhone());

        return ownerDTO;
    }
}
