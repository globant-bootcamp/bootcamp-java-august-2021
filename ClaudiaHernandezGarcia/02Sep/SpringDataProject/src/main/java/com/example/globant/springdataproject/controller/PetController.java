package com.example.globant.springdataproject.controller;

import com.example.globant.springdataproject.dto.PetDTO;
import com.example.globant.springdataproject.dto.ResponseDTO;
import com.example.globant.springdataproject.exception.InvalidDataException;
import com.example.globant.springdataproject.service.PetService;
import com.example.globant.springdataproject.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static com.example.globant.springdataproject.utils.Constants.PET_ADDED_SUCCESSFULLY;
import static com.example.globant.springdataproject.utils.Constants.PET_DELETED_SUCCESSFULLY;
import static com.example.globant.springdataproject.utils.Constants.PET_EDITED_SUCCESSFULLY;


@RestController
@RequestMapping("pet")
public class PetController {

    @Autowired
    private PetService petService;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> addPet(@RequestBody PetDTO petDTO) throws InvalidDataException {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, PET_ADDED_SUCCESSFULLY, petService.addPet(petDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO<List<PetDTO>>> getPets() {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, "", petService.getPets());
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/get/{petId}")
    public ResponseEntity<ResponseDTO<PetDTO>> getPetByID(@PathVariable Long petId) throws InvalidDataException {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, "", petService.getPetByID(petId));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{petId}")
    public ResponseEntity<ResponseDTO<PetDTO>> deletePetByID(@PathVariable Long petId) throws InvalidDataException {
        petService.deletePetByID(petId);
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, PET_DELETED_SUCCESSFULLY, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PatchMapping("/{petId}")
    public ResponseEntity<ResponseDTO<PetDTO>> editPetByID(@PathVariable Long petId, @RequestBody PetDTO petDTO) throws InvalidDataException {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, PET_EDITED_SUCCESSFULLY, petService.editPetByID(petId, petDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
