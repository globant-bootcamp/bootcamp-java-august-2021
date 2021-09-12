package com.globant.vet.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.PetInfoWithCompleteOwner;
import com.globant.vet.model.Pet;

@Service
public class PetConverter {
	
	public static PetInfo petToPetInfo(Pet pet) {
		return PetInfo.builder()
			.age(pet.getAge())
			.meeting(pet.getMeeting())
			.name(pet.getName())
			.type(pet.getType())
			.build();
	}
	
	public PetInfoWithCompleteOwner petToPetInfoWithOwner(Pet pet, CustomerDTO<CustomerInfo> customerDTO) {
		return PetInfoWithCompleteOwner.builder()
			.age(pet.getAge())
			.meeting(pet.getMeeting())
			.name(pet.getName())
			.type(pet.getType())
			.owner(customerDTO)
			.build();
	}
	
	public List<PetInfo> petsToPetsInfo(List<Pet> pets){
		return pets.stream().map(PetConverter::petToPetInfo).collect(Collectors.toList());
	}
}
