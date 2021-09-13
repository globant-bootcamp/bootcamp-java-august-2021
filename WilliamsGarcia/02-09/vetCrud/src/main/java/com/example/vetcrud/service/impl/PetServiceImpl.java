package com.example.vetcrud.service.impl;

import com.example.vetcrud.dao.OwnerDAO;
import com.example.vetcrud.dao.PetDAO;
import com.example.vetcrud.dto.PetDTO;
import com.example.vetcrud.entity.Pet;
import com.example.vetcrud.exception.EmptyListException;
import com.example.vetcrud.exception.NotFoundException;
import com.example.vetcrud.mapper.PetMapper;
import com.example.vetcrud.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.vetcrud.utils.Constants.*;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetDAO petDAO;

    @Autowired
    private OwnerDAO ownerDAO;

    @Autowired
    private PetMapper petMapper;

    @Override
    public List<PetDTO> getPetsByOwner(long id) {
        List<Pet> petList = petDAO.getPetsByOwner(ownerDAO.getById(id));

        if (!petList.isEmpty()) {
            return petMapper.petListToDTO(petList);
        } else {
            throw new EmptyListException(EMPTY_PET_LIST);
        }
    }

    @Override
    public List<PetDTO> getAllPets() {

        if (!petDAO.findAll().isEmpty()) {
            return petMapper.petListToDTO(petDAO.findAll());
        } else {
            throw new EmptyListException(EMPTY_PET_LIST);
        }
    }

    @Override
    public PetDTO createPet(PetDTO petDTO) {
        return petMapper.petToDTO(petDAO.save(petMapper.petDTOToPet(petDTO)));
    }

    @Override
    public PetDTO updatePet(PetDTO petDTO, long id) throws NotFoundException {

        if (petDAO.existsById(id)) {
            petDTO.setId(id);
            return petMapper.petToDTO(petDAO.save(petMapper.petDTOToPet(petDTO)));
        } else {
            throw new NotFoundException(NOT_FOUND_OWNER);
        }
    }

    @Override
    public PetDTO getPetById(long id) throws NotFoundException {

        if (petDAO.existsById(id)) {
            return petMapper.petToDTO(petDAO.getById(id));
        } else {
            throw new NotFoundException(NOT_FOUND_PET);
        }
    }

    @Override
    public void deletePet(long id) throws NotFoundException {

        if (petDAO.existsById(id)) {
            petDAO.delete(petDAO.getById(id));
        } else {
            throw new NotFoundException(NOT_FOUND_PET);
        }
    }
}
