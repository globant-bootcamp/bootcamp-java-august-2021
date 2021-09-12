package com.bootcamp.springdatajpa.service;

import com.bootcamp.springdatajpa.dto.PetDTO;

import java.util.List;

public interface PetService {

  List<PetDTO> getAllPets();

  PetDTO addPet(PetDTO petDTO);

  PetDTO updatePet(Long id, PetDTO petDTO);

  PetDTO deletePet(Long id);

  List<PetDTO> getAllOwnersPets(Long id);

}
