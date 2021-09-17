package com.globant.crudvetpet.service;

import com.globant.crudvetpet.model.GenericResponse;
import com.globant.crudvetpet.model.PetRequest;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 06/09/21
 */
public interface PetService {

    GenericResponse getAllPets();

    GenericResponse getPetById(Long idPet);

    GenericResponse savePet(PetRequest petRequest);

    GenericResponse updatePet(PetRequest petRequest, Long idPet);

    GenericResponse deletePet(Long idPet);

    boolean existsByPetId(Long idPet);
}
