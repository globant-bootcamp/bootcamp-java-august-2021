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
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;

    @Autowired
    PetOwnerService petOwnerService;

    @PostMapping(path = "/add/{id_owner}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> addPet(@PathVariable Long id_owner, @RequestBody PetDTO petDTO) {
        PetOwnerDTO petOwnerDTO= petOwnerService.getPetOwnerById(id_owner);
        petOwnerDTO.addPet(petDTO);
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, USER_ADDED_SUCCESSFULLY, petOwnerService.addPetOwner(petOwnerDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id_pet}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> getPetById(@PathVariable Long id_pet, @RequestBody PetDTO petDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, USER_ADDED_SUCCESSFULLY, petService.getPetById(id_pet));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id_pet}")
    public String deletePetOwner(@PathVariable Long id_pet) {
        petService.deletePet(id_pet);
        return USER_DELETED_SUCCESSFULLY;
    }

    @PutMapping(path = "update/{id_pet}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> updatePet(@PathVariable Long id_pet, @RequestBody PetDTO petDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, USER_UPDATED_SUCCESSFULLY, petService.updatePet(id_pet, petDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> showList() {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, USER_ADDED_SUCCESSFULLY, petService.showList());
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
