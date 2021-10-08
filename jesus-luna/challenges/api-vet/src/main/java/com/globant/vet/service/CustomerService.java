package com.globant.vet.service;

import java.util.List;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.CustomerInfoWithPets;

public interface CustomerService {
	public CustomerInfoWithPets getCustomer(int customerId);
	public List<CustomerDTO<CustomerInfoWithPets>> getCustomers();
	public CustomerInfo updateCustomer(int customerId, CustomerInfo newCustomer);
	public CustomerDTO<CustomerInfo> createCustomer(CustomerInfo newCustomer);
	public String deleteCustomer(int customerId);
}
