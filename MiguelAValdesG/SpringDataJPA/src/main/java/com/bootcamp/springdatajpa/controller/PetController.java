package com.bootcamp.springdatajpa.controller;

import com.bootcamp.springdatajpa.dto.PetDTO;
import com.bootcamp.springdatajpa.dto.ResponseDTO;
import com.bootcamp.springdatajpa.service.PetService;
import com.bootcamp.springdatajpa.utils.Constants.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import java.util.List;

import static com.bootcamp.springdatajpa.utils.Constants.PET_ADDED_SUCCESSFULLY;
import static com.bootcamp.springdatajpa.utils.Constants.PET_FOUND_SUCCESSFULLY;
import static com.bootcamp.springdatajpa.utils.Constants.PET_UPDATED_SUCCESSFULLY;
import static com.bootcamp.springdatajpa.utils.Constants.PET_DELETED_SUCCESSFULLY;

@RestController
@RequestMapping("pets")
@Validated
public class PetController {

  @Autowired
  private PetService petService;

  @GetMapping()
  public ResponseEntity<ResponseDTO<List<PetDTO>>> getAllPets() {
    ResponseDTO<List<PetDTO>> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      PET_FOUND_SUCCESSFULLY,
      petService.getAllPets()
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @GetMapping("/by-owner/{id}")
  public ResponseEntity<ResponseDTO<List<PetDTO>>> getAllOwnersPets(@PathVariable Long id) {
    ResponseDTO<List<PetDTO>> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      PET_FOUND_SUCCESSFULLY,
      petService.getAllOwnersPets(id)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<ResponseDTO<PetDTO>> addPet(@RequestBody @Valid PetDTO petDTO) {
    ResponseDTO<PetDTO> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      PET_ADDED_SUCCESSFULLY,
      petService.addPet(petDTO)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<ResponseDTO<PetDTO>> updatePet(@PathVariable Long id, @RequestBody @Valid PetDTO petDTO) {
    ResponseDTO<PetDTO> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      PET_UPDATED_SUCCESSFULLY,
      petService.updatePet(id, petDTO)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ResponseDTO<PetDTO>> deletePet(@PathVariable Long id) {
    ResponseDTO<PetDTO> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      PET_DELETED_SUCCESSFULLY,
      petService.deletePet(id)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}
