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
import com.globant.vet.dto.PetInfoWithOwner;
import com.globant.vet.exception.EntityNotFound;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;
import com.globant.vet.repository.PetRepository;
import com.globant.vet.service.PetService;
import com.globant.vet.util.constants.Constants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PetServiceImpl implements PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private PetConverter petConverter;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	public PetInfoWithOwner getPetWithOwner(Pet pet) {
		Customer owner = pet.getOwner();
		CustomerInfo customerInfo = customerConverter.customerToCustomerInfo(owner);
		CustomerDTO<CustomerInfo> customerDTO = customerConverter.customerInfoToCustomerDTO(owner.getId(), customerInfo);
		return petConverter.petToPetInfoWithOwner(pet, customerDTO);
	}

	@Override
	public PetInfoWithOwner getPetById(int id) {
		Optional<Pet> optionalPet = petRepository.findById(id);
		if(optionalPet.isEmpty()) {
			throw new EntityNotFound(String.format(Constants.PET_NOT_FOUND, id));
		}
		Pet pet = optionalPet.get();
		return getPetWithOwner(pet);
	}
	
	@Override
	public List<PetDTO<PetInfoWithOwner>> getAllPets() {
		List<Pet> pets = petRepository.findAll();
		return pets.stream().map(pet->{
			PetInfoWithOwner petWithOwner = getPetWithOwner(pet);
			return new PetDTO<>(pet.getId(), petWithOwner);
			
		}).collect(Collectors.toList());
	}

	@Override
	public PetDTO createPet(PetInfo petInfo) {
		return null;
	}

	@Override
	public String deletePetById(int id) {
		return null;
	}

	@Override
	public PetInfo updatePet(PetInfo petInfo, int id) {
		return null;
	}

}
