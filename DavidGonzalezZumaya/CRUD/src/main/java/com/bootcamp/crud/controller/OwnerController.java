package com.bootcamp.crud.controller;

import com.bootcamp.crud.dto.ResponseDTO;
import com.bootcamp.crud.dto.OwnerDTO;
import com.bootcamp.crud.service.OwnerService;
import com.bootcamp.crud.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> addOwner(@RequestBody OwnerDTO ownerDTO) {
        ResponseDTO<OwnerDTO> response = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, Constants.OWNER_CREATED_MESSAGE, ownerService.addOwner(ownerDTO));
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> updateOwner(@PathVariable Long id, @RequestBody OwnerDTO ownerDTO) {
        ResponseDTO<OwnerDTO> response = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, Constants.OWNER_UPDATED_MESSAGE, ownerService.updateOwner(ownerDTO, id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> deleteOwner(@PathVariable Long id) {
        ResponseDTO<OwnerDTO> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, Constants.OWNER_DELETED_MESSAGE, ownerService.deleteOwner(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
