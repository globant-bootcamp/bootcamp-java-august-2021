package com.globant.vet.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.PetInfoWithOwner;
import com.globant.vet.dto.ResponseDTO;

public interface VetController {
	public ResponseEntity<ResponseDTO<PetInfoWithOwner>> getInfoPet(int petId);
	public ResponseEntity<ResponseDTO<List<PetDTO<PetInfoWithOwner>>>> getPets();
	public ResponseEntity<ResponseDTO<PetInfo>> updatePet(int petId, PetInfo newPet);
	public ResponseEntity<ResponseDTO<PetInfo>> createPet(PetInfo newPet);
	public ResponseEntity<ResponseDTO<String>> deletePet(int petId);
}
