package com.globant.vet.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.globant.vet.dto.ResponseDTO.ResponseDTOBuilder;
import com.globant.vet.service.CustomerService;
import com.globant.vet.util.constants.Constants;
import com.globant.vet.util.constants.ResponseConstants;

@RestController
@RequestMapping("/customers")
public class CutomerControllerImpl implements CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseDTO<CustomerInfoWithPets>> getCustomer(@PathVariable(name = "id") int customerId) {
		ResponseDTOBuilder<CustomerInfoWithPets> builder = ResponseDTO.builder();
		ResponseDTO<CustomerInfoWithPets> response = builder
				.content(customerService.getCustomer(customerId))
				.message(String.format(Constants.CUSTOMER_FOUND_WITH_ID, customerId))
				.status(ResponseConstants.SUCCESS)
				.build();
		return ResponseEntity.ok().body(response);
	}

	@Override
	@GetMapping
	public ResponseEntity<ResponseDTO<List<CustomerDTO<CustomerInfoWithPets>>>> getCustomers() {
		ResponseDTOBuilder<List<CustomerDTO<CustomerInfoWithPets>>> builder = ResponseDTO.builder();
		ResponseDTO<List<CustomerDTO<CustomerInfoWithPets>>> response = builder
				.content(customerService.getCustomers())
				.status(ResponseConstants.SUCCESS)
				.message(ResponseConstants.SUCCESS.getDescription())
				.build();
		return ResponseEntity.ok().body(response);
	}

	@Override
	@PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<CustomerInfo>> updateCustomer(@PathVariable(name = "id") int customerId, @RequestBody CustomerInfo newCustomer) {
		return null;
	}

	@Override
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<CustomerInfo>> createPet(@RequestBody CustomerInfo newCustomer) {
		CustomerDTO<CustomerInfo> customerCreatedDto = customerService.createCustomer(newCustomer);
		ResponseDTOBuilder<CustomerInfo> builder = ResponseDTO.builder();
		ResponseDTO<CustomerInfo> response = builder
				.content(customerCreatedDto.getCustomer())
				.status(ResponseConstants.SUCCESS)
				.message(String.format(Constants.CUSTOMER_CREATED_WITH_ID, customerCreatedDto.getId()))
				.build();
		return ResponseEntity.ok().body(response);
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseDTO<String>> deleteCustomer(@PathVariable(name = "id") int customerId) {
		return null;
	}

}
