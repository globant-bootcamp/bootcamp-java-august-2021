package com.globant.vetpatitas.service.impl;

import com.globant.vetpatitas.dao.PetDAO;
import com.globant.vetpatitas.dto.PetDTO;
import com.globant.vetpatitas.entity.Pet;
import com.globant.vetpatitas.exception.InvalidDeactivationRequest;
import com.globant.vetpatitas.exception.NonexistentPetException;
import com.globant.vetpatitas.mapper.PetMapper;
import com.globant.vetpatitas.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.globant.vetpatitas.utils.Constants.INVALID_DEACTIVATION_REQUEST;
import static com.globant.vetpatitas.utils.Constants.NONEXISTENT_PET;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetMapper petMapper;

    @Autowired
    private PetDAO petDAO;

    @Override
    public PetDTO getPet(Long id) {
        return petMapper.petEntityToDTO(findPet(id));
    }

    @Override
    public Pet findPet(Long id) {
        Pet pet;
        try {
            pet = petDAO.getPetById(id);
        } catch (NullPointerException npe) {
            throw new NonexistentPetException(NONEXISTENT_PET);
        }
        return pet;
    }

    @Override
    public PetDTO addPet(PetDTO petDTO) {
        return petMapper.petEntityToDTO(petDAO.save(petMapper.petDTOToEntity(petDTO)));
    }

    @Override
    public PetDTO updatePet(PetDTO petDTO, Long id) {
        Pet pet = petDAO.getPetById(id);

        if (pet.getAdmitted() && !petDTO.getActive())
            throw new InvalidDeactivationRequest(INVALID_DEACTIVATION_REQUEST);

        pet.setActive(petDTO.getActive());
        pet.setAdmitted(petDTO.getAdmitted());
        pet.setOwnerFirstName(petDTO.getOwnerFirstName());
        pet.setOwnerLastName(petDTO.getOwnerLastName());
        pet.setOwnerPhoneNumber(petDTO.getOwnerPhoneNumber());
        pet.setName(petDTO.getName());
        petDAO.save(pet);
        return petMapper.petEntityToDTO(pet);
    }

    @Override
    public PetDTO updatePet(Boolean isActive, Long id) {
        Pet pet = petDAO.getPetById(id);
        if (pet.getAdmitted() && !isActive) throw new InvalidDeactivationRequest(INVALID_DEACTIVATION_REQUEST);
        pet.setActive(isActive);
        petDAO.save(pet);
        return petMapper.petEntityToDTO(pet);
    }
}
