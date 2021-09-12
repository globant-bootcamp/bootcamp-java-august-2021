package com.globant.vet.controller;

import java.util.List;

import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.ResponseDTO;

public interface VetController {
	public ResponseDTO<PetInfo> getInfoPet(String petId);
	public ResponseDTO<List<PetDTO>> getPets();
	public ResponseDTO<PetInfo> updatePet(String id, PetInfo newPet);
	public ResponseDTO<PetInfo> createPet(PetInfo newPet);
	public ResponseDTO<String> deletePet(String id);
}
