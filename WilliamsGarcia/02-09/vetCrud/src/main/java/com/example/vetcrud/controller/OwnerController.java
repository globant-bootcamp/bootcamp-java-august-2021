package com.example.vetcrud.controller;

import com.example.vetcrud.dto.OwnerDTO;
import com.example.vetcrud.dto.ResponseDTO;
import com.example.vetcrud.service.OwnerService;
import com.example.vetcrud.utils.Constants.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.vetcrud.utils.Constants.*;

@RestController
@RequestMapping(value = "owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping()
    public ResponseEntity<ResponseDTO<OwnerDTO>> getAllOwners() {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, OWNER_LIST, ownerService.getAllOwners());
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<OwnerDTO>> getOwnerById(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, OWNER_SHOW, ownerService.getOwnerById(id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ResponseDTO<OwnerDTO>> registerOwner(@RequestBody OwnerDTO ownerDTO) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, OWNER_CREATED, ownerService.createOwner(ownerDTO));
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<OwnerDTO>> updateOwner(@RequestBody OwnerDTO ownerDTO, @PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_UPDATED, ownerService.updateOwner(ownerDTO, id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<OwnerDTO>> deleteOwner(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, OWNER_DELETED, ownerService.deleteOwner(id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}
