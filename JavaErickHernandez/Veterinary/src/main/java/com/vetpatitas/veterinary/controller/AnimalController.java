package com.vetpatitas.veterinary.controller;


import com.vetpatitas.veterinary.dto.AnimalDTO;
import com.vetpatitas.veterinary.dto.ResponseDTO;
import com.vetpatitas.veterinary.service.AnimalService;
import com.vetpatitas.veterinary.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.vetpatitas.veterinary.utils.Constants.ANIMAL_ADDED_SUCCESSFULLY;
import static com.vetpatitas.veterinary.utils.Constants.ANIMAL_DELETED_SUCCESSFULLY;
import static com.vetpatitas.veterinary.utils.Constants.ANIMAL_SELECTED_SUCCESSFULLY;
import static com.vetpatitas.veterinary.utils.Constants.ANIMAL_EDITED_SUCCESSFULLY;
@RestController
@RequestMapping("animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

   @PutMapping(path = "insert", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<ResponseDTO<AnimalDTO>> addAnimal(@RequestBody AnimalDTO animalDTO){
       ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS,ANIMAL_ADDED_SUCCESSFULLY, animalService.addAnimal(animalDTO));
       return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
   }
    @DeleteMapping (path = "delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AnimalDTO>> deleteAnimal(@RequestBody long id){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS,ANIMAL_DELETED_SUCCESSFULLY, animalService.deleteAnimal(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "select", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AnimalDTO>> selectAnimal(@RequestBody AnimalDTO animalDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS,ANIMAL_SELECTED_SUCCESSFULLY, animalService.selectAnimal(animalDTO.getId()));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PutMapping(path = "edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<AnimalDTO>> editAnimal(@RequestBody AnimalDTO animalDTO){
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS,ANIMAL_EDITED_SUCCESSFULLY, animalService.editAnimal(animalDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
