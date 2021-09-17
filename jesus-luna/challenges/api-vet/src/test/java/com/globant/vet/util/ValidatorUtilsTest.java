package com.globant.vet.util;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.exception.EntityNotFound;
import com.globant.vet.exception.InputMismatchException;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;
import com.globant.vet.utilities.CustomerFactory;
import com.globant.vet.utilities.PetFactory;

import static com.globant.vet.utilities.ConstantsTests.CUSTOMER_NOT_FOUND;
import static com.globant.vet.utilities.ConstantsTests.ID_CUSTOMER;
import static com.globant.vet.utilities.ConstantsTests.ID_CUSTOMER_2;
import static com.globant.vet.utilities.ConstantsTests.ID_PET_4;
import static com.globant.vet.utilities.ConstantsTests.ID_PET_1;
import static com.globant.vet.utilities.ConstantsTests.PET_NOT_FOUND;
import static com.globant.vet.utilities.ConstantsTests.NAME_CUSTOMER_2;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class ValidatorUtilsTest {

	private ValidatorUtils validatorUtil = new ValidatorUtils();

	@Test
	public void validateCustomerRqDataWithCustomerExistingInDbSuccess() {
		Customer customerInDb = CustomerFactory.createCustomerWithIdAndListPetsWithIds();
		CustomerInfo customerInfoRq = CustomerFactory.createCustomerInfo();

		Customer response = validatorUtil.validateCustomerRqWithCustomerDB(customerInDb, customerInfoRq);

		assertNotNull(response);
		assertThat(response.getName(), is(customerInDb.getName()));
		assertThat(response.getId(), is(customerInDb.getId()));
		assertThat(response.getName(), notNullValue());
		assertNotNull(response.getPets());
		assertFalse(response.getPets().isEmpty());
		assertThat(response.getPets(), hasItems(isA(Pet.class)));
	}

	@Test
	public void validateCustomerRqDataWithCustomerExistingInDbFailDataMismatch() {
		Customer customerInDb = CustomerFactory.createCustomerWitId();
		CustomerInfo customerInfoRq = CustomerFactory.createCustomerInfo();
		customerInfoRq.setName(NAME_CUSTOMER_2);

		assertThrows(InputMismatchException.class,
				() -> validatorUtil.validateCustomerRqWithCustomerDB(customerInDb, customerInfoRq));
	}

	@Test
	public void validateOptionalPetIsPresent() {
		Optional<Pet> optionalPetPresent = PetFactory.createOptionalPetPresent();
		Pet response = validatorUtil.validateExistance(optionalPetPresent, ID_PET_1, PET_NOT_FOUND);
		assertNotNull(response);
		assertThat(response.getId(), is(ID_PET_1));
	}

	@Test
	public void validateOptionalPetNotPresent() {
		Optional<Pet> optionalPetNotPresent = PetFactory.createOptionalPetNotPresent();
		assertThrows(EntityNotFound.class,
				() -> validatorUtil.validateExistance(optionalPetNotPresent, ID_PET_4, PET_NOT_FOUND));
	}

	@Test
	public void validateOptionalCustomerIsPresent() {
		Optional<Customer> optionalCustomerPresent = CustomerFactory.createOptionalCustomerPresent();
		Customer response = validatorUtil.validateExistance(optionalCustomerPresent, ID_CUSTOMER, CUSTOMER_NOT_FOUND);
		assertNotNull(response);
		assertThat(response.getId(), is(ID_CUSTOMER));
	}

	@Test
	public void validateOptionalCustomerNotPresent() {
		Optional<Customer> optionalCustomerNotPresent = CustomerFactory.createOptionalCustomerNotPresent();
		assertThrows(EntityNotFound.class,
				() -> validatorUtil.validateExistance(optionalCustomerNotPresent, ID_CUSTOMER_2, CUSTOMER_NOT_FOUND));
	}
}
