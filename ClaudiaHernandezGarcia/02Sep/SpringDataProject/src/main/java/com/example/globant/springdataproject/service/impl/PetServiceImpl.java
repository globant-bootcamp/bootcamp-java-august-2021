package com.example.globant.springdataproject.service.impl;

import com.example.globant.springdataproject.dao.ClientDAO;
import com.example.globant.springdataproject.dao.PetDAO;
import com.example.globant.springdataproject.dto.PetDTO;
import com.example.globant.springdataproject.entity.Client;
import com.example.globant.springdataproject.entity.Pet;
import com.example.globant.springdataproject.exception.InvalidDataException;
import com.example.globant.springdataproject.mapper.PetMapper;
import com.example.globant.springdataproject.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.globant.springdataproject.utils.Constants.MISSING_PET_FIELDS;
import static com.example.globant.springdataproject.utils.Constants.INVALID_CLIENT_ID;
import static com.example.globant.springdataproject.utils.Constants.PET_ID_NOT_NULL;
import static com.example.globant.springdataproject.utils.Constants.INVALID_PET_ID;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    PetMapper petMapper;

    @Autowired
    PetDAO petDAO;

    @Autowired
    ClientDAO clientDAO;

    @Override
    public PetDTO addPet(PetDTO petDTO) {
        if (petDTO.getNameOfPet() == null || petDTO.getBreed() == null || petDTO.getClientId() == null || petDTO.getDateOfBirth() == null || petDTO.getSpecies() == null) {
            throw new InvalidDataException(MISSING_PET_FIELDS);
        }

        Client client = clientDAO.findClientById(petDTO.getClientId());
        System.out.println("client: " + client);
        if (client == null) {
            throw new InvalidDataException(INVALID_CLIENT_ID);
        }

        Pet pet = petMapper.petDTOToEntity(petDTO);
        pet.setClient(client);
        Pet petSaved = petDAO.save(pet);
        PetDTO newPetDTO = petMapper.petEntityToDTO(petSaved);
        newPetDTO.setClientId(client.getId());

        return newPetDTO;
    }

    @Override
    public List<PetDTO> getPets() {
        List<Pet> pets = petDAO.findAll();
        List<PetDTO> listClientsDTO = new ArrayList<>();

        for (Pet pet : pets) {
            listClientsDTO.add(petMapper.petEntityToDTO(pet));
        }

        return listClientsDTO;
    }

    @Override
    public PetDTO getPetByID(Long petId) {
        if (petId == null) {
            throw new InvalidDataException(PET_ID_NOT_NULL);
        }

        Pet pet = petDAO.findPetById(petId);
        if (pet == null) {
            throw new InvalidDataException(INVALID_PET_ID);
        }

        PetDTO petRetrieved = petMapper.petEntityToDTO(pet);
        return petRetrieved;
    }

    @Override
    public void deletePetByID(Long petId) {
        if (petId == null) {
            throw new InvalidDataException(PET_ID_NOT_NULL);
        }

        petDAO.deleteById(petId);
    }

    @Override
    public PetDTO editPetByID(Long petId, PetDTO petDTO) {
        if (petId == null) {
            throw new InvalidDataException(PET_ID_NOT_NULL);
        }

        Pet pet = petDAO.findPetById(petId);

        if (pet == null) {
            throw new InvalidDataException(INVALID_PET_ID);
        }

        if (petDTO.getNameOfPet() != null) {
            pet.setNameOfPet(petDTO.getNameOfPet());
        }

        Pet petSaved = petDAO.save(pet);
        PetDTO newPetDTO = petMapper.petEntityToDTO(petSaved);

        return newPetDTO;
    }
}
