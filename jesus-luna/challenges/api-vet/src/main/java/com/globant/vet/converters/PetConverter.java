package com.globant.vet.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.PetInfoWithCompleteOwner;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;

@Service
public class PetConverter {
	
	public Pet petInfoWithCompleteOwnertToPetWithOwner(PetInfoWithCompleteOwner petInfoWithCompleteOwner,Customer owner) {
		Pet pet = new Pet();
		pet.setAge(petInfoWithCompleteOwner.getAge());
		pet.setMeeting(petInfoWithCompleteOwner.getMeeting());
		pet.setName(petInfoWithCompleteOwner.getName());
		pet.setType(petInfoWithCompleteOwner.getType());
		pet.setOwner(owner);
		return pet;
	}
	
	public PetInfo petToPetInfo(Pet pet) {
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
		return pets.stream().map(pet->petToPetInfo(pet)).collect(Collectors.toList());
	}
	
	public List<PetDTO<PetInfo>> petsToPetsDtoOfPetInfo(List<Pet> pets){
		return pets.stream().map(pet->new PetDTO<>(pet.getId(), petToPetInfo(pet))).collect(Collectors.toList());
	}
}
