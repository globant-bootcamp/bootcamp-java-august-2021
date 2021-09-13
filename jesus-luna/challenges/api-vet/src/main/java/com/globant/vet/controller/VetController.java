package com.globant.vet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.PetInfoWithCompleteOwner;
import com.globant.vet.dto.ResponseDTO;
@Validated
public interface VetController {
	public ResponseEntity<ResponseDTO<PetInfoWithCompleteOwner>> getInfoPet(int petId);
	public ResponseEntity<ResponseDTO<List<PetDTO<PetInfoWithCompleteOwner>>>> getPets();
	public ResponseEntity<ResponseDTO<PetInfo>> updatePet(int petId, PetInfo newPet);
	public ResponseEntity<ResponseDTO<PetInfoWithCompleteOwner>> createPet(@Valid  PetInfoWithCompleteOwner newPet);
	public ResponseEntity<ResponseDTO<String>> deletePet(int petId);
}
