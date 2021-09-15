package com.example.globant.springdataproject.controller;

import com.example.globant.springdataproject.dto.PetDTO;
import com.example.globant.springdataproject.dto.ResponseDTO;
import com.example.globant.springdataproject.service.PetService;
import com.example.globant.springdataproject.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.globant.springdataproject.utils.Constants.*;

@RestController
@RequestMapping("pet")
public class PetController {

    @Autowired
    PetService petService;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> addPet(@RequestBody PetDTO petDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, PET_ADDED_SUCCESSFULLY, petService.addPet(petDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO<List<PetDTO>>> getPets() {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, "", petService.getPets());
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/search/{petId}")
    public ResponseEntity<ResponseDTO<PetDTO>> getPetByID(@PathVariable Long petId) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, "", petService.getPetByID(petId));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{petId}")
    public ResponseEntity<ResponseDTO<PetDTO>> deletePetByID(@PathVariable Long petId) {
        petService.deletePetByID(petId);
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, PET_DELETED_SUCCESSFULLY, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PatchMapping("/{petId}")
    public ResponseEntity<ResponseDTO<PetDTO>> editPetByID(@PathVariable Long petId, @RequestBody PetDTO petDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, PET_EDITED_SUCCESSFULLY, petService.editPetByID(petId, petDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
