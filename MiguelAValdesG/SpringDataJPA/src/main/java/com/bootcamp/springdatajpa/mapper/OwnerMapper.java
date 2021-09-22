package com.bootcamp.springdatajpa.mapper;

import com.bootcamp.springdatajpa.dto.OwnerDTO;
import com.bootcamp.springdatajpa.entity.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

  public OwnerDTO ownerEntityToDTO(Owner owner) {
    OwnerDTO ownerDTO = new OwnerDTO();
    ownerDTO.setAddress(owner.getAddress());
    ownerDTO.setId(owner.getId());
    ownerDTO.setFirstName(owner.getFirstName());
    ownerDTO.setLastName(owner.getLastName());
    ownerDTO.setAge(owner.getAge());
    ownerDTO.setEmail(owner.getEmail());
    ownerDTO.setPhone(owner.getPhone());
    ownerDTO.setActive(owner.isActive());

    return ownerDTO;
  }

  public Owner ownerDTOToEntity(OwnerDTO ownerDTO) {
    Owner owner = new Owner();
    owner.setAddress(ownerDTO.getAddress());
    owner.setFirstName(ownerDTO.getFirstName());
    owner.setLastName(ownerDTO.getLastName());
    owner.setAge(ownerDTO.getAge());
    owner.setEmail(ownerDTO.getEmail());
    owner.setPhone(ownerDTO.getPhone());
    owner.setActive(ownerDTO.isActive());

    return owner;
  }

}
