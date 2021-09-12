package com.globant.vet.service;

import java.util.List;

import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.PetInfoWithOwner;

public interface PetService {
	public PetInfoWithOwner getPetById(int id);
	public List<PetDTO<PetInfoWithOwner>> getAllPets();
	public PetDTO createPet(PetInfo petInfo);
	public String deletePetById(int id);
	public PetInfo updatePet(PetInfo petInfo, int id);
}
