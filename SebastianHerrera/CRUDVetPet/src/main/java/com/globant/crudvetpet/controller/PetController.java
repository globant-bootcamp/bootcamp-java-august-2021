package com.globant.crudvetpet.controller;

import com.globant.crudvetpet.model.GenericResponse;
import com.globant.crudvetpet.model.PetRequest;
import com.globant.crudvetpet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 10/09/21
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${request.api.pet}")
public class PetController {

    private final PetService petService;

    @GetMapping(value = "${api.url.pet.all-pets}")
    public ResponseEntity<GenericResponse> getAllPets() {
        return new ResponseEntity<>(petService.getAllPets(), HttpStatus.OK);
    }

    @GetMapping(value = "${api.url.pet.search-id-pet}")
    public ResponseEntity<GenericResponse> getPetById(@Valid @PathVariable("idPet") Long idPet) {
        return new ResponseEntity<>(petService.getPetById(idPet), HttpStatus.OK);
    }

    @PostMapping(value = "${api.url.pet.add-pet}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> createPet(@Valid @RequestBody PetRequest petRequest) {
        return new ResponseEntity<>(petService.savePet(petRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "${api.url.pet.update-pet}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse> updatePet(@Valid @PathVariable("idPet") Long idPet,
                                                     @RequestBody PetRequest petRequest) {
        return new ResponseEntity<>(petService.updatePet(petRequest, idPet), HttpStatus.OK);
    }

    @DeleteMapping(value = "${api.url.pet.delete-pet}")
    public ResponseEntity<GenericResponse> deletePet(@Valid @PathVariable("idPet") Long idPet) {
        return new ResponseEntity<>(petService.deletePet(idPet), HttpStatus.OK);
    }
}
