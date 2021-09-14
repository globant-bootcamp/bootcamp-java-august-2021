package com.bootcamp.vetpatitas.mapper;

import org.springframework.stereotype.Component;

import com.bootcamp.vetpatitas.dto.PetDTO;
import com.bootcamp.vetpatitas.entity.Pet;

@Component
public class PetMapper {

	public Pet PetDTOToEntity(PetDTO petDTO) {
		Pet pet = new Pet();
		pet.setName(petDTO.getName());
		pet.setType(petDTO.getType());
		pet.setAge(petDTO.getAge());
		pet.setPhoneNumber(petDTO.getPhoneNumber());
		pet.setOwner(petDTO.getOwner());
		return pet;
	}
	
	public PetDTO EntityToUserDTO(Pet pet) {		
		PetDTO petDTO = new PetDTO();
		petDTO.setName(pet.getName());
		petDTO.setType(pet.getType());
		petDTO.setAge(pet.getAge());
		petDTO.setPhoneNumber(pet.getPhoneNumber());
		petDTO.setOwner(pet.getOwner());
		return petDTO;
		
	}
	
}
