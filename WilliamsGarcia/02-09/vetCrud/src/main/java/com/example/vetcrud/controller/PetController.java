package com.example.vetcrud.controller;

import com.example.vetcrud.dto.PetDTO;
import com.example.vetcrud.dto.ResponseDTO;
import com.example.vetcrud.service.PetService;
import com.example.vetcrud.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.vetcrud.utils.Constants.*;

@RestController
@RequestMapping(value = "pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping()
    public ResponseEntity<ResponseDTO<PetDTO>> getAllPets() {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, PET_LIST, petService.getAllPets());
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<PetDTO>> getPetById(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, PET_SHOW, petService.getPetById(id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping("filter_by/owner/{id}")
    public ResponseEntity<ResponseDTO<PetDTO>> getPetsByOwner(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, PET_LIST_BY_USER, petService.getPetsByOwner(id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> registerPet(@RequestBody PetDTO petDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, PET_CREATED, petService.createPet(petDTO));
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<PetDTO>> updatePet(@RequestBody PetDTO petDTO, @PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_UPDATED, petService.updatePet(petDTO, id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<PetDTO>> deletePet(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_DELETED, petService.deletePet(id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}
