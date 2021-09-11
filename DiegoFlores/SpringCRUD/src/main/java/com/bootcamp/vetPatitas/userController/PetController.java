package com.bootcamp.vetPatitas.userController;

import static com.bootcamp.vetPatitas.utils.Constants.PET_ADDED_SUCCESSFULLY;
import static com.bootcamp.vetPatitas.utils.Constants.PET_FOUNDED_SUCCESSFULLY;
import static com.bootcamp.vetPatitas.utils.Constants.PET_UPDATED_SUCCESSFULLY;
import static com.bootcamp.vetPatitas.utils.Constants.PET_DELETED_SUCCESSFULLY;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.vetPatitas.dto.PetDTO;
import com.bootcamp.vetPatitas.dto.ResponseDTO;
import com.bootcamp.vetPatitas.service.PetService;
import com.bootcamp.vetPatitas.utils.Constants.ResponseConstants;

@RestController
@RequestMapping("pets")
public class PetController {

	@Autowired
	PetService petService;
	
	@PutMapping(path = "/savePet",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<PetDTO>> savePet(@RequestBody PetDTO pet) {		
		ResponseDTO responseDTO  = new ResponseDTO(ResponseConstants.SUCCESS, PET_ADDED_SUCCESSFULLY , petService.addPet(pet));
		
		return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(PET_ADDED_SUCCESSFULLY));
	}
	
	@GetMapping(path = "/getpet/{petId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<PetDTO>> getPet(@PathVariable Long petId) {		
		ResponseDTO responseDTO  = new ResponseDTO(ResponseConstants.SUCCESS, PET_FOUNDED_SUCCESSFULLY , petService.getPet(petId));
		
		return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(PET_FOUNDED_SUCCESSFULLY));
	}
	
	@PutMapping(path = "/updatePet",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<PetDTO>> updatePet(@RequestBody PetDTO pet) {		
		ResponseDTO responseDTO  = new ResponseDTO(ResponseConstants.SUCCESS, PET_UPDATED_SUCCESSFULLY , petService.updatePet(pet));
		
		return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(PET_UPDATED_SUCCESSFULLY));
	}
	
	@PutMapping(path = "/deletePet",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<PetDTO>> deletePet(@RequestBody PetDTO pet) {		
		ResponseDTO responseDTO  = new ResponseDTO(ResponseConstants.SUCCESS, PET_DELETED_SUCCESSFULLY , petService.deletePet(pet));
		
		return new ResponseEntity<>(responseDTO, HttpStatus.valueOf(PET_DELETED_SUCCESSFULLY));
	}
	
}
