package com.globant.vet.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.globant.vet.converters.CustomerConverter;
import com.globant.vet.converters.PetConverter;
import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.CustomerInfoWithPets;
import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.exception.EntityNotFound;
import com.globant.vet.model.Customer;
import com.globant.vet.repository.CustomerRepository;
import com.globant.vet.service.impl.CustomerServiceImpl;
import com.globant.vet.util.GeneralUtil;
import com.globant.vet.util.ValidatorUtils;
import com.globant.vet.utilities.CustomerFactory;
import com.globant.vet.utilities.PetFactory;

import static com.globant.vet.utilities.ConstantsTests.CUSTOMER_DELETED;
import static com.globant.vet.utilities.ConstantsTests.CUSTOMER_NOT_FOUND;
import static com.globant.vet.utilities.ConstantsTests.ID_CUSTOMER;
import static com.globant.vet.utilities.ConstantsTests.ID_CUSTOMER_2;
import static com.globant.vet.utilities.ConstantsTests.ID_CUSTOMER_NOT_FOUND;
import static com.globant.vet.utilities.ConstantsTests.ID_PET_3;
import static com.globant.vet.utilities.ConstantsTests.ID_PET_4;
import static com.globant.vet.utilities.ConstantsTests.NAME_CUSTOMER;
import static com.globant.vet.utilities.ConstantsTests.NAME_CUSTOMER_2;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerServiceImpl customerService;

	@Mock
	private CustomerRepository customerRepo;

	@Mock
	private ValidatorUtils validatorUtil;

	@Mock
	private GeneralUtil generalUtil;

	@Mock
	private PetConverter petConverter;

	@Mock
	private CustomerConverter customerConverter;

	@Test
	public void getACustomerWithPetsSuccess() {
		Customer customerWithIdAndListPets = CustomerFactory.createCustomerWithIdAndListPetsWithIds();
		Optional<Customer> findCustomerByIdPresent = Optional.of(customerWithIdAndListPets);
		List<PetDTO<PetInfo>> petsDtosOfPetInfo = PetFactory.createListOfPetDtosOfPetInfo();

		when(customerRepo.findById(ID_CUSTOMER)).thenReturn(findCustomerByIdPresent);
		when(validatorUtil.validateExistance(findCustomerByIdPresent, ID_CUSTOMER, CUSTOMER_NOT_FOUND))
				.thenReturn(customerWithIdAndListPets);
		when(petConverter.petsToPetsDtoOfPetInfo(customerWithIdAndListPets.getPets())).thenReturn(petsDtosOfPetInfo);

		CustomerInfoWithPets response = customerService.getCustomer(ID_CUSTOMER);

		assertNotNull(response);
		assertThat(response.getName(), is(customerWithIdAndListPets.getName()));
		assertThat(response.getName(), notNullValue());
		assertNotNull(response.getPets());
		assertFalse(response.getPets().isEmpty());
		assertThat(response.getPets(), hasItems(isA(PetDTO.class)));
	}

	@Test
	public void getACustomerWithPetsFailureNotPresent() {
		Optional<Customer> optionalCustomerNotPresent = CustomerFactory.createOptionalCustomerNotPresent();

		when(customerRepo.findById(ID_CUSTOMER_NOT_FOUND)).thenReturn(optionalCustomerNotPresent);
		when(validatorUtil.validateExistance(optionalCustomerNotPresent, ID_CUSTOMER_NOT_FOUND, CUSTOMER_NOT_FOUND))
				.thenThrow(EntityNotFound.class);

		assertThrows(EntityNotFound.class, () -> customerService.getCustomer(ID_CUSTOMER_NOT_FOUND));
	}

	@Test
	public void getAllCustomers() {
		Customer customer1 = CustomerFactory.createCustomerWithIdAndListPetsWithIds();
		Customer customer2 = CustomerFactory.createCustomerWithIdAndListPetsWithIds();
		customer2.getPets().get(0).setId(ID_PET_3);
		customer2.getPets().get(1).setId(ID_PET_4);
		List<Customer> customersDb = Arrays.asList(customer1, customer2);

		CustomerInfoWithPets customer2WithPets = CustomerFactory.createCustomerInfoWithPets();
		List<PetDTO<PetInfo>> petsOfCustomerDto2 = PetFactory.createListOfPetDtosOfPetInfo();
		petsOfCustomerDto2.get(0).setId(ID_PET_3);
		petsOfCustomerDto2.get(0).setId(ID_PET_4);
		customer2WithPets.setName(NAME_CUSTOMER_2);
		customer2WithPets.setPets(petsOfCustomerDto2);

		CustomerDTO<CustomerInfoWithPets> customerDto2 = new CustomerDTO<CustomerInfoWithPets>(ID_CUSTOMER_2,
				customer2WithPets);

		when(customerRepo.findAll()).thenReturn(customersDb);
		when(customerConverter.customerInfoWithPetsToCustomerDTO(anyInt(), any(CustomerInfoWithPets.class)))
				.thenReturn(customerDto2);

		List<CustomerDTO<CustomerInfoWithPets>> response = customerService.getCustomers();

		assertNotNull(response);
		assertFalse(response.isEmpty());
		assertThat(response.size(), is(2));
		assertThat(response.get(1).getId(), is(ID_CUSTOMER_2));
	}

	@Test
	public void updateCustomerSuccess() {
		Optional<Customer> optionalCustomerPresent = CustomerFactory.createOptionalCustomerPresent();
		Customer customerFromDb = CustomerFactory.createCustomerWitId();
		Customer customerOverrided = CustomerFactory.createCustomerWitId();
		Customer customerUpdated = CustomerFactory.createCustomerWitId();
		CustomerInfo customerInfo = CustomerFactory.createCustomerInfo();
		CustomerInfo customerInfoRq = CustomerFactory.createCustomerInfo();

		when(customerRepo.findById(ID_CUSTOMER)).thenReturn(optionalCustomerPresent);
		when(validatorUtil.validateExistance(optionalCustomerPresent, ID_CUSTOMER, CUSTOMER_NOT_FOUND))
				.thenReturn(customerFromDb);
		when(generalUtil.overrideCustomerWithCustomerInfo(customerFromDb, customerInfo)).thenReturn(customerOverrided);
		when(customerRepo.save(customerOverrided)).thenReturn(customerUpdated);
		when(customerConverter.customerToCustomerInfo(customerUpdated)).thenReturn(customerInfo);

		CustomerInfo response = customerService.updateCustomer(ID_CUSTOMER, customerInfoRq);

		assertNotNull(response);
		assertThat(response.getName(), is(NAME_CUSTOMER));
		assertThat(response.getName(), is(customerFromDb.getName()));
		assertThat(response.getName(), is(customerUpdated.getName()));
	}

	@Test
	public void updateCustomerFailure() {
		Optional<Customer> optionalCustomerNoPresent = CustomerFactory.createOptionalCustomerNotPresent();
		CustomerInfo customerInfoRq = CustomerFactory.createCustomerInfo();

		when(customerRepo.findById(ID_CUSTOMER_NOT_FOUND)).thenReturn(optionalCustomerNoPresent);
		when(validatorUtil.validateExistance(optionalCustomerNoPresent, ID_CUSTOMER_NOT_FOUND, CUSTOMER_NOT_FOUND))
				.thenThrow(EntityNotFound.class);

		assertThrows(EntityNotFound.class, () -> customerService.updateCustomer(ID_CUSTOMER_NOT_FOUND, customerInfoRq));
	}

	@Test
	public void deleteCustomerFailure() {
		Optional<Customer> optionalCustomerNoPresent = CustomerFactory.createOptionalCustomerNotPresent();

		when(customerRepo.findById(ID_CUSTOMER_NOT_FOUND)).thenReturn(optionalCustomerNoPresent);
		when(validatorUtil.validateExistance(optionalCustomerNoPresent, ID_CUSTOMER_NOT_FOUND, CUSTOMER_NOT_FOUND))
				.thenThrow(EntityNotFound.class);

		assertThrows(EntityNotFound.class, () -> customerService.deleteCustomer(ID_CUSTOMER_NOT_FOUND));
	}

	@Test
	public void deleteCustomerSuccess() {
		Optional<Customer> optionalCustomerPresent = CustomerFactory.createOptionalCustomerPresent();
		Customer customerFromDb = CustomerFactory.createCustomerWitId();

		when(customerRepo.findById(ID_CUSTOMER)).thenReturn(optionalCustomerPresent);
		when(validatorUtil.validateExistance(optionalCustomerPresent, ID_CUSTOMER, CUSTOMER_NOT_FOUND))
				.thenReturn(customerFromDb);

		String response = customerService.deleteCustomer(ID_CUSTOMER);

		assertNotNull(response);
		assertThat(response, is(CUSTOMER_DELETED));
	}

	@Test
	public void createCustomerSuccess() {
		CustomerInfo customerInfoRqs = CustomerFactory.createCustomerInfo();
		Customer customerToStore = CustomerFactory.createCustomerWitId();
		customerToStore.setId(0);
		Customer customerStored = CustomerFactory.createCustomerWitId();
		CustomerInfo customerInfoStored = CustomerFactory.createCustomerInfo();

		when(customerConverter.customerInfoToCostumer(customerInfoRqs)).thenReturn(customerToStore);
		when(customerRepo.save(customerToStore)).thenReturn(customerStored);
		when(customerConverter.customerToCustomerInfo(customerStored)).thenReturn(customerInfoStored);

		CustomerDTO<CustomerInfo> response = customerService.createCustomer(customerInfoRqs);

		assertNotNull(response);
		assertThat(response.getId(), is(ID_CUSTOMER));
		assertNotNull(response.getCustomer());
	}
}
