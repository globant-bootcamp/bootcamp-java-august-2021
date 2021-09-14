package com.bootcamp.vetpatitas.userController;

import static com.bootcamp.vetpatitas.utils.Constants.PET_ADDED_SUCCESSFULLY;
import static com.bootcamp.vetpatitas.utils.Constants.PET_DELETED_SUCCESSFULLY;
import static com.bootcamp.vetpatitas.utils.Constants.PET_FOUNDED_SUCCESSFULLY;
import static com.bootcamp.vetpatitas.utils.Constants.PET_UPDATED_SUCCESSFULLY;

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

import com.bootcamp.vetpatitas.dto.PetDTO;
import com.bootcamp.vetpatitas.dto.ResponseDTO;
import com.bootcamp.vetpatitas.service.PetService;
import com.bootcamp.vetpatitas.utils.Constants.ResponseConstants;

@RestController
@RequestMapping("pets")
public class PetController {

	@Autowired
	PetService petService;
	
	@PutMapping(path = "/savePet",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<PetDTO>> savePet(@RequestBody PetDTO pet) {	
			
		ResponseDTO responseDTO  = new ResponseDTO(ResponseConstants.SUCCESS, PET_ADDED_SUCCESSFULLY , petService.addPet(pet));		
		return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/getpet/{petId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<PetDTO>> getPet(@PathVariable Long petId) {		
		ResponseDTO responseDTO  = new ResponseDTO(ResponseConstants.SUCCESS, PET_FOUNDED_SUCCESSFULLY , petService.getPet(petId));
		
		return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
	}
	
	@PutMapping(path = "/updatePet",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<PetDTO>> updatePet(@RequestBody PetDTO pet) {		
		ResponseDTO responseDTO  = new ResponseDTO(ResponseConstants.SUCCESS, PET_UPDATED_SUCCESSFULLY , petService.updatePet(pet));
		
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
	@PutMapping(path = "/deletePet",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<PetDTO>> deletePet(@RequestBody PetDTO pet) {		
		ResponseDTO responseDTO  = new ResponseDTO(ResponseConstants.SUCCESS, PET_DELETED_SUCCESSFULLY , petService.deletePet(pet));
		
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
}