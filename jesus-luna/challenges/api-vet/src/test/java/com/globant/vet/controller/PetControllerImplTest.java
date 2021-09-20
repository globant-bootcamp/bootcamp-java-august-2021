package com.globant.vet.controller;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.globant.vet.controller.impl.VetControllerImpl;
import com.globant.vet.dto.PetDTO;
import com.globant.vet.dto.PetInfo;
import com.globant.vet.dto.PetInfoWithCompleteOwner;
import com.globant.vet.dto.ResponseDTO;
import com.globant.vet.exception.EntityNotFound;
import com.globant.vet.service.impl.PetServiceImpl;
import com.globant.vet.utilities.PetFactory;

import static com.globant.vet.utilities.ConstantsTests.PET_CREATED_WITH_ID;
import static com.globant.vet.utilities.ConstantsTests.PET_FOUND_WITH_ID;
import static com.globant.vet.utilities.ConstantsTests.ID_PET_1;
import static com.globant.vet.utilities.ConstantsTests.PET_UPDATE;
import static com.globant.vet.utilities.ConstantsTests.ID_PET_NOT_FOUND;
import static com.globant.vet.utilities.ConstantsTests.STATUS_SUCCESS;
import static com.globant.vet.utilities.ConstantsTests.PET_DELETED;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetControllerImplTest {

	@InjectMocks
	private VetControllerImpl petController;

	@Mock
	private PetServiceImpl petService;

	@Test
	public void getInfoPetTest() {
		PetInfoWithCompleteOwner petInfoWithCompleteOwner = PetFactory.createPetInfoWithCompleteOwner();
		when(petService.getPetById(ID_PET_1)).thenReturn(petInfoWithCompleteOwner);
		ResponseEntity<ResponseDTO<PetInfoWithCompleteOwner>> response = petController.getInfoPet(ID_PET_1);
		assertNotNull(response);
		assertThat(response.getStatusCodeValue(), is(200));
		assertThat(response.getBody().getMessage(), is(String.format(PET_FOUND_WITH_ID, ID_PET_1)));
		assertNotNull(response.getBody());
		assertEquals(STATUS_SUCCESS, response.getBody().getStatus().name());
	}

	@Test
	public void getInfoPetTestFail() {
		when(petService.getPetById(ID_PET_NOT_FOUND)).thenThrow(EntityNotFound.class);
		assertThrows(EntityNotFound.class, () -> petController.getInfoPet(ID_PET_NOT_FOUND));
	}

	@Test
	public void getPets() {
		PetInfoWithCompleteOwner petInfoWithCompleteOwner = PetFactory.createPetInfoWithCompleteOwner();
		List<PetDTO<PetInfoWithCompleteOwner>> listOfPetDtosOfPetInfoWithCompleteOwner = Arrays
				.asList(new PetDTO<>(ID_PET_1, petInfoWithCompleteOwner));
		when(petService.getAllPets()).thenReturn(listOfPetDtosOfPetInfoWithCompleteOwner);
		ResponseEntity<ResponseDTO<List<PetDTO<PetInfoWithCompleteOwner>>>> response = petController.getPets();
		assertNotNull(response);
		assertThat(response.getStatusCodeValue(), is(200));
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getContent());
		assertFalse(response.getBody().getContent().isEmpty());
		assertEquals(STATUS_SUCCESS, response.getBody().getStatus().name());
	}

	@Test
	public void createPet() {
		PetInfoWithCompleteOwner newPetRq = PetFactory.createPetInfoWithCompleteOwner();
		PetInfoWithCompleteOwner petInfoWithOwnerCreated = PetFactory.createPetInfoWithCompleteOwner();
		PetDTO<PetInfoWithCompleteOwner> petDtoCreated = new PetDTO<>(ID_PET_1, petInfoWithOwnerCreated);
		when(petService.createPet(newPetRq)).thenReturn(petDtoCreated);
		ResponseEntity<ResponseDTO<PetInfoWithCompleteOwner>> response = petController.createPet(newPetRq);
		assertNotNull(response);
		assertThat(response.getStatusCodeValue(), is(200));
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getContent());
		assertEquals(STATUS_SUCCESS, response.getBody().getStatus().name());
		assertEquals(String.format(PET_CREATED_WITH_ID, ID_PET_1), response.getBody().getMessage());
	}

	@Test
	public void updatePet() {
		PetInfo petInfoRqs = PetFactory.createPetInfoDefault();
		PetInfo updatedPetInfo = PetFactory.createPetInfoDefault();
		when(petService.updatePet(petInfoRqs, ID_PET_1)).thenReturn(updatedPetInfo);
		ResponseEntity<ResponseDTO<PetInfo>> response = petController.updatePet(ID_PET_1, petInfoRqs);
		assertNotNull(response);
		assertThat(response.getStatusCodeValue(), is(200));
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getContent());
		assertEquals(STATUS_SUCCESS, response.getBody().getStatus().name());
		assertEquals(PET_UPDATE, response.getBody().getMessage());
	}

	@Test
	public void deletePet() {
		when(petService.deletePetById(ID_PET_1)).thenReturn(PET_DELETED);
		ResponseEntity<ResponseDTO<String>> response = petController.deletePet(ID_PET_1);
		assertNotNull(response);
		assertThat(response.getStatusCodeValue(), is(200));
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getContent());
		assertEquals(STATUS_SUCCESS, response.getBody().getStatus().name());
		assertEquals(PET_DELETED, response.getBody().getContent());
	}
}
