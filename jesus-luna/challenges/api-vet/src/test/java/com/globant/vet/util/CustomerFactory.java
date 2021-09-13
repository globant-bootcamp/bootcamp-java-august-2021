package com.globant.vet.util;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.model.Customer;

public class CustomerFactory {
	
	public static Customer createCustomerWitId() {
		Customer customer = new Customer();
		customer.setId(ConstantsTests.ID_CUSTOMER);
		customer.setName(ConstantsTests.NAME_CUSTOMER);
		return customer;
	}
	
	public static CustomerInfo createCustomerInfo() {
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setName(ConstantsTests.NAME_CUSTOMER);
		return customerInfo;
	}
	
	public static CustomerDTO<CustomerInfo> createCustomerDtoOfCustomerInfo(){
		CustomerInfo customerInfo = createCustomerInfo();
		return new CustomerDTO<CustomerInfo>(ConstantsTests.ID_CUSTOMER, customerInfo);
	}
}
