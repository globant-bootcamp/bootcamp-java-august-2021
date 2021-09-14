package com.oswaldo.vetpatitas.controller;

import com.oswaldo.vetpatitas.dto.OwnerDTO;
import com.oswaldo.vetpatitas.dto.PetDTO;
import com.oswaldo.vetpatitas.dto.ResponseDTO;
import com.oswaldo.vetpatitas.service.OwnerService;
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

import static com.oswaldo.vetpatitas.util.Constants.OWNER_ADDED_SUCCESS;
import static com.oswaldo.vetpatitas.util.Constants.OWNER_ALL_RETRIEVED_SUCCESS;
import static com.oswaldo.vetpatitas.util.Constants.OWNER_DELETED_SUCCESS;
import static com.oswaldo.vetpatitas.util.Constants.OWNER_PET_ASSIGNED_SUCCESS;
import static com.oswaldo.vetpatitas.util.Constants.OWNER_RETRIEVED_SUCCESS;
import static com.oswaldo.vetpatitas.util.Constants.OWNER_UPDATED_SUCCESS;
import static com.oswaldo.vetpatitas.util.Constants.ResponseConstants;

@RestController
@RequestMapping("owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> getOwner(@PathVariable Long id){
        ResponseDTO<OwnerDTO> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, OWNER_RETRIEVED_SUCCESS, ownerService.getById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<List<OwnerDTO>>> getAllOwners(){
        ResponseDTO<List<OwnerDTO>> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, OWNER_ALL_RETRIEVED_SUCCESS, ownerService.getAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> createOwner(@RequestBody OwnerDTO ownerDTO){
        ResponseDTO<OwnerDTO> responseDTO = new ResponseDTO<>(Constants.ResponseConstants.SUCCESS, OWNER_ADDED_SUCCESS, ownerService.add(ownerDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping(path  = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> updateOwner(@PathVariable Long id, @RequestBody OwnerDTO ownerDTO){
        ResponseDTO<OwnerDTO> responseDTO = new ResponseDTO<>(ResponseConstants.SUCCESS, OWNER_UPDATED_SUCCESS, ownerService.updateOwnerData(id, ownerDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<Void>> deleteOwner(@PathVariable Long id){
        ownerService.delete(id);
        ResponseDTO<Void> responseDTO = new ResponseDTO<>(ResponseConstants.SUCCESS, OWNER_DELETED_SUCCESS, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.NO_CONTENT);
    }

    @PostMapping(path = "/{id}/pet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> assignPetToOwner(@PathVariable Long id, @RequestBody PetDTO petDTO){
        ResponseDTO<OwnerDTO> responseDTO = new ResponseDTO<>(ResponseConstants.SUCCESS, OWNER_PET_ASSIGNED_SUCCESS, ownerService.assignPetToOwner(id, petDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

}
