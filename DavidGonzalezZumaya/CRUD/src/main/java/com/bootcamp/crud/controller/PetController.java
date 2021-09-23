package com.bootcamp.crud.controller;

import com.bootcamp.crud.dto.PetDTO;
import com.bootcamp.crud.dto.ResponseDTO;
import com.bootcamp.crud.service.PetsService;
import com.bootcamp.crud.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("pets")
public class PetController {

    @Autowired
    PetsService petsService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> addPet(@RequestBody PetDTO petDTO){
        ResponseDTO<PetDTO> response = new ResponseDTO(Constants.ResponseConstants.SUCCESS, "Message", petsService.addPet(petDTO));
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> updatePet(@PathVariable Long id, @RequestBody PetDTO petDTO){
        ResponseDTO<PetDTO> response = new ResponseDTO(Constants.ResponseConstants.SUCCESS, "update", petsService.updatePet (id, petDTO));
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> deletePet(@PathVariable Long id){
        ResponseDTO<PetDTO> response = new ResponseDTO(Constants.ResponseConstants.SUCCESS, "delete", petsService.deletePet (id));
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
