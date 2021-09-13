package com.oswaldo.vetpatitas.controller;

import com.oswaldo.vetpatitas.dto.PetDTO;
import com.oswaldo.vetpatitas.dto.ResponseDTO;
import com.oswaldo.vetpatitas.service.PetService;
import com.oswaldo.vetpatitas.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.oswaldo.vetpatitas.util.Constants.PET_RETRIEVED_SUCCESS;
import static com.oswaldo.vetpatitas.util.Constants.PET_ALL_RETRIEVED_SUCCESS;
import static com.oswaldo.vetpatitas.util.Constants.PET_ADDED_SUCCESS;
import static com.oswaldo.vetpatitas.util.Constants.PET_UPDATED_SUCCESS;
import static com.oswaldo.vetpatitas.util.Constants.PET_DELETED_SUCCESS;

@RestController
@RequestMapping("pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> getPet(@PathVariable Long id){
        ResponseDTO<PetDTO> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, PET_RETRIEVED_SUCCESS, petService.getById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<List<PetDTO>>> getAllPets(){
        ResponseDTO<List<PetDTO>> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, PET_ALL_RETRIEVED_SUCCESS, petService.getAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> createPet(@RequestBody PetDTO petDTO){
        ResponseDTO<PetDTO> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, PET_ADDED_SUCCESS, petService.add(petDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> updatePet(@PathVariable Long id, @RequestBody PetDTO petDTO){
        ResponseDTO<PetDTO> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, PET_UPDATED_SUCCESS, petService.update(id, petDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<Void>> deletePet(@PathVariable Long id){
        petService.delete(id);
        ResponseDTO<Void> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, PET_DELETED_SUCCESS, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.NO_CONTENT);
    }

}
