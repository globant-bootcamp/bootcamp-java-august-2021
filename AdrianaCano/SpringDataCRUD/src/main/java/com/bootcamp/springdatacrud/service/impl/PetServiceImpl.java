package com.bootcamp.springdatacrud.service.impl;

import com.bootcamp.springdatacrud.dao.PetDAO;
import com.bootcamp.springdatacrud.dto.PetDTO;
import com.bootcamp.springdatacrud.entity.Pet;
import com.bootcamp.springdatacrud.exception.NotFoundException;
import com.bootcamp.springdatacrud.mapper.PetMapper;
import com.bootcamp.springdatacrud.service.PetOwnerService;
import com.bootcamp.springdatacrud.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bootcamp.springdatacrud.utils.Constants.USER_DOES_NOT_EXIST;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetMapper petMapper;

    @Autowired
    PetDAO petDAO;

    @Autowired
    PetOwnerService petOwnerService;

    @Override
    public List<Pet> showList() {
        return petDAO.findAll();
    }

    @Override
    public PetDTO addPet(Long id_owner, PetDTO petDTO) {
        petOwnerService.getPetOwnerById(id_owner);
        return petMapper.petEntityToDTO(petDAO.save(petMapper.petDTOToEntity(petDTO)));
    }

    @Override
    public PetDTO getPetById(Long id_pet) {
        Pet pet = petDAO.findById(id_pet).orElse(null);

        if (pet == null) {
            throw new NotFoundException(USER_DOES_NOT_EXIST);
        }
        PetDTO petDTO = petMapper.petEntityToDTO(pet);
        return petDTO;
    }

    @Override
    public void deletePet(Long id_pet) {
        getPetById(id_pet);
        petDAO.deleteById(id_pet);
    }

    @Override
    public PetDTO updatePet(Long id_pet, PetDTO petDTO) {
        getPetById(id_pet);
        return petMapper.petEntityToDTO(petDAO.save(petMapper.petDTOToEntity(petDTO)));
    }
}
