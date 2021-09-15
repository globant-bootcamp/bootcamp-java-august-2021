package com.bootcamp.vetpatitas.service;

import com.bootcamp.vetpatitas.dto.PetDTO;

public interface PetService {

	PetDTO addPet (PetDTO petDTO); 
	
	PetDTO updatePet (PetDTO petDTO);
	
	PetDTO getPet (Long petId);
	
	PetDTO deletePet (Long petId);
	
}
