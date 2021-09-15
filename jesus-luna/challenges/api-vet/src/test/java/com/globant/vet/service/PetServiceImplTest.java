package com.globant.vet.service;


import java.util.List;
import java.util.Optional;

import org.junit.Test;
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
import com.globant.vet.dto.PetInfo;
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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import static org.powermock.api.mockito.PowerMockito.when;

import static com.globant.vet.util.ConstantsTests.ID_CUSTOMER;
import static com.globant.vet.util.ConstantsTests.ID_PET_1;
import static com.globant.vet.util.ConstantsTests.ID_PET_2;
import static com.globant.vet.util.ConstantsTests.ID_PET_NOT_FOUND;
import static com.globant.vet.util.ConstantsTests.NAME_PET;
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
		when(validatorUtil.validateExistance(
				ArgumentMatchers.<Optional<Pet>>any(), any(Integer.class), any(String.class))).thenReturn(petWithIdAndOwner);
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
	
	@Test
	public void createPetSuccessAndCreateCustomer() {
		Optional<Customer> optionalCustomerFromDbNotPresent = CustomerFactory.createOptionalCustomerNotPresent();
		Customer customerWithOutId = CustomerFactory.createCustomerWitId();
		customerWithOutId.setId(0);
		PetInfoWithCompleteOwner petRequest = PetFactory.createPetInfoWithCompleteOwner();
		Customer customerWithId = CustomerFactory.createCustomerWitId();
		Pet petToStore = PetFactory.createPetWithIdAndOwnerWithId(0);
		Pet storedPet = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		CustomerInfo customerInfo = CustomerFactory.createCustomerInfo();
		CustomerDTO<CustomerInfo> customerDTO = CustomerFactory.createCustomerDtoOfCustomerInfo();
		PetInfoWithCompleteOwner petInfoWithCompleteOwner = PetFactory.createPetInfoWithCompleteOwner();
		
		when(customerRepository.findById(anyInt())).thenReturn(optionalCustomerFromDbNotPresent);
		when(customerConverter.customerInfoToCostumer(any(CustomerInfo.class))).thenReturn(customerWithOutId);
		when(customerRepository.save(any(Customer.class))).thenReturn(customerWithId);
		when(petConverter.petInfoWithCompleteOwnertToPetWithOwner(petRequest, customerWithId)).thenReturn(petToStore);
		when(petRepository.save(any(Pet.class))).thenReturn(storedPet);
		
		when(customerConverter.customerToCustomerInfo(any(Customer.class))).thenReturn(customerInfo);
		when(customerConverter.customerInfoToCustomerDTO(anyInt(), any(CustomerInfo.class))).thenReturn(customerDTO);
		when(petConverter.petToPetInfoWithOwner(any(Pet.class), ArgumentMatchers.<CustomerDTO<CustomerInfo>>any())).thenReturn(petInfoWithCompleteOwner);
		
		PetDTO<PetInfoWithCompleteOwner> response = petService.createPet(petRequest);
		
		assertNotNull(response);
		assertThat(response.getId(), is(storedPet.getId()));
		assertEquals(response.getPet().getMeeting(), storedPet.getMeeting());
	}
	
	@Test
	public void createPetSuccessDontCreateCustomer() {
		Optional<Customer> optionalCustomerFromDbPresent = CustomerFactory.createOptionalCustomerPresent();
		Customer customerWithId = CustomerFactory.createCustomerWitId();
		
		PetInfoWithCompleteOwner petRequest = PetFactory.createPetInfoWithCompleteOwner();
		
		Pet petToStore = PetFactory.createPetWithIdAndOwnerWithId(0);
		Pet storedPet = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		CustomerInfo customerInfo = CustomerFactory.createCustomerInfo();
		CustomerDTO<CustomerInfo> customerDTO = CustomerFactory.createCustomerDtoOfCustomerInfo();
		PetInfoWithCompleteOwner petInfoWithCompleteOwner = PetFactory.createPetInfoWithCompleteOwner();
		
		when(customerRepository.findById(anyInt())).thenReturn(optionalCustomerFromDbPresent);
		when(validatorUtil.validateCustomerRqWithCustomerDB(any(Customer.class),any(CustomerInfo.class))).thenReturn(customerWithId);
		when(petConverter.petInfoWithCompleteOwnertToPetWithOwner(petRequest, customerWithId)).thenReturn(petToStore);
		when(petRepository.save(any(Pet.class))).thenReturn(storedPet);
		
		when(customerConverter.customerToCustomerInfo(any(Customer.class))).thenReturn(customerInfo);
		when(customerConverter.customerInfoToCustomerDTO(anyInt(), any(CustomerInfo.class))).thenReturn(customerDTO);
		when(petConverter.petToPetInfoWithOwner(any(Pet.class), ArgumentMatchers.<CustomerDTO<CustomerInfo>>any())).thenReturn(petInfoWithCompleteOwner);
		
		PetDTO<PetInfoWithCompleteOwner> response = petService.createPet(petRequest);
		
		assertNotNull(response);
		assertThat(response.getId(), is(storedPet.getId()));
		assertEquals(response.getPet().getMeeting(), storedPet.getMeeting());
	}
	
	@Test
	public void updatePetExistanceSuccess() {
		PetInfoWithCompleteOwner petInfoRequest = PetFactory.createPetInfoWithCompleteOwner();
		petInfoRequest.setOwner(null);
		Optional<Pet> optionalPetPresent = PetFactory.createOptionalPetPresent();
		Pet petOverrided = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		Pet updatedPet = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		PetInfoWithCompleteOwner petInfoResponse = PetFactory.createPetInfoWithCompleteOwner();
		
		
		when(petRepository.findById(anyInt())).thenReturn(optionalPetPresent);
		when(validatorUtil.validateExistance(optionalPetPresent, ID_PET_1, PET_NOT_FOUND)).thenReturn(optionalPetPresent.get());
		when(generalUtil.overridePetWithPetInfo(optionalPetPresent.get(), petInfoRequest)).thenReturn(petOverrided);
		when(petRepository.save(petOverrided)).thenReturn(updatedPet);
		when(petConverter.petToPetInfo(updatedPet)).thenReturn(petInfoResponse);
		
		PetInfo response = petService.updatePet(petInfoRequest, ID_PET_1);
		
		assertNotNull(response);
		assertThat(response.getName(), is(updatedPet.getName()));
		assertThat(response.getMeeting(), is(updatedPet.getMeeting()));
		assertThat(response.getType(), is(updatedPet.getType()));
	}
	
	@Test
	public void updatePetExistanceFailure() {
		PetInfoWithCompleteOwner petInfoRequest = PetFactory.createPetInfoWithCompleteOwner();
		petInfoRequest.setOwner(null);
		Optional<Pet> optionalPetNotPresent = PetFactory.createOptionalPetNotPresent();
		
		
		when(petRepository.findById(anyInt())).thenReturn(optionalPetNotPresent);
		when(validatorUtil.validateExistance(optionalPetNotPresent, ID_PET_NOT_FOUND, PET_NOT_FOUND)).thenThrow(EntityNotFound.class);
		
		assertThrows(EntityNotFound.class , () -> petService.updatePet(petInfoRequest,ID_PET_NOT_FOUND));
	}
}
