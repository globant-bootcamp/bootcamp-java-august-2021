package com.globant.vet.converters;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.CustomerInfoWithPets;
import com.globant.vet.model.Customer;
import com.globant.vet.utilities.CustomerFactory;
import static com.globant.vet.utilities.ConstantsTests.ID_CUSTOMER;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class CustomerConverterTest {

	private CustomerConverter customerConverter = new CustomerConverter();

	@Test
	public void convertCustomerInfoWithPetsToCustomerDto() {
		CustomerInfoWithPets customerInfoWithPets = CustomerFactory.createCustomerInfoWithPets();
		CustomerDTO<CustomerInfoWithPets> response = customerConverter.customerInfoWithPetsToCustomerDTO(ID_CUSTOMER,
				customerInfoWithPets);
		assertNotNull(response);
		assertThat(response.getId(), is(ID_CUSTOMER));
		assertEquals(CustomerInfoWithPets.class, response.getCustomer().getClass());
		assertNotNull(response.getCustomer().getName());
		assertNotNull(response.getCustomer().getPets());
		assertFalse(response.getCustomer().getPets().isEmpty());
	}

	@Test
	public void convertCustomerToCustomerInfo() {
		Customer customer = CustomerFactory.createCustomerWitId();
		CustomerInfo response = customerConverter.customerToCustomerInfo(customer);
		assertNotNull(response);
		assertNotNull(response.getName());
		assertThat(response.getName(), is(customer.getName()));
	}

	@Test
	public void convertCustomerInfoToCustomerWithid() {
		CustomerInfo customerInfo = CustomerFactory.createCustomerInfo();
		Customer response = customerConverter.customerInfoToCostumerWithId(ID_CUSTOMER, customerInfo);
		assertNotNull(response);
		assertNotNull(response.getName());
		assertThat(response.getName(), is(customerInfo.getName()));
		assertThat(response.getId(), is(ID_CUSTOMER));
	}

	@Test
	public void convertCustomerInfoToCustomer() {
		CustomerInfo customerInfo = CustomerFactory.createCustomerInfo();
		Customer response = customerConverter.customerInfoToCostumer(customerInfo);
		assertNotNull(response);
		assertNotNull(response.getName());
		assertThat(response.getName(), is(customerInfo.getName()));
		assertThat(response.getId(), is(0));
		assertNull(response.getPets());
	}

	@Test
	public void convertCustomerInfoToCustomerDto() {
		CustomerInfo customerInfo = CustomerFactory.createCustomerInfo();
		CustomerDTO<CustomerInfo> response = customerConverter.customerInfoToCustomerDTO(ID_CUSTOMER, customerInfo);
		assertNotNull(response);
		assertThat(response.getId(), is(ID_CUSTOMER));
		assertEquals(CustomerInfo.class, response.getCustomer().getClass());
	}
}
