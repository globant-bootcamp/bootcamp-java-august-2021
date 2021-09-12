package com.globant.vet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.ResponseDTO;

@RestController
@RequestMapping("/pet")
public class VetControllerImpl implements VetController {

	@Override
	public ResponseDTO<PetInfo> getInfoPet(String petId) {
		return null;
	}

	@Override
	public ResponseDTO<List<PetDTO>> getPets() {
		return null;
	}

	@Override
	public ResponseDTO<PetInfo> updatePet(String id, PetInfo newPet) {
		return null;
	}

	@Override
	public ResponseDTO<PetInfo> createPet(PetInfo newPet) {
		return null;
	}

	@Override
	public ResponseDTO<String> deletePet(String id) {
		return null;
	}

}
