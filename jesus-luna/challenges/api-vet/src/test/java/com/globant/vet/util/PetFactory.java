package com.globant.vet.util;

import java.util.Optional;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.PetInfoWithCompleteOwner;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;

public class PetFactory {
	
	public static Pet createPetWithIdAndOwnerWithId() {
		Pet pet = new Pet();
		Customer owner = CustomerFactory.createCustomerWitId();
		pet.setAge(ConstantsTests.AGE_PET);
		pet.setId(ConstantsTests.ID_PET);
		pet.setMeeting(ConstantsTests.MEETING_PET);
		pet.setName(ConstantsTests.NAME_PET);
		pet.setType(ConstantsTests.TYPE_PET);
		pet.setOwner(owner);
		return pet;
	}
	
	public static Optional<Pet> createOptionalPetPresent(){
		Pet pet = createPetWithIdAndOwnerWithId();
		return Optional.of(pet);
	}
	
	public static Optional<Pet> createOptionalPetNotPresent(){
		Pet pet = null;
		return Optional.ofNullable(pet);
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
