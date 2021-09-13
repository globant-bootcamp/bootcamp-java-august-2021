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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.vet.controller.VetController;
import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.PetInfoWithCompleteOwner;
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
	public ResponseEntity<ResponseDTO<PetInfoWithCompleteOwner>> getInfoPet(@PathVariable(name = "id") int petId) {
		ResponseDTOBuilder<PetInfoWithCompleteOwner> builder = ResponseDTO.builder();
		ResponseDTO<PetInfoWithCompleteOwner> response = builder
			.content(petService.getPetById(petId))
			.message(String.format(Constants.PET_WITH_ID, petId))
			.status(ResponseConstants.SUCCESS)
			.build();
		return ResponseEntity.ok().body(response);
		
	}

	@Override
	@GetMapping()
	public ResponseEntity<ResponseDTO<List<PetDTO<PetInfoWithCompleteOwner>>>> getPets() {
		ResponseDTOBuilder<List<PetDTO<PetInfoWithCompleteOwner>>> builder = ResponseDTO.builder();
		ResponseDTO<List<PetDTO<PetInfoWithCompleteOwner>>> response = builder
			.content(petService.getAllPets())
			.message(ResponseConstants.SUCCESS.getDescription())
			.status(ResponseConstants.SUCCESS)
			.build();
		return ResponseEntity.ok().body(response);
	}

	@Override
	@PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<PetInfo>> updatePet(@PathVariable(name = "id") int id,@RequestBody PetInfo newPet) {
		PetInfo updatePet = petService.updatePet(newPet, id);
		ResponseDTOBuilder<PetInfo> builder = ResponseDTO.builder();
		ResponseDTO<PetInfo> response = builder
				.content(petService.updatePet(updatePet, id))
				.message(Constants.PET_UPDATE)
				.status(ResponseConstants.SUCCESS)
				.build();
		return ResponseEntity.ok().body(response);
	}

	@Override
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<PetInfoWithCompleteOwner>> createPet(@RequestBody PetInfoWithCompleteOwner newPet) {
		PetDTO<PetInfoWithCompleteOwner> petDtoCreated = petService.createPet(newPet);
		ResponseDTOBuilder<PetInfoWithCompleteOwner> builder = ResponseDTO.builder();
		ResponseDTO<PetInfoWithCompleteOwner> response = builder
				.content(petDtoCreated.getPet())
				.message(String.format(Constants.PET_CREATED_WITH_ID, petDtoCreated.getId()))
				.status(ResponseConstants.SUCCESS)
				.build();
		return ResponseEntity.ok().body(response);
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseDTO<String>> deletePet(@PathVariable(name = "id") int id) {
		return null;
	}

}
