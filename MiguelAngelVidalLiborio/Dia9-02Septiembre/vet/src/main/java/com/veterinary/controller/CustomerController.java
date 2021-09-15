package com.veterinary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinary.dto.CustomerDTO;
import com.veterinary.dto.ResponseDTO;
import com.veterinary.entity.Customer;
import com.veterinary.service.CustomerService;
import com.veterinary.utils.Constants;

@RestController
@RequestMapping("/api/vet/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/")
	public ResponseEntity<ResponseDTO<CustomerDTO>> saveCustomer(@RequestBody CustomerDTO customer) {
		ResponseDTO<CustomerDTO> response = new ResponseDTO<CustomerDTO>(Constants.ENTITY_CREATED,
				customerService.saveCustomer(customer));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<ResponseDTO<Customer>> getCustomers() {
		ResponseDTO<Customer> response = new ResponseDTO<Customer>(Constants.ENTITY_GET_REQUEST,
				customerService.getAllCustomers());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<CustomerDTO>> getCustomerById(@PathVariable long id) {
		ResponseDTO<CustomerDTO> response = new ResponseDTO<CustomerDTO>(Constants.ENTITY_GET_REQUEST,
				customerService.getCustomerById(id));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/{customerId}/pet/{petId}")
	public ResponseEntity<ResponseDTO<CustomerDTO>> assignPetToCustomer(@PathVariable("customerId") long customerId,
			@PathVariable("petId") long petId) {
		ResponseDTO<CustomerDTO> response = new ResponseDTO<CustomerDTO>(Constants.ENTITY_UPDATED,
				customerService.assignPetToCustomer(customerId, petId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO<CustomerDTO>> deleteCustomer(@PathVariable long id) {
		ResponseDTO<CustomerDTO> response = new ResponseDTO<CustomerDTO>(Constants.ENTITY_DELETED,
				customerService.deleteCustomerById(id));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
