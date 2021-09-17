package com.globant.vet.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;
import com.globant.vet.utilities.CustomerFactory;
import com.globant.vet.utilities.PetFactory;

import static com.globant.vet.utilities.ConstantsTests.ID_PET_1;
import static com.globant.vet.utilities.ConstantsTests.NAME_CUSTOMER_2;
import static com.globant.vet.utilities.ConstantsTests.NAME_PET_2;
import static com.globant.vet.utilities.ConstantsTests.MEETING_PET_2;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GeneralUtilTest {

	private GeneralUtil generalUtil = new GeneralUtil();

	@Test
	public void overridePartialPetWithPetInfoSuccess() {
		Pet originalPet = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		PetInfo petRq = PetFactory.createPetInfoDefault();
		petRq.setName(NAME_PET_2);
		petRq.setMeeting(MEETING_PET_2);

		Pet petOverrided = generalUtil.overridePetWithPetInfo(originalPet, petRq);

		assertNotNull(petOverrided);
		assertThat(petOverrided.getName(), is(petRq.getName()));
		assertThat(petOverrided.getMeeting(), is(petRq.getMeeting()));
		assertThat(petOverrided.getId(), is(ID_PET_1));
		assertThat(petOverrided.getType(), is(originalPet.getType()));
	}

	@Test
	public void overrideCompleteCustomerWithoutPetsSuccess() {
		Customer originalCustomer = CustomerFactory.createCustomerWitId();
		CustomerInfo customerInfoRq = CustomerFactory.createCustomerInfo();
		customerInfoRq.setName(NAME_CUSTOMER_2);

		Customer customerOverrided = generalUtil.overrideCustomerWithCustomerInfo(originalCustomer, customerInfoRq);

		assertNotNull(customerOverrided);
		assertThat(customerOverrided.getName(), is(NAME_CUSTOMER_2));
		assertThat(customerOverrided.getPets(), equalToObject(originalCustomer.getPets()));
	}
}
