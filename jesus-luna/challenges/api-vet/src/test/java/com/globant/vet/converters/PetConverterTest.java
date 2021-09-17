package com.globant.vet.converters;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.globant.vet.dto.CustomerDTO;
import com.globant.vet.dto.CustomerInfo;
import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.PetInfoWithCompleteOwner;
import com.globant.vet.model.Customer;
import com.globant.vet.model.Pet;
import com.globant.vet.utilities.CustomerFactory;
import com.globant.vet.utilities.PetFactory;

import static com.globant.vet.utilities.ConstantsTests.ID_PET_1;
import static com.globant.vet.utilities.ConstantsTests.ID_PET_2;
import static com.globant.vet.utilities.ConstantsTests.NAME_PET_2;
import static com.globant.vet.utilities.ConstantsTests.TYPE_PET_2;
import static com.globant.vet.utilities.ConstantsTests.MEETING_PET_2;
import static com.globant.vet.utilities.ConstantsTests.AGE_PET_2;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class PetConverterTest {

	private PetConverter petConverter = new PetConverter();

	@Test
	public void converPetsToPetsInfo() {
		Pet pet1 = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		Pet pet2 = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_2);
		pet2.setAge(AGE_PET_2);
		pet2.setMeeting(MEETING_PET_2);
		pet2.setName(NAME_PET_2);
		pet2.setType(TYPE_PET_2);
		List<PetInfo> response = petConverter.petsToPetsInfo(Arrays.asList(pet1, pet2));
		assertNotNull(response);
		assertThat(response, hasItem(isA(PetInfo.class)));
		assertThat(response, allOf(notNullValue()));
	}

	@Test
	public void converPetsToPetsDtoOfPetInfo() {
		Pet pet1 = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		Pet pet2 = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_2);
		pet2.setAge(AGE_PET_2);
		pet2.setMeeting(MEETING_PET_2);
		pet2.setName(NAME_PET_2);
		pet2.setType(TYPE_PET_2);
		List<PetDTO<PetInfo>> response = petConverter.petsToPetsDtoOfPetInfo(Arrays.asList(pet1, pet2));
		assertNotNull(response);
		assertThat(response, hasItem(isA(PetDTO.class)));
		assertThat(response, allOf(notNullValue()));
		assertFalse(response.isEmpty());
		assertEquals(response.get(0).getId(), pet1.getId());
	}

	@Test
	public void convertPetToPetInfoWithOwner() {
		Pet pet = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		CustomerDTO<CustomerInfo> customerDto = CustomerFactory.createCustomerDtoOfCustomerInfo();
		PetInfoWithCompleteOwner response = petConverter.petToPetInfoWithOwner(pet, customerDto);
		assertNotNull(response);
		assertNotNull(response.getMeeting());
		assertNotNull(response.getName());
		assertNotNull(response.getOwner());
		assertNotNull(response.getType());
		assertEquals(response.getOwner().getCustomer(), customerDto.getCustomer());
		assertEquals(response.getOwner().getId(), customerDto.getId());
		assertEquals(response.getName(), pet.getName());
	}

	@Test
	public void convertPetToPetInfo() {
		Pet pet = PetFactory.createPetWithIdAndOwnerWithId(ID_PET_1);
		PetInfo response = petConverter.petToPetInfo(pet);
		assertNotNull(response);
		assertNotNull(response.getMeeting());
		assertNotNull(response.getName());
		assertNotNull(response.getType());
		assertNotNull(response.getType());
		assertEquals(response.getMeeting(), pet.getMeeting());
		assertEquals(response.getName(), pet.getName());
		assertEquals(response.getAge(), pet.getAge());
	}

	@Test
	public void convertPetInfoWithCompleteOwnerToPetWithOwner() {
		PetInfoWithCompleteOwner pet = PetFactory.createPetInfoWithCompleteOwner();
		Customer customer = CustomerFactory.createCustomerWitId();
		Pet response = petConverter.petInfoWithCompleteOwnertToPetWithOwner(pet, customer);
		assertNotNull(response);
		assertNotNull(response.getMeeting());
		assertNotNull(response.getName());
		assertNotNull(response.getOwner());
		assertNotNull(response.getType());
		assertEquals(response.getOwner(), customer);
		assertEquals(response.getOwner().getId(), customer.getId());
		assertEquals(pet.getMeeting(), response.getMeeting());

	}
}
