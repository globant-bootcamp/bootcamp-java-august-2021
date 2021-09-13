package com.globant.vet.util;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.exception.EntityNotFound;
import com.globant.vet.exception.InputMismatchException;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;
import com.globant.vet.util.constants.Constants;

@Component
public class ValidatorUtils {
	public Customer validateCustomerRqWithCustomerDB(Customer customerDb, CustomerInfo customerRq){
		if(!customerDb.getName().equalsIgnoreCase(customerRq.getName())) {
			throw new InputMismatchException(Constants.CUSTOMER_INFO_DIDNT_MATCH);
		}
		return customerDb;
	}
	
	public Pet validateExistancePet(Optional<Pet> optionalPet, int id) {
		if(optionalPet.isEmpty()) {
			throw new EntityNotFound(String.format(Constants.PET_NOT_FOUND, id));
		}
		return optionalPet.get();
	}
}
