package com.globant.vet.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hamcrest.CoreMatchers;
import org.hamcrest.beans.HasPropertyWithValue;
import org.hibernate.collection.internal.PersistentBag;
import org.hibernate.engine.spi.SessionImplementor;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.globant.vet.converters.CustomerConverter;
import com.globant.vet.converters.PetConverter;
import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfoWithCompleteOwner;
import com.globant.vet.exception.EntityNotFound;
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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import static org.powermock.api.mockito.PowerMockito.when;

import static com.globant.vet.util.ConstantsTests.AGE_PET;
import static com.globant.vet.util.ConstantsTests.ID_CUSTOMER;
import static com.globant.vet.util.ConstantsTests.ID_PET_1;
import static com.globant.vet.util.ConstantsTests.ID_PET_2;
import static com.globant.vet.util.ConstantsTests.ID_PET_NOT_FOUND;
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
		Pet petWithIdAndOwner = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		CustomerInfo customerInfo = CustomerFactory.createCustomerInfo();
		CustomerDTO<CustomerInfo> customerDtoOfCustomerInfo = CustomerFactory.createCustomerDtoOfCustomerInfo();
		PetInfoWithCompleteOwner petInfoWithCompleteOwner = PetFactory.createPetInfoWithCompleteOwner();
		
		when(petRepository.findById(any(Integer.class))).thenReturn(optionalPetPresent);
		when(validatorUtil.validateExistance(ArgumentMatchers.<Optional<Pet>>any(), any(Integer.class), any(String.class))).thenReturn(petWithIdAndOwner);
		when(customerConverter.customerToCustomerInfo(any(Customer.class))).thenReturn(customerInfo);
		when(customerConverter.customerInfoToCustomerDTO(any(Integer.class), any(CustomerInfo.class))).thenReturn(customerDtoOfCustomerInfo);
		when(petConverter.petToPetInfoWithOwner(any(Pet.class), ArgumentMatchers.<CustomerDTO<CustomerInfo>>any())).thenReturn(petInfoWithCompleteOwner);
		
		PetInfoWithCompleteOwner petResponse = petService.getPetById(ID_PET_1);

		assertNotNull(petResponse);
		assertTrue(optionalPetPresent.isPresent());
		verify(customerConverter, times(1)).customerToCustomerInfo(any(Customer.class));
		verify(customerConverter, times(1)).customerInfoToCustomerDTO(ID_CUSTOMER, customerInfo);
		verify(validatorUtil, atLeast(1)).validateExistance(ArgumentMatchers.<Optional<?>>any(),any(Integer.class),any(String.class));
		verify(validatorUtil, atLeast(1)).validateExistance(optionalPetPresent,ID_PET_1,PET_NOT_FOUND);
	}
	
	@Test
	public void getPetByIdFailure() {
		Optional<Pet> optionalNotPetPresent = PetFactory.createOptionalPetNotPresent();
		
		when(petRepository.findById(any(Integer.class))).thenReturn(optionalNotPetPresent);
		when(validatorUtil.validateExistance(optionalNotPetPresent, ID_PET_NOT_FOUND, PET_NOT_FOUND)).thenThrow(EntityNotFound.class);
						
		assertFalse(optionalNotPetPresent.isPresent());
		assertThrows(EntityNotFound.class , () -> petService.getPetById(ID_PET_NOT_FOUND));
	}
	
	
	@Test
	public void deletePetSucess(){
		Pet petWithIdAndOwner = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		
		when(petRepository.findById(any(Integer.class))).thenReturn(Optional.of(petWithIdAndOwner));
		when(validatorUtil.validateExistance(ArgumentMatchers.<Optional<Pet>>any(), any(Integer.class), any(String.class))).thenReturn(petWithIdAndOwner);
		
		String msgPetDeleted = petService.deletePetById(ID_PET_1);
		
		assertNotNull(msgPetDeleted);
		assertEquals(ConstantsTests.PET_DELETED, msgPetDeleted);
	}	
	
	@Test
	public void deletePetFailure(){
		Optional<Pet> optionalNotPetPresent = PetFactory.createOptionalPetNotPresent();
		
		when(petRepository.findById(any(Integer.class))).thenReturn(optionalNotPetPresent);
		when(validatorUtil.validateExistance(ArgumentMatchers.<Optional<Pet>>any(), anyInt(), anyString())).thenThrow(EntityNotFound.class);

		assertThrows(EntityNotFound.class , () -> petService.deletePetById(ID_PET_NOT_FOUND));
	}
	
	@Test
	public void getAllPetsSucess() {
		List<Pet> petsFromDb = PetFactory.createListOfPetsWithIdsAndOwnerWithId();
		CustomerInfo customerInfo = CustomerFactory.createCustomerInfo();
		CustomerDTO<CustomerInfo> customerDtoOfCustomerInfo = CustomerFactory.createCustomerDtoOfCustomerInfo();
		PetInfoWithCompleteOwner petInfoWithCompleteOwner = PetFactory.createPetInfoWithCompleteOwner();
		
		when(petRepository.findAll()).thenReturn(petsFromDb);
		when(customerConverter.customerToCustomerInfo(any(Customer.class))).thenReturn(customerInfo);
		when(customerConverter.customerInfoToCustomerDTO(any(Integer.class), any(CustomerInfo.class))).thenReturn(customerDtoOfCustomerInfo);
		when(petConverter.petToPetInfoWithOwner(any(Pet.class), ArgumentMatchers.<CustomerDTO<CustomerInfo>>any())).thenReturn(petInfoWithCompleteOwner);
		
		List<PetDTO<PetInfoWithCompleteOwner>> petsDtos = petService.getAllPets();
		
		assertNotNull(petsFromDb);
		assertNotNull(petsDtos);
		assertThat(petsDtos.size(), is(2));
		assertThat(petsDtos.get(0).getId(), is(ID_PET_1));
		assertThat(petsDtos.get(1).getId(), is(ID_PET_2));
		assertThat(petsDtos.get(0).getPet().getName(), is(NAME_PET));
	}
}
