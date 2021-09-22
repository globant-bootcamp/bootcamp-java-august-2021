package com.vetpatitas.veterinary.controller;


import com.vetpatitas.veterinary.dto.OwnerDTO;
import com.vetpatitas.veterinary.dto.ResponseDTO;
import com.vetpatitas.veterinary.service.OwnerService;
import com.vetpatitas.veterinary.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.vetpatitas.veterinary.utils.Constants.OWNER_ADDED_SUCCESSFULLY;
import static com.vetpatitas.veterinary.utils.Constants.OWNER_DELETED_SUCCESSFULLY;
import static com.vetpatitas.veterinary.utils.Constants.OWNER_SELECTED_SUCCESSFULLY;
import static com.vetpatitas.veterinary.utils.Constants.OWNER_EDITED_SUCCESSFULLY;

@RestController
@RequestMapping("owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PutMapping(path = "insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> addOwner(@RequestBody OwnerDTO ownerDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS,OWNER_ADDED_SUCCESSFULLY, ownerService.addOwner(ownerDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @PutMapping(path = "delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> deleteOwner(@RequestBody OwnerDTO ownerDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS,OWNER_DELETED_SUCCESSFULLY, ownerService.deleteOwner(ownerDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(path = "select", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> selectOwner(@RequestBody OwnerDTO ownerDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS,OWNER_SELECTED_SUCCESSFULLY, ownerService.selectOwner(ownerDTO.getId()));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PutMapping(path = "edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<OwnerDTO>> editOwner(@RequestBody OwnerDTO ownerDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS,OWNER_EDITED_SUCCESSFULLY, ownerService.editOwner(ownerDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
