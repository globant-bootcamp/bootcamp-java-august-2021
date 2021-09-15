package com.globant.vet.converters;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.PetInfoWithCompleteOwner;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;
import com.globant.vet.utilities.CustomerFactory;
import com.globant.vet.utilities.PetFactory;

import static com.globant.vet.utilities.ConstantsTests.ID_PET_1;
import static com.globant.vet.utilities.ConstantsTests.ID_PET_2;
import static com.globant.vet.utilities.ConstantsTests.NAME_PET_2;
import static com.globant.vet.utilities.ConstantsTests.TYPE_PET_2;
import static com.globant.vet.utilities.ConstantsTests.MEETING_PET_2;
import static com.globant.vet.utilities.ConstantsTests.AGE_PET_2;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class PetConverterTest {

	private PetConverter petConverter = new PetConverter();

	@Test
	public void converPetsToPetsInfo() {
		Pet pet1 = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		Pet pet2 = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_2);
		pet2.setAge(AGE_PET_2);
		pet2.setMeeting(MEETING_PET_2);
		pet2.setName(NAME_PET_2);
		pet2.setType(TYPE_PET_2);
		List<PetInfo> response = petConverter.petsToPetsInfo(Arrays.asList(pet1, pet2));
		assertNotNull(response);
		assertThat(response, hasItem(isA(PetInfo.class)));
		assertThat(response, allOf(notNullValue()));
	}

	@Test
	public void converPetsToPetsDtoOfPetInfo() {
		Pet pet1 = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		Pet pet2 = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_2);
		pet2.setAge(AGE_PET_2);
		pet2.setMeeting(MEETING_PET_2);
		pet2.setName(NAME_PET_2);
		pet2.setType(TYPE_PET_2);
		List<PetDTO<PetInfo>> response = petConverter.petsToPetsDtoOfPetInfo(Arrays.asList(pet1, pet2));
		assertNotNull(response);
		assertThat(response, hasItem(isA(PetDTO.class)));
		assertThat(response, allOf(notNullValue()));
		assertFalse(response.isEmpty());
		assertEquals(response.get(0).getId(), pet1.getId());
	}

	@Test
	public void convertPetToPetInfoWithOwner() {
		Pet pet = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		CustomerDTO<CustomerInfo> customerDto = CustomerFactory.createCustomerDtoOfCustomerInfo();
		PetInfoWithCompleteOwner response = petConverter.petToPetInfoWithOwner(pet, customerDto);
		assertNotNull(response);
		assertNotNull(response.getMeeting());
		assertNotNull(response.getName());
		assertNotNull(response.getOwner());
		assertNotNull(response.getType());
		assertEquals(response.getOwner().getCustomer(), customerDto.getCustomer());
		assertEquals(response.getOwner().getId(), customerDto.getId());
		assertEquals(response.getName(), pet.getName());
	}

	@Test
	public void convertPetToPetInfo() {
		Pet pet = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		PetInfo response = petConverter.petToPetInfo(pet);
		assertNotNull(response);
		assertNotNull(response.getMeeting());
		assertNotNull(response.getName());
		assertNotNull(response.getType());
		assertNotNull(response.getType());
		assertEquals(response.getMeeting(), pet.getMeeting());
		assertEquals(response.getName(), pet.getName());
		assertEquals(response.getAge(), pet.getAge());
	}

	@Test
	public void convertPetInfoWithCompleteOwnerToPetWithOwner() {
		PetInfoWithCompleteOwner pet = PetFactory.createPetInfoWithCompleteOwner();
		Customer customer = CustomerFactory.createCustomerWitId();
		Pet response = petConverter.petInfoWithCompleteOwnertToPetWithOwner(pet, customer);
		assertNotNull(response);
		assertNotNull(response.getMeeting());
		assertNotNull(response.getName());
		assertNotNull(response.getOwner());
		assertNotNull(response.getType());
		assertEquals(response.getOwner(), customer);
		assertEquals(response.getOwner().getId(), customer.getId());
		assertEquals(pet.getMeeting(), response.getMeeting());
		/*
		 * Optional<Pet> optionalPetPresent = PetFactory.createOptionalPetPresent(); Pet
		 * petWithIdAndOwner = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		 * CustomerInfo customerInfo = CustomerFactory.createCustomerInfo();
		 * CustomerDTO<CustomerInfo> customerDtoOfCustomerInfo =
		 * CustomerFactory.createCustomerDtoOfCustomerInfo(); PetInfoWithCompleteOwner
		 * petInfoWithCompleteOwner = PetFactory.createPetInfoWithCompleteOwner();
		 * 
		 * when(petRepository.findById(any(Integer.class))).thenReturn(
		 * optionalPetPresent); when(validatorUtil.validateExistance(
		 * ArgumentMatchers.<Optional<Pet>>any(), any(Integer.class),
		 * any(String.class))).thenReturn(petWithIdAndOwner);
		 * when(customerConverter.customerToCustomerInfo(any(Customer.class))).
		 * thenReturn(customerInfo);
		 * when(customerConverter.customerInfoToCustomerDTO(any(Integer.class),
		 * any(CustomerInfo.class))).thenReturn(customerDtoOfCustomerInfo);
		 * when(petConverter.petToPetInfoWithOwner(any(Pet.class),
		 * ArgumentMatchers.<CustomerDTO<CustomerInfo>>any())).thenReturn(
		 * petInfoWithCompleteOwner);
		 * 
		 * PetInfoWithCompleteOwner petResponse = petService.getPetById(ID_PET_1);
		 * 
		 * assertNotNull(petResponse); assertTrue(optionalPetPresent.isPresent());
		 * verify(customerConverter,
		 * times(1)).customerToCustomerInfo(any(Customer.class));
		 * verify(customerConverter, times(1)).customerInfoToCustomerDTO(ID_CUSTOMER,
		 * customerInfo); verify(validatorUtil,
		 * atLeast(1)).validateExistance(ArgumentMatchers.<Optional<?>>any(),any(Integer
		 * .class),any(String.class)); verify(validatorUtil,
		 * atLeast(1)).validateExistance(optionalPetPresent,ID_PET_1,PET_NOT_FOUND);
		 */
	}
	/*
	 * @Test public void getPetByIdFailure() { Optional<Pet> optionalNotPetPresent =
	 * PetFactory.createOptionalPetNotPresent();
	 * 
	 * when(petRepository.findById(any(Integer.class))).thenReturn(
	 * optionalNotPetPresent);
	 * when(validatorUtil.validateExistance(optionalNotPetPresent, ID_PET_NOT_FOUND,
	 * PET_NOT_FOUND)).thenThrow(EntityNotFound.class);
	 * 
	 * assertFalse(optionalNotPetPresent.isPresent());
	 * assertThrows(EntityNotFound.class , () ->
	 * petService.getPetById(ID_PET_NOT_FOUND)); }
	 * 
	 * 
	 * @Test public void deletePetSucess(){ Pet petWithIdAndOwner =
	 * PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
	 * 
	 * when(petRepository.findById(any(Integer.class))).thenReturn(Optional.of(
	 * petWithIdAndOwner));
	 * when(validatorUtil.validateExistance(ArgumentMatchers.<Optional<Pet>>any(),
	 * any(Integer.class), any(String.class))).thenReturn(petWithIdAndOwner);
	 * 
	 * String msgPetDeleted = petService.deletePetById(ID_PET_1);
	 * 
	 * assertNotNull(msgPetDeleted); assertEquals(ConstantsTests.PET_DELETED,
	 * msgPetDeleted); }
	 * 
	 * @Test public void deletePetFailure(){ Optional<Pet> optionalNotPetPresent =
	 * PetFactory.createOptionalPetNotPresent();
	 * 
	 * when(petRepository.findById(any(Integer.class))).thenReturn(
	 * optionalNotPetPresent);
	 * when(validatorUtil.validateExistance(ArgumentMatchers.<Optional<Pet>>any(),
	 * anyInt(), anyString())).thenThrow(EntityNotFound.class);
	 * 
	 * assertThrows(EntityNotFound.class , () ->
	 * petService.deletePetById(ID_PET_NOT_FOUND)); }
	 * 
	 * @Test public void getAllPetsSucess() { List<Pet> petsFromDb =
	 * PetFactory.createListOfPetsWithIdsAndOwnerWithId(); CustomerInfo customerInfo
	 * = CustomerFactory.createCustomerInfo(); CustomerDTO<CustomerInfo>
	 * customerDtoOfCustomerInfo =
	 * CustomerFactory.createCustomerDtoOfCustomerInfo(); PetInfoWithCompleteOwner
	 * petInfoWithCompleteOwner = PetFactory.createPetInfoWithCompleteOwner();
	 * 
	 * when(petRepository.findAll()).thenReturn(petsFromDb);
	 * when(customerConverter.customerToCustomerInfo(any(Customer.class))).
	 * thenReturn(customerInfo);
	 * when(customerConverter.customerInfoToCustomerDTO(any(Integer.class),
	 * any(CustomerInfo.class))).thenReturn(customerDtoOfCustomerInfo);
	 * when(petConverter.petToPetInfoWithOwner(any(Pet.class),
	 * ArgumentMatchers.<CustomerDTO<CustomerInfo>>any())).thenReturn(
	 * petInfoWithCompleteOwner);
	 * 
	 * List<PetDTO<PetInfoWithCompleteOwner>> petsDtos = petService.getAllPets();
	 * 
	 * assertNotNull(petsFromDb); assertNotNull(petsDtos);
	 * assertThat(petsDtos.size(), is(2)); assertThat(petsDtos.get(0).getId(),
	 * is(ID_PET_1)); assertThat(petsDtos.get(1).getId(), is(ID_PET_2));
	 * assertThat(petsDtos.get(0).getPet().getName(), is(NAME_PET)); }
	 * 
	 * @Test public void createPetSuccessAndCreateCustomer() { Optional<Customer>
	 * optionalCustomerFromDbNotPresent =
	 * CustomerFactory.createOptionalCustomerNotPresent(); Customer
	 * customerWithOutId = CustomerFactory.createCustomerWitId();
	 * customerWithOutId.setId(0); PetInfoWithCompleteOwner petRequest =
	 * PetFactory.createPetInfoWithCompleteOwner(); Customer customerWithId =
	 * CustomerFactory.createCustomerWitId(); Pet petToStore =
	 * PetFactory.createPetWithIdAndOwnerWithId(0); Pet storedPet =
	 * PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1); CustomerInfo customerInfo
	 * = CustomerFactory.createCustomerInfo(); CustomerDTO<CustomerInfo> customerDTO
	 * = CustomerFactory.createCustomerDtoOfCustomerInfo(); PetInfoWithCompleteOwner
	 * petInfoWithCompleteOwner = PetFactory.createPetInfoWithCompleteOwner();
	 * 
	 * when(customerRepository.findById(anyInt())).thenReturn(
	 * optionalCustomerFromDbNotPresent);
	 * when(customerConverter.customerInfoToCostumer(any(CustomerInfo.class))).
	 * thenReturn(customerWithOutId);
	 * when(customerRepository.save(any(Customer.class))).thenReturn(customerWithId)
	 * ; when(petConverter.petInfoWithCompleteOwnertToPetWithOwner(petRequest,
	 * customerWithId)).thenReturn(petToStore);
	 * when(petRepository.save(any(Pet.class))).thenReturn(storedPet);
	 * 
	 * when(customerConverter.customerToCustomerInfo(any(Customer.class))).
	 * thenReturn(customerInfo);
	 * when(customerConverter.customerInfoToCustomerDTO(anyInt(),
	 * any(CustomerInfo.class))).thenReturn(customerDTO);
	 * when(petConverter.petToPetInfoWithOwner(any(Pet.class),
	 * ArgumentMatchers.<CustomerDTO<CustomerInfo>>any())).thenReturn(
	 * petInfoWithCompleteOwner);
	 * 
	 * PetDTO<PetInfoWithCompleteOwner> response = petService.createPet(petRequest);
	 * 
	 * assertNotNull(response); assertThat(response.getId(), is(storedPet.getId()));
	 * assertEquals(response.getPet().getMeeting(), storedPet.getMeeting()); }
	 * 
	 * @Test public void createPetSuccessDontCreateCustomer() { Optional<Customer>
	 * optionalCustomerFromDbPresent =
	 * CustomerFactory.createOptionalCustomerPresent(); Customer customerWithId =
	 * CustomerFactory.createCustomerWitId();
	 * 
	 * PetInfoWithCompleteOwner petRequest =
	 * PetFactory.createPetInfoWithCompleteOwner();
	 * 
	 * Pet petToStore = PetFactory.createPetWithIdAndOwnerWithId(0); Pet storedPet =
	 * PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1); CustomerInfo customerInfo
	 * = CustomerFactory.createCustomerInfo(); CustomerDTO<CustomerInfo> customerDTO
	 * = CustomerFactory.createCustomerDtoOfCustomerInfo(); PetInfoWithCompleteOwner
	 * petInfoWithCompleteOwner = PetFactory.createPetInfoWithCompleteOwner();
	 * 
	 * when(customerRepository.findById(anyInt())).thenReturn(
	 * optionalCustomerFromDbPresent);
	 * when(validatorUtil.validateCustomerRqWithCustomerDB(any(Customer.class),any(
	 * CustomerInfo.class))).thenReturn(customerWithId);
	 * when(petConverter.petInfoWithCompleteOwnertToPetWithOwner(petRequest,
	 * customerWithId)).thenReturn(petToStore);
	 * when(petRepository.save(any(Pet.class))).thenReturn(storedPet);
	 * 
	 * when(customerConverter.customerToCustomerInfo(any(Customer.class))).
	 * thenReturn(customerInfo);
	 * when(customerConverter.customerInfoToCustomerDTO(anyInt(),
	 * any(CustomerInfo.class))).thenReturn(customerDTO);
	 * when(petConverter.petToPetInfoWithOwner(any(Pet.class),
	 * ArgumentMatchers.<CustomerDTO<CustomerInfo>>any())).thenReturn(
	 * petInfoWithCompleteOwner);
	 * 
	 * PetDTO<PetInfoWithCompleteOwner> response = petService.createPet(petRequest);
	 * 
	 * assertNotNull(response); assertThat(response.getId(), is(storedPet.getId()));
	 * assertEquals(response.getPet().getMeeting(), storedPet.getMeeting()); }
	 * 
	 * @Test public void updatePetExistanceSuccess() { PetInfoWithCompleteOwner
	 * petInfoRequest = PetFactory.createPetInfoWithCompleteOwner();
	 * petInfoRequest.setOwner(null); Optional<Pet> optionalPetPresent =
	 * PetFactory.createOptionalPetPresent(); Pet petOverrided =
	 * PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1); Pet updatedPet =
	 * PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1); PetInfoWithCompleteOwner
	 * petInfoResponse = PetFactory.createPetInfoWithCompleteOwner();
	 * 
	 * 
	 * when(petRepository.findById(anyInt())).thenReturn(optionalPetPresent);
	 * when(validatorUtil.validateExistance(optionalPetPresent, ID_PET_1,
	 * PET_NOT_FOUND)).thenReturn(optionalPetPresent.get());
	 * when(generalUtil.overridePetWithPetInfo(optionalPetPresent.get(),
	 * petInfoRequest)).thenReturn(petOverrided);
	 * when(petRepository.save(petOverrided)).thenReturn(updatedPet);
	 * when(petConverter.petToPetInfo(updatedPet)).thenReturn(petInfoResponse);
	 * 
	 * PetInfo response = petService.updatePet(petInfoRequest, ID_PET_1);
	 * 
	 * assertNotNull(response); assertThat(response.getName(),
	 * is(updatedPet.getName())); assertThat(response.getMeeting(),
	 * is(updatedPet.getMeeting())); assertThat(response.getType(),
	 * is(updatedPet.getType())); }
	 * 
	 * @Test public void updatePetExistanceFailure() { PetInfoWithCompleteOwner
	 * petInfoRequest = PetFactory.createPetInfoWithCompleteOwner();
	 * petInfoRequest.setOwner(null); Optional<Pet> optionalPetNotPresent =
	 * PetFactory.createOptionalPetNotPresent();
	 * 
	 * 
	 * when(petRepository.findById(anyInt())).thenReturn(optionalPetNotPresent);
	 * when(validatorUtil.validateExistance(optionalPetNotPresent, ID_PET_NOT_FOUND,
	 * PET_NOT_FOUND)).thenThrow(EntityNotFound.class);
	 * 
	 * assertThrows(EntityNotFound.class , () ->
	 * petService.updatePet(petInfoRequest,ID_PET_NOT_FOUND)); }
	 */
}
