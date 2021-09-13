package com.globant.vet.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.globant.vet.converters.CustomerConverter;
import com.globant.vet.converters.PetConverter;
import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.PetInfoWithCompleteOwner;
import com.globant.vet.exception.EntityNotFound;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;
import com.globant.vet.repository.CustomerRepository;
import com.globant.vet.repository.PetRepository;
import com.globant.vet.service.PetService;
import com.globant.vet.util.GeneralUtil;
import com.globant.vet.util.ValidatorUtils;
import com.globant.vet.util.constants.Constants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PetServiceImpl implements PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PetConverter petConverter;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	@Autowired
	private ValidatorUtils validatorUtil;
	
	@Autowired
	private GeneralUtil generalUtil;
	
	private PetInfoWithCompleteOwner getPetWithOwner(Pet pet) {
		Customer owner = pet.getOwner();
		CustomerInfo customerInfo = customerConverter.customerToCustomerInfo(owner);
		CustomerDTO<CustomerInfo> customerDTO = customerConverter.customerInfoToCustomerDTO(owner.getId(), customerInfo);
		return petConverter.petToPetInfoWithOwner(pet, customerDTO);
	}

	@Override
	public PetInfoWithCompleteOwner getPetById(int id) {
		Optional<Pet> optionalPet = petRepository.findById(id);
		if(optionalPet.isEmpty()) {
			throw new EntityNotFound(String.format(Constants.PET_NOT_FOUND, id));
		}
		Pet pet = optionalPet.get();
		return getPetWithOwner(pet);
	}
	
	@Override
	public List<PetDTO<PetInfoWithCompleteOwner>> getAllPets() {
		List<Pet> pets = petRepository.findAll();
		return pets.stream().map(pet->{
			PetInfoWithCompleteOwner petWithOwner = getPetWithOwner(pet);
			return new PetDTO<>(pet.getId(), petWithOwner);
			
		}).collect(Collectors.toList());
	}

	@Override
	public PetDTO<PetInfoWithCompleteOwner> createPet(PetInfoWithCompleteOwner petRequest) {
		CustomerDTO<CustomerInfo> owner = petRequest.getOwner();
		CustomerInfo customerInfo = owner.getCustomer();
		int customerId = owner.getId();
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		Customer customerDB;
		if(optionalCustomer.isEmpty()) {
			customerDB = customerConverter.customerInfoToCostumer(customerInfo);
			customerDB = customerRepository.save(customerDB);
		}else {
			customerDB = validatorUtil.validateCustomerRqWithCustomerDB(optionalCustomer.get(), customerInfo);
		}
		Pet petToStore = petConverter.petInfoWithCompleteOwnertToPetWithOwner(petRequest, customerDB);
		Pet storedPet = petRepository.save(petToStore);
		PetInfoWithCompleteOwner petWithOwner = getPetWithOwner(storedPet);
		
		return new PetDTO<>(storedPet.getId(), petWithOwner);
	}

	@Override
	public String deletePetById(int id) {
		return null;
	}

	@Override
	public PetInfo updatePet(PetInfo petInfo, int id) {
		Optional<Pet> optionalPet = petRepository.findById(id);
		if(optionalPet.isEmpty()) {
			throw new EntityNotFound(String.format(Constants.PET_NOT_FOUND, id));
		}
		Pet petToUpdate = generalUtil.overridePetWithPetInfo(optionalPet.get(), petInfo);
		Pet updatedPet = petRepository.save(petToUpdate);
		return petConverter.petToPetInfo(updatedPet);
	}

}
