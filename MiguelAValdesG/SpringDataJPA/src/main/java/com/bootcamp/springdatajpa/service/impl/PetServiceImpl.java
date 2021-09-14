package com.bootcamp.springdatajpa.service.impl;

import com.bootcamp.springdatajpa.dao.PetDAO;
import com.bootcamp.springdatajpa.dto.PetDTO;
import com.bootcamp.springdatajpa.entity.Pet;
import com.bootcamp.springdatajpa.exception.InvalidDataException;
import com.bootcamp.springdatajpa.mapper.PetMapper;
import com.bootcamp.springdatajpa.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bootcamp.springdatajpa.utils.Constants.PET_NOT_FOUND;

@Service
public class PetServiceImpl implements PetService {

  @Autowired
  private PetDAO petDAO;
  @Autowired
  private PetMapper petMapper;

  @Autowired
  private OwnerServiceImpl ownerServiceImpl;

  @Override
  public List<PetDTO> getAllPets() {
    return petDAO.findAllActive().parallelStream()
      .map(petDAO -> petMapper.petEntityToDTO(petDAO))
      .collect(Collectors.toList());
  }

  @Override
  public List<PetDTO> getAllOwnersPets(Long id) {
    return petDAO.findAllOwnersPets(id).parallelStream()
      .map(petDAO -> petMapper.petEntityToDTO(petDAO))
      .collect(Collectors.toList());
  }

  @Override
  public PetDTO addPet(PetDTO petDTO) {
    return petMapper.petEntityToDTO(petDAO.save(petMapper.petDTOToEntity(petDTO)));
  }

  @Override
  public PetDTO updatePet(Long id, PetDTO petDTO) {
    return petMapper.petEntityToDTO(petDAO.save(fillPet(findPet(id), petDTO)));
  }

  @Override
  public PetDTO deletePet(Long id) {
    Pet pet = findPet(id);
    pet.setActive(false);
    return petMapper.petEntityToDTO(petDAO.save(pet));
  }

  private Pet findPet(Long id) {
    Optional<Pet> petOptional = petDAO.findById(id);
    Pet pet;

    if (petOptional.isPresent()) {
      pet = petOptional.get();
    } else {
      throw new InvalidDataException(PET_NOT_FOUND);
    }
    return pet;
  }

  private Pet fillPet(Pet pet, PetDTO petDTO) {
    pet.setOwner(ownerServiceImpl.findOwner(petDTO.getIdOwner()));
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
