package com.globant.vet.controller;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.globant.vet.controller.impl.CutomerControllerImpl;
import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.CustomerInfoWithPets;
import com.globant.vet.dto.ResponseDTO;
import com.globant.vet.exception.EntityNotFound;
import com.globant.vet.service.impl.CustomerServiceImpl;
import com.globant.vet.utilities.CustomerFactory;
import static com.globant.vet.utilities.ConstantsTests.CUSTOMER_CREATED_WITH_ID;
import static com.globant.vet.utilities.ConstantsTests.ID_CUSTOMER_NOT_FOUND;
import static com.globant.vet.utilities.ConstantsTests.CUSTOMER_DELETED;
import static com.globant.vet.utilities.ConstantsTests.STATUS_SUCCESS;
import static com.globant.vet.utilities.ConstantsTests.CUSTOMER_FOUND_WITH_ID;
import static com.globant.vet.utilities.ConstantsTests.CUSTOMER_UPDATE;
import static com.globant.vet.utilities.ConstantsTests.ID_CUSTOMER;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerImplTest {

	@InjectMocks
	private CutomerControllerImpl customerController;

	@Mock
	private CustomerServiceImpl customerService;

	@Test
	public void getAllCustomersTest() {
		CustomerInfoWithPets customerInfoWithPets1 = CustomerFactory.createCustomerInfoWithPets();
		List<CustomerDTO<CustomerInfoWithPets>> listOfCustomerDtos = Arrays
				.asList(new CustomerDTO<>(ID_CUSTOMER, customerInfoWithPets1));
		when(customerService.getCustomers()).thenReturn(listOfCustomerDtos);
		ResponseEntity<ResponseDTO<List<CustomerDTO<CustomerInfoWithPets>>>> response = customerController.getCustomers();
		assertNotNull(response);
		assertThat(response.getStatusCodeValue(), is(200));
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getContent());
		assertEquals(STATUS_SUCCESS, response.getBody().getStatus().name());
		assertFalse(response.getBody().getContent().isEmpty());
	}

	@Test
	public void getCustomerTest() {
		CustomerInfoWithPets createCustomerInfoWithPets = CustomerFactory.createCustomerInfoWithPets();
		when(customerService.getCustomer(ID_CUSTOMER)).thenReturn(createCustomerInfoWithPets);
		ResponseEntity<ResponseDTO<CustomerInfoWithPets>> response = customerController.getCustomer(ID_CUSTOMER);
		assertNotNull(response);
		assertThat(response.getStatusCodeValue(), is(200));
		assertNotNull(response.getBody());
		assertEquals(STATUS_SUCCESS, response.getBody().getStatus().name());
		assertEquals(String.format(CUSTOMER_FOUND_WITH_ID, ID_CUSTOMER), response.getBody().getMessage());
	}

	@Test
	public void getCustomerTestFail() {
		when(customerService.getCustomer(ID_CUSTOMER_NOT_FOUND)).thenThrow(EntityNotFound.class);
		assertThrows(EntityNotFound.class, () -> customerController.getCustomer(ID_CUSTOMER_NOT_FOUND));
	}

	@Test
	public void createCustomerTest() {
		CustomerInfo customerRq = CustomerFactory.createCustomerInfo();
		CustomerDTO<CustomerInfo> customerCreatedDto = CustomerFactory.createCustomerDtoOfCustomerInfo();
		when(customerService.createCustomer(customerRq)).thenReturn(customerCreatedDto);
		ResponseEntity<ResponseDTO<CustomerInfo>> response = customerController.createPet(customerRq);
		assertNotNull(response);
		assertThat(response.getStatusCodeValue(), is(200));
		assertNotNull(response.getBody());
		assertEquals(STATUS_SUCCESS, response.getBody().getStatus().name());
		assertEquals(String.format(CUSTOMER_CREATED_WITH_ID, ID_CUSTOMER), response.getBody().getMessage());
	}

	@Test
	public void updateCustomerTest() {
		CustomerInfo newCustomerInfo = CustomerFactory.createCustomerInfo();
		CustomerInfo customerInfoUpdated = CustomerFactory.createCustomerInfo();
		when(customerService.updateCustomer(ID_CUSTOMER, newCustomerInfo)).thenReturn(customerInfoUpdated);
		ResponseEntity<ResponseDTO<CustomerInfo>> response = customerController.updateCustomer(ID_CUSTOMER,
				newCustomerInfo);
		assertNotNull(response);
		assertThat(response.getStatusCodeValue(), is(200));
		assertNotNull(response.getBody());
		assertEquals(STATUS_SUCCESS, response.getBody().getStatus().name());
		assertEquals(CUSTOMER_UPDATE, response.getBody().getMessage());
	}

	@Test
	public void deleteCustomerTest() {
		when(customerService.deleteCustomer(ID_CUSTOMER)).thenReturn(CUSTOMER_DELETED);
		ResponseEntity<ResponseDTO<String>> response = customerController.deleteCustomer(ID_CUSTOMER);
		assertNotNull(response);
		assertThat(response.getStatusCodeValue(), is(200));
		assertNotNull(response.getBody());
		assertEquals(STATUS_SUCCESS, response.getBody().getStatus().name());
	}
}
