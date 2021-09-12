package com.bootcamp.springdatajpa.service;

import com.bootcamp.springdatajpa.dto.PetDTO;

import java.util.List;

public interface PetService {

  List<PetDTO> getAllPets();

  PetDTO addPet(PetDTO petDTO) throws Exception;

  PetDTO updatePet(Long id, PetDTO petDTO) throws Exception;

  PetDTO deletePet(Long id) throws Exception;

  List<PetDTO> getAllOwnersPets(Long id);

}
