package com.example.vetcrud.controller;

import com.example.vetcrud.dto.OwnerDTO;
import com.example.vetcrud.dto.ResponseDTO;
import com.example.vetcrud.exception.NotFoundException;
import com.example.vetcrud.service.OwnerService;
import com.example.vetcrud.utils.Constants.ResponseConstants;
import com.sun.media.sound.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.vetcrud.utils.Constants.OWNER_UPDATED;
import static com.example.vetcrud.utils.Constants.OWNER_LIST;
import static com.example.vetcrud.utils.Constants.OWNER_SHOW;
import static com.example.vetcrud.utils.Constants.OWNER_CREATED;
import static com.example.vetcrud.utils.Constants.OWNER_DELETED;

@RestController
@RequestMapping(value = "owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> getAllOwners() {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, OWNER_LIST, ownerService.getAllOwners());
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> getOwnerById(@PathVariable long id) throws NotFoundException {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, OWNER_SHOW, ownerService.getOwnerById(id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> registerOwner(@RequestBody OwnerDTO ownerDTO) throws InvalidDataException {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, OWNER_CREATED, ownerService.createOwner(ownerDTO));
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> updateOwner(@RequestBody OwnerDTO ownerDTO, @PathVariable long id) throws NotFoundException {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, OWNER_UPDATED, ownerService.updateOwner(ownerDTO, id));
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> deleteOwner(@PathVariable long id) throws NotFoundException {
        ownerService.deleteOwner(id);
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, OWNER_DELETED);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}
