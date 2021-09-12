package com.globant.vet.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.vet.controller.VetController;
import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.PetInfoWithOwner;
import com.globant.vet.dto.ResponseDTO;
import com.globant.vet.dto.ResponseDTO.ResponseDTOBuilder;
import com.globant.vet.service.PetService;
import com.globant.vet.util.constants.Constants;
import com.globant.vet.util.constants.ResponseConstants;

@RestController
@RequestMapping("/pets")
public class VetControllerImpl implements VetController {
	
	@Autowired
	private PetService petService; 

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseDTO<PetInfoWithOwner>> getInfoPet(@PathVariable(name = "id") int petId) {
		ResponseDTOBuilder<PetInfoWithOwner> builder = ResponseDTO.builder();
		ResponseDTO<PetInfoWithOwner> response = builder
			.content(petService.getPetById(petId))
			.message(String.format(Constants.PET_WITH_ID, petId))
			.status(ResponseConstants.SUCCESS)
			.build();
		return ResponseEntity.ok().body(response);
		
	}

	@Override
	@GetMapping()
	public ResponseEntity<ResponseDTO<List<PetDTO<PetInfoWithOwner>>>> getPets() {
		ResponseDTOBuilder<List<PetDTO<PetInfoWithOwner>>> builder = ResponseDTO.builder();
		ResponseDTO<List<PetDTO<PetInfoWithOwner>>> response = builder
			.content(petService.getAllPets())
			.message(ResponseConstants.SUCCESS.getDescription())
			.status(ResponseConstants.SUCCESS)
			.build();
		return ResponseEntity.ok().body(response);
	}

	@Override
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<PetInfo>> updatePet(int id, PetInfo newPet) {
		return null;
	}

	@Override
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<PetInfo>> createPet(PetInfo newPet) {
		return null;
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseDTO<String>> deletePet(@PathVariable(name = "id") int id) {
		return null;
	}

}
