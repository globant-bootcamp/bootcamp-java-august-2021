package com.bootcamp.springdatajpa.mapper;

import com.bootcamp.springdatajpa.dto.PetDTO;
import com.bootcamp.springdatajpa.entity.Pet;
import com.bootcamp.springdatajpa.service.impl.OwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

  @Autowired
  private OwnerServiceImpl ownerServiceImpl;

  public PetDTO petEntityToDTO(Pet pet) {
    PetDTO petDTO = new PetDTO();
    petDTO.setId(pet.getId());
    petDTO.setIdOwner(pet.getOwner().getId());
    petDTO.setName(pet.getName());
    petDTO.setAge(pet.getAge());
    petDTO.setSpecies(pet.getSpecies());
    petDTO.setBreed(pet.getBreed());
    petDTO.setColor(pet.getColor());
    petDTO.setWeight(pet.getWeight());
    petDTO.setActive(pet.isActive());

    return petDTO;
  }

  public Pet petDTOToEntity(PetDTO petDTO) {
    Pet pet = new Pet();
    pet.setOwner(ownerServiceImpl.findOwnerById(petDTO.getIdOwner()));
    pet.setName(petDTO.getName());
    pet.setAge(petDTO.getAge());
    pet.setSpecies(petDTO.getSpecies());
    pet.setBreed(petDTO.getBreed());
    pet.setColor(petDTO.getColor());
    pet.setWeight(petDTO.getWeight());
    pet.setActive(petDTO.isActive());

    return pet;
  }

}
