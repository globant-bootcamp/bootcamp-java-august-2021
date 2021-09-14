package com.globant.vet.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.PetInfoWithCompleteOwner;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;

public class PetFactory {
	
	public static Pet createPetWithIdAndOwnerWithId(int petId) {
		Pet pet = new Pet();
		Customer owner = CustomerFactory.createCustomerWitId();
		pet.setAge(ConstantsTests.AGE_PET);
		pet.setId(petId);
		pet.setMeeting(ConstantsTests.MEETING_PET);
		pet.setName(ConstantsTests.NAME_PET);
		pet.setType(ConstantsTests.TYPE_PET);
		pet.setOwner(owner);
		return pet;
	}
	
	public static List<Pet> createListOfPetsWithIdsAndOwnerWithId(){
		Pet pet1 = PetFactory.createPetWithIdAndOwnerWithId(ConstantsTests.ID_PET_1);
		Pet pet2 = PetFactory.createPetWithIdAndOwnerWithId(ConstantsTests.ID_PET_2);
		return Arrays.asList(pet1, pet2);
	}	
	public static Optional<Pet> createOptionalPetPresent(){
		Pet pet = createPetWithIdAndOwnerWithId(ConstantsTests.ID_PET_1);
		return Optional.of(pet);
	}
	
	public static Optional<Pet> createOptionalPetNotPresent(){
		return Optional.empty();
	}
	
	public static PetInfoWithCompleteOwner createPetInfoWithCompleteOwner() {
		CustomerDTO<CustomerInfo> customerDtoOfCustomerInfo = CustomerFactory.createCustomerDtoOfCustomerInfo();
		PetInfoWithCompleteOwner petInfoWithCompleteOwner = new PetInfoWithCompleteOwner();
		petInfoWithCompleteOwner.setAge(ConstantsTests.AGE_PET);
		petInfoWithCompleteOwner.setMeeting(ConstantsTests.MEETING_PET);
		petInfoWithCompleteOwner.setName(ConstantsTests.NAME_PET);
		petInfoWithCompleteOwner.setOwner(customerDtoOfCustomerInfo);
		petInfoWithCompleteOwner.setType(ConstantsTests.TYPE_PET);
		return petInfoWithCompleteOwner;
		
	}
	
}
