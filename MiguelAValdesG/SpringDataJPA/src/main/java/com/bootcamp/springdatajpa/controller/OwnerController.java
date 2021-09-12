package com.bootcamp.springdatajpa.controller;

import com.bootcamp.springdatajpa.dto.OwnerDTO;
import com.bootcamp.springdatajpa.dto.ResponseDTO;
import com.bootcamp.springdatajpa.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.bootcamp.springdatajpa.utils.Constants.*;

@RestController
@RequestMapping("owners")
@Validated
public class OwnerController {

  @Autowired
  OwnerService ownerService;

  @GetMapping()
  public ResponseEntity<ResponseDTO<List<OwnerDTO>>> getAllOwners() {
    ResponseDTO<List<OwnerDTO>> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      OWNER_FOUND_SUCCESSFULLY,
      ownerService.getAllOwners()
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<ResponseDTO<OwnerDTO>> addOwner(@RequestBody @Valid OwnerDTO ownerDTO) {
    ResponseDTO<OwnerDTO> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      OWNER_ADDED_SUCCESSFULLY,
      ownerService.addOwner(ownerDTO)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<ResponseDTO<OwnerDTO>> updateOwner(@PathVariable Long id, @RequestBody @Valid OwnerDTO ownerDTO) {
    ResponseDTO<OwnerDTO> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      OWNER_UPDATED_SUCCESSFULLY,
      ownerService.updateOwner(id, ownerDTO)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ResponseDTO<OwnerDTO>> deleteOwner(@PathVariable Long id) {
    ResponseDTO<OwnerDTO> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      OWNER_DELETED_SUCCESSFULLY,
      ownerService.deleteOwner(id)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}
