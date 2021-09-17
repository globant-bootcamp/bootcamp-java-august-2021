package com.globant.vet.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.vet.converters.CustomerConverter;
import com.globant.vet.converters.PetConverter;
import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.CustomerInfoWithPets;
import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.model.Customer;
import com.globant.vet.repository.CustomerRepository;
import com.globant.vet.service.CustomerService;
import com.globant.vet.util.GeneralUtil;
import com.globant.vet.util.ValidatorUtils;
import com.globant.vet.util.constants.Constants;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private ValidatorUtils validatorUtil;
	
	@Autowired
	private GeneralUtil generalUtil;
	
	@Autowired
	private PetConverter petConverter;
	
	@Autowired
	private CustomerConverter customerConverter;
	
	private CustomerInfoWithPets getCustomerWithPets(Customer customer) {
		List<PetDTO<PetInfo>> petsToPetsDtoOfPetInfo = petConverter.petsToPetsDtoOfPetInfo(customer.getPets());
		CustomerInfoWithPets customerInfoWithPets = new CustomerInfoWithPets(petsToPetsDtoOfPetInfo);
		customerInfoWithPets.setName(customer.getName());
		return customerInfoWithPets;
	}

	@Override
	public CustomerInfoWithPets getCustomer(int customerId) {
		Optional<Customer> findById = customerRepo.findById(customerId);
		Customer customer = validatorUtil.validateExistance(findById, customerId, Constants.CUSTOMER_NOT_FOUND);
		return getCustomerWithPets(customer);
	}

	@Override
	public List<CustomerDTO<CustomerInfoWithPets>> getCustomers() {
		List<Customer> customers = customerRepo.findAll();
		return customers.stream()
				.map(customer->customerConverter.customerInfoWithPetsToCustomerDTO(customer.getId(), getCustomerWithPets(customer)))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerInfo updateCustomer(int customerId, CustomerInfo newCustomer) {
		Optional<Customer> findById = customerRepo.findById(customerId);
		Customer customerDb = validatorUtil.validateExistance(findById, customerId, Constants.CUSTOMER_NOT_FOUND);
		Customer customerOverrided = generalUtil.overrideCustomerWithCustomerInfo(customerDb, newCustomer);
		Customer updatedCustomer = customerRepo.save(customerOverrided);
		return customerConverter.customerToCustomerInfo(updatedCustomer);
	}

	@Override
	public CustomerDTO<CustomerInfo> createCustomer(CustomerInfo newCustomer) {
		Customer customerStored = customerRepo.save(customerConverter.customerInfoToCostumer(newCustomer));
		return new CustomerDTO<>(customerStored.getId(), customerConverter.customerToCustomerInfo(customerStored));
	}

	@Override
	public String deleteCustomer(int customerId) {
		Optional<Customer> findById = customerRepo.findById(customerId);
		validatorUtil.validateExistance(findById, customerId, Constants.CUSTOMER_NOT_FOUND);
		customerRepo.deleteById(customerId);
		return Constants.CUSTOMER_DELETED;
	}

}
