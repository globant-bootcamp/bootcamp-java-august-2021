package com.veterinary.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.veterinary.dto.CustomerDTO;
import com.veterinary.entity.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerMapperTest {

	@Mock
	private CustomerMapper customerMapper;

	@Test
	public void customerMapperTest_WhenCustomerEntityToCustomerDTO_Ok() {

		Customer customerEntity = new Customer();
		customerEntity.setId(1L);
		customerEntity.setFullName("Leo Messi");
		customerEntity.setAddress("Paris");
		customerEntity.setPayment(800);

		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(1L);
		customerDTO.setFullName("Leo Messi");
		customerDTO.setAddress("Paris");
		customerDTO.setPayment(800);

		Mockito.when(customerMapper.entityToCustomerDTO(customerEntity)).thenReturn(customerDTO);

		CustomerDTO response = customerMapper.entityToCustomerDTO(customerEntity);

		assertNotNull(response);
		assertEquals(response, customerDTO);
		assertEquals(response.getId(), customerDTO.getId());

		Mockito.verify(customerMapper, Mockito.times(1)).entityToCustomerDTO(customerEntity);
	}

	@Test
	public void customerMapperTest_WhenCustomerDTOToCustomerEntity_Ok() {

		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(1L);
		customerDTO.setFullName("Leo Messi");
		customerDTO.setAddress("Paris");
		customerDTO.setPayment(800);

		Customer customerEntity = new Customer();
		customerEntity.setId(1L);
		customerEntity.setFullName("Leo Messi");
		customerEntity.setAddress("Paris");
		customerEntity.setPayment(800);

		Mockito.when(customerMapper.customerDTOToEntity(customerDTO)).thenReturn(customerEntity);

		Customer response = customerMapper.customerDTOToEntity(customerDTO);

		assertNotNull(response);
		assertEquals(response, customerEntity);
		assertEquals(response.getId(), customerEntity.getId());

		Mockito.verify(customerMapper, Mockito.times(1)).customerDTOToEntity(customerDTO);
	}

}
