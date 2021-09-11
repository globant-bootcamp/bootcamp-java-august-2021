package com.bootcamp.vetPatitas.service;

import com.bootcamp.vetPatitas.dto.PetDTO;

public interface PetService {

	PetDTO addPet (PetDTO petDTO); 
	
	PetDTO updatePet (PetDTO petDTO);
	
	PetDTO getPet (Long petId);
	
	PetDTO deletePet (PetDTO petDTO);
	
}
