package com.vetpatitas.veterinary.mapper;


import com.vetpatitas.veterinary.dto.OwnerDTO;
import com.vetpatitas.veterinary.entity.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {
    public Owner ownerDTOToEntity(OwnerDTO ownerDTO) {
        Owner owner = new Owner();
        owner.setId(ownerDTO.getId());
        owner.setName(ownerDTO.getName());
        owner.setPhoneNumber(ownerDTO.getPhoneNumber());
        owner.setEmail(ownerDTO.getEmail());
        owner.setAnimalTreatmentList(ownerDTO.getAnimalTreatmentList());
        return owner;
    }

    public OwnerDTO ownerEntityToDTO(Owner owner) {
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(owner.getId());
        ownerDTO.setName(owner.getName());
        ownerDTO.setPhoneNumber(owner.getPhoneNumber());
        ownerDTO.setEmail(owner.getEmail());
        ownerDTO.setAnimalTreatmentList(owner.getAnimalTreatmentList());
        return ownerDTO;
    }
}
