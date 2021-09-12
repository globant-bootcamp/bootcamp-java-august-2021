package com.globant.vet.service;

import java.util.List;

import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.PetInfoWithCompleteOwner;

public interface PetService {
	public PetInfoWithCompleteOwner getPetById(int id);
	public List<PetDTO<PetInfoWithCompleteOwner>> getAllPets();
	public PetDTO createPet(PetInfo petInfo);
	public String deletePetById(int id);
	public PetInfo updatePet(PetInfo petInfo, int id);
}
