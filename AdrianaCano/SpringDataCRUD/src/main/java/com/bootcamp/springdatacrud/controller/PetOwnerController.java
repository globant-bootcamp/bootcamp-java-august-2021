package com.bootcamp.springdatacrud.controller;

import com.bootcamp.springdatacrud.dto.PetDTO;
import com.bootcamp.springdatacrud.dto.PetOwnerDTO;
import com.bootcamp.springdatacrud.dto.ResponseDTO;
import com.bootcamp.springdatacrud.service.PetOwnerService;
import com.bootcamp.springdatacrud.service.PetService;
import com.bootcamp.springdatacrud.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bootcamp.springdatacrud.utils.Constants.*;

@RestController
@RequestMapping("/petowner")
public class PetOwnerController {

    @Autowired
    PetOwnerService petOwnerService;

    @Autowired
    PetService petService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetOwnerDTO>> addPetOwner(@RequestBody PetOwnerDTO petOwnerDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, USER_ADDED_SUCCESSFULLY, petOwnerService.addPetOwner(petOwnerDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id_owner}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetOwnerDTO>> getPetOwnerById(@PathVariable Long id_owner, @RequestBody PetOwnerDTO petOwnerDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, USER_ADDED_SUCCESSFULLY, petOwnerService.getPetOwnerById(id_owner));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    @DeleteMapping("delete/{id_owner}")
    public String deletePetOwner(@PathVariable Long id_owner) {
        petOwnerService.deletePetOwner(id_owner);
        return USER_DELETED_SUCCESSFULLY;
    }

    @PutMapping(path = "update/{id_owner}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetOwnerDTO>> updatePetOwner(@PathVariable Long id_owner, @RequestBody PetOwnerDTO petOwnerDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, USER_UPDATED_SUCCESSFULLY, petOwnerService.updatePetOwner(id_owner, petOwnerDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetOwnerDTO>> showList() {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, USER_ADDED_SUCCESSFULLY, petOwnerService.showList());
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}

