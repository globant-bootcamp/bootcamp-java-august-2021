package com.globant.vet.controller.impl;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.vet.controller.CustomerController;
import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.CustomerInfoWithPets;
import com.globant.vet.dto.ResponseDTO;

@RestController
@RequestMapping("/customers")
public class CutomerControllerImpl implements CustomerController {

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseDTO<CustomerInfoWithPets>> getCustomer(@PathVariable(name = "id") int customerId) {
		return null;
	}

	@Override
	@GetMapping
	public ResponseEntity<ResponseDTO<List<CustomerDTO<CustomerInfoWithPets>>>> getCustomers() {
		return null;
	}

	@Override
	@PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<CustomerInfo>> updateCustomer(@PathVariable(name = "id") int customerId, @RequestBody CustomerInfo newCustomer) {
		return null;
	}

	@Override
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<CustomerInfo>> createPet(@RequestBody CustomerInfo newCustomer) {
		return null;
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseDTO<String>> deleteCustomer(@PathVariable(name = "id") int customerId) {
		return null;
	}

}
