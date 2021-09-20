package com.globant.vet.util;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;

@Component
public class GeneralUtil {
	public Pet overridePetWithPetInfo(Pet pet, PetInfo petInfo) {
		int age = (pet.getAge() != petInfo.getAge()) ? petInfo.getAge() : pet.getAge();
		LocalDateTime meeting = (pet.getMeeting() != petInfo.getMeeting()) ? petInfo.getMeeting() : pet.getMeeting();
		String name = (pet.getName().equalsIgnoreCase(petInfo.getName())) ? pet.getName() : petInfo.getName();
		String type = (pet.getType().equalsIgnoreCase(petInfo.getType())) ? pet.getType() : petInfo.getType();
		pet.setAge(age);
		pet.setMeeting(meeting);
		pet.setName(name);
		pet.setType(type);
		return pet;
	}
	
	public Customer overrideCustomerWithCustomerInfo(Customer customer, CustomerInfo customerInfo) {
		String name = (customer.getName().equalsIgnoreCase(customerInfo.getName())) ? customer.getName() : customerInfo.getName();
		customer.setName(name);
		return customer;
	}
}
