package com.veterinary.service;

import java.util.List;

import com.veterinary.dto.CustomerDTO;
import com.veterinary.entity.Customer;

public interface CustomerService {

	CustomerDTO saveCustomer(CustomerDTO customer);

	List<Customer> getAllCustomers();

	CustomerDTO getCustomerById(long customerId);

	CustomerDTO assignPetToCustomer(long customerId, long petId);

	CustomerDTO deleteCustomerById(long customerId);
}
