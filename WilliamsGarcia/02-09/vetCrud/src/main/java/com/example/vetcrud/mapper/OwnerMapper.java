package com.example.vetcrud.mapper;

import com.example.vetcrud.dto.OwnerDTO;
import com.example.vetcrud.entity.Owner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OwnerMapper {

    public OwnerDTO ownerToDTO(Owner owner) {
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(owner.getId());
        ownerDTO.setName(owner.getName());
        ownerDTO.setLastName(owner.getLastName());
        ownerDTO.setAddress(owner.getAddress());
        ownerDTO.setContact(owner.getContact());

        return ownerDTO;
    }

    public Owner ownerDTOToOwner(OwnerDTO ownerDTO) {
        Owner owner = new Owner();
        owner.setId(ownerDTO.getId());
        owner.setName(ownerDTO.getName());
        owner.setLastName(ownerDTO.getLastName());
        owner.setAddress(ownerDTO.getAddress());
        owner.setContact(ownerDTO.getContact());

        return owner;
    }

    public List<OwnerDTO> ownerListToDTO(List<Owner> ownerList) {
        List<OwnerDTO> ownerDTOList = new ArrayList<>();
        for (Owner owner : ownerList) {
            ownerDTOList.add(this.ownerToDTO(owner));
        }

        return ownerDTOList;
    }
}
