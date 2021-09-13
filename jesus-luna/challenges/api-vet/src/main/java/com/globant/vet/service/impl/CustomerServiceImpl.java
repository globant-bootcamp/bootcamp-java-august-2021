package com.globant.vet.service.impl;

import java.util.List;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.CustomerInfoWithPets;
import com.globant.vet.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerInfoWithPets getCustomer(int customerId) {
		return null;
	}

	@Override
	public List<CustomerDTO<CustomerInfoWithPets>> getCustomers() {
		return null;
	}

	@Override
	public CustomerInfo updateCustomer(int customerId, CustomerInfo newCustomer) {
		return null;
	}

	@Override
	public CustomerInfo createCustomer(CustomerInfo newCustomer) {
		return null;
	}

	@Override
	public String deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
