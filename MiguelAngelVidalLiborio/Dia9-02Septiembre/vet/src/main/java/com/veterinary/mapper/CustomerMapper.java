package com.veterinary.mapper;

import org.springframework.stereotype.Component;

import com.veterinary.dto.CustomerDTO;
import com.veterinary.entity.Customer;

@Component
public class CustomerMapper {

	public Customer customerDTOToEntity(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setId(customerDTO.getId());
		customer.setFullName(customerDTO.getFullName());
		customer.setAddress(customerDTO.getAddress());
		customer.setPayment(customerDTO.getPayment());
		customer.setAnimal(customerDTO.getAnimal());

		return customer;
	}

	public CustomerDTO entityToCustomerDTO(Customer customer) {
		CustomerDTO customerDto = new CustomerDTO();
		customerDto.setId(customer.getId());
		customerDto.setFullName(customer.getFullName());
		customerDto.setAddress(customer.getAddress());
		customerDto.setPayment(customer.getPayment());
		customerDto.setAnimal(customer.getAnimal());
		return customerDto;
	}
}
