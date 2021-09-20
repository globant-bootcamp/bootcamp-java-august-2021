package com.globant.vet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.CustomerInfoWithPets;
import com.globant.vet.dto.ResponseDTO;

@Validated
public interface CustomerController {
	public ResponseEntity<ResponseDTO<CustomerInfoWithPets>> getCustomer(int customerId);
	public ResponseEntity<ResponseDTO<List<CustomerDTO<CustomerInfoWithPets>>>> getCustomers();
	public ResponseEntity<ResponseDTO<CustomerInfo>> updateCustomer(int customerId,@Valid CustomerInfo newCustomer);
	public ResponseEntity<ResponseDTO<CustomerInfo>> createPet(@Valid  CustomerInfo newCustomer);
	public ResponseEntity<ResponseDTO<String>> deleteCustomer(int customerId);
}
