package com.veterinary.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinary.dto.CustomerDTO;
import com.veterinary.entity.Animal;
import com.veterinary.entity.Customer;
import com.veterinary.exception.EmptyInputException;
import com.veterinary.exception.ModelNotFoundException;
import com.veterinary.mapper.CustomerMapper;
import com.veterinary.repository.AnimalRepository;
import com.veterinary.repository.CustomerRepository;
import com.veterinary.service.CustomerService;
import com.veterinary.utils.Constants;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public CustomerDTO saveCustomer(CustomerDTO customer) {
		validationData(customer);

		CustomerDTO response = customerMapper
				.entityToCustomerDTO(customerRepository.save(customerMapper.customerDTOToEntity(customer)));
		return response;
	}

	public void validationData(CustomerDTO customer) {
		if (customer.getFullName().isEmpty() || customer.getAddress().isEmpty() || customer.getPayment() < 0) {
			throw new EmptyInputException(Constants.INPUT_FROM_USER_NOT_VALID);
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public CustomerDTO getCustomerById(long customerId) {

		long getCustomerIdFromUserInput = customerId;
		Customer customer = customerRepository.findById(getCustomerIdFromUserInput)
				.orElseThrow(() -> new ModelNotFoundException(Constants.ENTITY_CUSTOMER_NOT_FOUND));

		CustomerDTO customerDto = customerMapper.entityToCustomerDTO(customer);
		return customerDto;
	}

	@Override
	public CustomerDTO assignPetToCustomer(long customerId, long petId) {
		Customer customer = customerRepository.findById(customerId).get();
		Animal animal = animalRepository.findById(petId).get();

		customer.setAnimal(animal);
		CustomerDTO customerDto = customerMapper.entityToCustomerDTO(customerRepository.save(customer));
		return customerDto;
	}

	@Override
	public CustomerDTO deleteCustomerById(long customerId) {

		CustomerDTO customerById = getCustomerById(customerId);
		customerRepository.delete(customerMapper.customerDTOToEntity(customerById));
		return customerById;
	}

}
