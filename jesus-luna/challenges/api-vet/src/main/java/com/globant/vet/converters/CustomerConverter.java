package com.globant.vet.converters;


import org.springframework.stereotype.Service;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.CustomerInfoWithPets;
import com.globant.vet.model.Customer;

@Service
public class CustomerConverter {
	
	public CustomerDTO<CustomerInfo> customerInfoToCustomerDTO(int idCustomer,CustomerInfo customerInfo){
		CustomerDTO<CustomerInfo> customerDTO = new CustomerDTO<>();
		customerDTO.setId(idCustomer);
		customerDTO.setCustomer(customerInfo);
		return customerDTO;
	}
	
	public CustomerDTO<CustomerInfoWithPets> customerInfoWithPetsToCustomerDTO(int idCustomer,CustomerInfoWithPets customerInfoWithPets){
		CustomerDTO<CustomerInfoWithPets> customerDTO = new CustomerDTO<>();
		customerDTO.setId(idCustomer);
		customerDTO.setCustomer(customerInfoWithPets);
		return customerDTO;
	}
		
	public CustomerInfo customerToCustomerInfo(Customer customer) {
		return CustomerInfo.builder()
			.name(customer.getName())
			.build();
	}
	
	public Customer customerInfoToCostumerWithId(int customerId, CustomerInfo costumerInfo) {
		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setName(costumerInfo.getName());
		return customer;
	}
	
	public Customer customerInfoToCostumer(CustomerInfo costumerInfo) {
		Customer customer = new Customer();
		customer.setName(costumerInfo.getName());
		return customer;
	}

	
}
