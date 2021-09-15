package com.globant.crudvetpet.mapper;

import com.globant.crudvetpet.entity.Pet;
import com.globant.crudvetpet.model.PetRequest;
import org.springframework.stereotype.Component;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 06/09/21
 */
@Component
public class PetMapper {

    public Pet petModelToEntity(PetRequest petRequest) {
        Pet pet = new Pet();
        pet.setPetName(petRequest.getPetName());
        pet.setPetType(petRequest.getPetType());
        pet.setPetAge(petRequest.getPetAge());
        pet.setIdOwner(petRequest.getIdOwner());
        return pet;
    }

    public PetRequest petEntityToModel(Pet petEntity) {
        PetRequest petRequest = new PetRequest();
        petRequest.setIdPet(petEntity.getId());
        petRequest.setPetName(petEntity.getPetName());
        petRequest.setPetType(petEntity.getPetType());
        petRequest.setPetAge(petEntity.getPetAge());
        petRequest.setIdOwner(petEntity.getIdOwner());
        return petRequest;
    }

}
