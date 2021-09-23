package com.bootcamp.crud.service.impl;

import com.bootcamp.crud.dao.PetDAO;
import com.bootcamp.crud.dto.PetDTO;
import com.bootcamp.crud.entity.Pet;
import com.bootcamp.crud.mapper.PetMapper;
import com.bootcamp.crud.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetServiceImpl implements PetsService {

    @Autowired
    PetDAO petDAO;

    @Autowired
    PetMapper petMapper;

    @Autowired
    OwnerServiceImpl ownerService;

    @Override
    public PetDTO addPet(PetDTO petDTO) {
        return petMapper.petEntityToDTO(petDAO.save(petMapper.petDTOToEntity(petDTO)));
    }

    @Override
    public PetDTO updatePet(Long id, PetDTO petDTO) {
        return petMapper.petEntityToDTO(petDAO.save(setPetUpdate(findPetById(id),petDTO)));
    }

    @Override
    public PetDTO deletePet(Long id) {
        Pet pet = findPetById(id);
        pet.setIsActive(false);
        return petMapper.petEntityToDTO(petDAO.save(pet));
    }


    public Pet findPetById(Long id) {
        Optional<Pet> optionalPet = petDAO.findById(id);
        Pet pet = new Pet();

        if (optionalPet.isPresent()) {
            pet = optionalPet.get();
        }
        return pet;
    }

    public Pet setPetUpdate(Pet pet, PetDTO petDTO) {
        pet.setOwner(ownerService.findOwnerById(petDTO.getIdOwner()));
        pet.setName(pet.getName());
        pet.setSpecies(pet.getSpecies());
        pet.setAge(pet.getAge());
        pet.setIsSteril(pet.getIsSteril());
        pet.setIsActive(pet.getIsActive());
        return pet;
    }

}
