package com.example.vetcrud.controller;

import com.example.vetcrud.dto.PetDTO;
import com.example.vetcrud.dto.ResponseDTO;
import com.example.vetcrud.exception.NotFoundException;
import com.example.vetcrud.service.PetService;
import com.example.vetcrud.utils.Constants.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import static com.example.vetcrud.utils.Constants.PET_CREATED;
import static com.example.vetcrud.utils.Constants.PET_LIST;
import static com.example.vetcrud.utils.Constants.PET_SHOW;
import static com.example.vetcrud.utils.Constants.PET_LIST_BY_USER;
import static com.example.vetcrud.utils.Constants.PET_UPDATED;
import static com.example.vetcrud.utils.Constants.PET_DELETED;

@RestController
@RequestMapping(value = "pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> getAllPets() {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_LIST, petService.getAllPets());
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> getPetById(@PathVariable long id) throws NotFoundException {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_SHOW, petService.getPetById(id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "filter_by/owner/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> getPetsByOwner(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_LIST_BY_USER, petService.getPetsByOwner(id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> registerPet(@RequestBody PetDTO petDTO) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_CREATED, petService.createPet(petDTO));
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> updatePet(@RequestBody PetDTO petDTO, @PathVariable long id) throws NotFoundException {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_UPDATED, petService.updatePet(petDTO, id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> deletePet(@PathVariable long id) throws NotFoundException {
        petService.deletePet(id);
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_DELETED);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}
