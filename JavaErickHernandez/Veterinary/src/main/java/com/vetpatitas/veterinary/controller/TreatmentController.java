package com.vetpatitas.veterinary.controller;

import com.vetpatitas.veterinary.dto.AnimalTreatmentDTO;
import com.vetpatitas.veterinary.dto.ResponseDTO;
import com.vetpatitas.veterinary.service.TreatmentService;
import com.vetpatitas.veterinary.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.vetpatitas.veterinary.utils.Constants.TREATMENT_ADDED_SUCCESSFULLY;
import static com.vetpatitas.veterinary.utils.Constants.TREATMENT_DELETED_SUCCESSFULLY;
import static com.vetpatitas.veterinary.utils.Constants.TREATMENT_SELECTED_SUCCESSFULLY;
import static com.vetpatitas.veterinary.utils.Constants.TREATMENT_EDITED_SUCCESSFULLY;

@RestController
@RequestMapping("treatment")
public class TreatmentController {
    @Autowired
    private TreatmentService treatmentService;

    @PutMapping(path = "insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AnimalTreatmentDTO>> addTreatment(@RequestBody AnimalTreatmentDTO animalTreatmentDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS,TREATMENT_ADDED_SUCCESSFULLY, treatmentService.addTreatment(animalTreatmentDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @PutMapping(path = "delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AnimalTreatmentDTO>> deleteTreatment(@RequestBody AnimalTreatmentDTO animalTreatmentDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS,TREATMENT_DELETED_SUCCESSFULLY, treatmentService.deleteTreatment(animalTreatmentDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping(path = "select", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AnimalTreatmentDTO>> selectTreatment(@RequestBody AnimalTreatmentDTO animalTreatmentDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS,TREATMENT_SELECTED_SUCCESSFULLY, treatmentService.selectTreatment(animalTreatmentDTO.getId()));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PutMapping(path = "edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AnimalTreatmentDTO>> editTreatment(@RequestBody AnimalTreatmentDTO animalTreatmentDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS,TREATMENT_EDITED_SUCCESSFULLY, treatmentService.editTreatment(animalTreatmentDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
