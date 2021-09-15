package com.globant.vet.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.CustomerInfoWithPets;
import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;

public class CustomerFactory {

	public static Customer createCustomerWitId() {
		Customer customer = new Customer();
		customer.setId(ConstantsTests.ID_CUSTOMER);
		customer.setName(ConstantsTests.NAME_CUSTOMER);
		return customer;
	}

	public static Optional<Customer> createOptionalCustomerPresent() {
		Customer customer = CustomerFactory.createCustomerWitId();
		return Optional.of(customer);
	}

	public static Optional<Customer> createOptionalCustomerNotPresent() {
		return Optional.empty();
	}

	public static Customer createCustomerWithIdAndListPetsWithIds() {
		Customer customer = new Customer();
		Pet pet1 = PetFactory.createPetWithIdAndOwnerWithId(ConstantsTests.ID_PET_1);
		Pet pet2 = PetFactory.createPetWithIdAndOwnerWithId(ConstantsTests.ID_PET_2);
		customer.setId(ConstantsTests.ID_CUSTOMER);
		customer.setName(ConstantsTests.NAME_CUSTOMER);
		customer.setPets(Arrays.asList(pet1, pet2));
		return customer;
	}

	public static CustomerInfo createCustomerInfo() {
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setName(ConstantsTests.NAME_CUSTOMER);
		return customerInfo;
	}

	public static CustomerInfoWithPets createCustomerInfoWithPets() {
		CustomerInfoWithPets customerInfoWithPets = new CustomerInfoWithPets();
		customerInfoWithPets.setName(ConstantsTests.NAME_CUSTOMER);
		List<PetDTO<PetInfo>> listOfPetsDtoOfPetInfo = PetFactory.createListOfPetDtosOfPetInfo();
		customerInfoWithPets.setPets(listOfPetsDtoOfPetInfo);
		return customerInfoWithPets;

	}

	public static CustomerDTO<CustomerInfo> createCustomerDtoOfCustomerInfo() {
		CustomerInfo customerInfo = createCustomerInfo();
		return new CustomerDTO<CustomerInfo>(ConstantsTests.ID_CUSTOMER, customerInfo);
	}
}
