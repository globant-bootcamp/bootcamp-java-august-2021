package com.globant.crudvetpet.service.impl;

import com.globant.crudvetpet.entity.Pet;
import com.globant.crudvetpet.mapper.PetMapper;
import com.globant.crudvetpet.model.GenericResponse;
import com.globant.crudvetpet.model.PetRequest;
import com.globant.crudvetpet.repository.PetRepository;
import com.globant.crudvetpet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 06/09/21
 */
@Service
@RequiredArgsConstructor
public class PetImpl implements PetService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;


    @Value("${successfull.messages.success}")
    private String success;

    @Override
    public GenericResponse getAllPets() {
        List<Pet> allPet = petRepository.findAll();
        return GenericResponse.builder().response(success).genericResponseObject(allPet).build();
    }

    @Override
    public GenericResponse getPetById(Long id) {
        Pet petEntity = petRepository.findById(id).orElse(null);
        PetRequest petRequest = petMapper.petEntityToModel(petEntity);
        return GenericResponse.builder().response(success).genericResponseObject(petRequest).build();
    }

    @Override
    public GenericResponse savePet(PetRequest petRequest) {
        petMapper.petEntityToModel(petRepository.save(petMapper.petModelToEntity(petRequest)));
        return GenericResponse.builder().response(success).genericResponseObject(petRequest).build();
    }

    @Override
    public GenericResponse updatePet(PetRequest petRequest, Long id) {
        Pet pet = petRepository.findById(id).get();
        pet.setPetName(petRequest.getPetName());
        pet.setPetAge(petRequest.getPetAge());
        pet.setPetType(petRequest.getPetType());
        pet.setIdOwner(petRequest.getIdOwner());
        petRepository.save(pet);
        return GenericResponse.builder().response(success).genericResponseObject(pet).build();
    }

    @Override
    public GenericResponse deletePet(Long id) {
        Pet pet = petRepository.findById(id).get();
        petRepository.delete(pet);
        return GenericResponse.builder().response(success).genericResponseObject(pet).build();
    }

    @Override
    public boolean existsByPetId(Long idPet) {
        return petRepository.existsById(idPet);
    }
}
