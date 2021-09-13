package com.globant.vet.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.globant.vet.converters.CustomerConverter;
import com.globant.vet.converters.PetConverter;
import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.PetInfoWithCompleteOwner;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;
import com.globant.vet.repository.CustomerRepository;
import com.globant.vet.repository.PetRepository;
import com.globant.vet.service.impl.PetServiceImpl;
import com.globant.vet.util.ConstantsTests;
import com.globant.vet.util.CustomerFactory;
import com.globant.vet.util.GeneralUtil;
import com.globant.vet.util.PetFactory;
import com.globant.vet.util.ValidatorUtils;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.when;

import static com.globant.vet.util.ConstantsTests.AGE_PET;
import static com.globant.vet.util.ConstantsTests.ID_CUSTOMER;
import static com.globant.vet.util.ConstantsTests.ID_PET;
import static com.globant.vet.util.ConstantsTests.MEETING_PET;
import static com.globant.vet.util.ConstantsTests.NAME_CUSTOMER;
import static com.globant.vet.util.ConstantsTests.NAME_PET;
import static com.globant.vet.util.ConstantsTests.TYPE_PET;
import static com.globant.vet.util.ConstantsTests.PET_NOT_FOUND;


@RunWith(MockitoJUnitRunner.class)
public class PetServiceImplTest {
	
	@InjectMocks
	private PetServiceImpl petService;
	
	@Mock
	private PetRepository petRepository;
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Mock
	private PetConverter petConverter;
	
	@Mock
	private CustomerConverter customerConverter;
	
	@Mock
	private ValidatorUtils validatorUtil;
	
	@Mock
	private GeneralUtil generalUtil;
	
	
	@Test
	public void getPetByIdSucess() {
		Optional<Pet> optionalPetPresent = PetFactory.createOptionalPetPresent();
		Pet petWithIdAndOwner = PetFactory.createPetWithIdAndOwnerWithId();
		Customer customerWithId = CustomerFactory.createCustomerWitId();
		CustomerInfo customerInfo = CustomerFactory.createCustomerInfo();
		CustomerDTO<CustomerInfo> customerDtoOfCustomerInfo = CustomerFactory.createCustomerDtoOfCustomerInfo();
		PetInfoWithCompleteOwner petInfoWithCompleteOwner = PetFactory.createPetInfoWithCompleteOwner();
		
		when(petRepository.findById(any(Integer.class))).thenReturn(optionalPetPresent);
		when(validatorUtil.validateExistance(ArgumentMatchers.<Optional<Pet>>any(), any(Integer.class), any(String.class))).thenReturn(petWithIdAndOwner);
		when(customerConverter.customerToCustomerInfo(any(Customer.class))).thenReturn(customerInfo);
		when(customerConverter.customerInfoToCustomerDTO(any(Integer.class), any(CustomerInfo.class))).thenReturn(customerDtoOfCustomerInfo);
		when(petConverter.petToPetInfoWithOwner(any(Pet.class), ArgumentMatchers.<CustomerDTO<CustomerInfo>>any())).thenReturn(petInfoWithCompleteOwner);
		
		PetInfoWithCompleteOwner petResponse = petService.getPetById(ID_PET);
		
		Customer c = new Customer();
		c.setId(ID_CUSTOMER);
		c.setName(NAME_CUSTOMER);
		List<Pet> pets = new ArrayList<>();
		Pet p = new Pet();
		p.setAge(AGE_PET);
		p.setId(ID_PET);
		p.setMeeting(MEETING_PET);
		p.setName(NAME_PET);
		p.setType(TYPE_PET);
		p.setOwner(c);
		pets.add(p);
		c.setPets(pets);
		
		assertNotNull(petResponse);
		verify(customerConverter, times(1)).customerToCustomerInfo(c);
	}
	
	
	@Test
	public void deletePetSucess(){
		Pet petWithIdAndOwner = PetFactory.createPetWithIdAndOwnerWithId();
		
		when(petRepository.findById(any(Integer.class))).thenReturn(Optional.of(petWithIdAndOwner));
		when(validatorUtil.validateExistance(ArgumentMatchers.<Optional<Pet>>any(), any(Integer.class), any(String.class))).thenReturn(petWithIdAndOwner);
		
		String msgPetDeleted = petService.deletePetById(ID_PET);
		
		assertNotNull(msgPetDeleted);
	}	
}
