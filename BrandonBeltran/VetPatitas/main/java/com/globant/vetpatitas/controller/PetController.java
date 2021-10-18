package com.globant.vetpatitas.controller;

import com.globant.vetpatitas.dto.PetDTO;
import com.globant.vetpatitas.dto.ResponseDTO;
import com.globant.vetpatitas.service.PetService;
import com.globant.vetpatitas.utils.Constants.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.globant.vetpatitas.utils.Constants.PET_ADDED_SUCCESSFULLY;
import static com.globant.vetpatitas.utils.Constants.PET_CONSULTED_SUCCESSFULLY;
import static com.globant.vetpatitas.utils.Constants.PET_UPDATED_SUCCESSFULLY;

@RestController
@RequestMapping("vetpatitas")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping(path = "/addPet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<PetDTO>> addPet(@RequestBody PetDTO petDTO) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_ADDED_SUCCESSFULLY, petService.addPet(petDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping(path = "/pet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseDTO<PetDTO>> getPet(@PathVariable Long id) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_CONSULTED_SUCCESSFULLY, petService.getPet(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(path = "/pet/{id}/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseDTO<PetDTO>> updatePet(@PathVariable Long id, @RequestBody PetDTO petDTO) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_UPDATED_SUCCESSFULLY, petService.updatePet(petDTO, id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PatchMapping(path = "/pet/{id}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseDTO<PetDTO>> activatePet(@PathVariable Long id) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_UPDATED_SUCCESSFULLY, petService.updatePet(Boolean.TRUE, id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PatchMapping(path = "/pet/{id}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ResponseDTO<PetDTO>> deactivatePet(@PathVariable Long id) {
        ResponseDTO responseDTO = new ResponseDTO(ResponseConstants.SUCCESS, PET_UPDATED_SUCCESSFULLY, petService.updatePet(Boolean.FALSE, id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
