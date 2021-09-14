package com.veterinary.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.veterinary.dto.AnimalDTO;
import com.veterinary.dto.ResponseDTO;
import com.veterinary.entity.Animal;
import com.veterinary.serviceimp.AnimalServiceImp;

@RunWith(MockitoJUnitRunner.class)
public class AnimalControllerTest {

	@InjectMocks
	private AnimalController animalController;

	@Mock
	private AnimalServiceImp animalService;

	@Test
	public void getAllPetsTest_WhenWeCallGetAllPetsController_Ok() {

		Animal animalResponse = new Animal();
		animalResponse.setId(1L);
		animalResponse.setName("firulais");
		animalResponse.setType("cat");
		animalResponse.setAge(2);

		List<Animal> listOfPets = new ArrayList<Animal>();
		listOfPets.add(animalResponse);

		when(animalService.getAllPets()).thenReturn(listOfPets);

		ResponseEntity<ResponseDTO<Animal>> response = animalController.getAllPets();

		assertNotNull(response);
		assertEquals(response.getStatusCode(), HttpStatus.OK);

		Mockito.verify(animalService, Mockito.times(1)).getAllPets();
	}

	@Test
	public void getPetByIdTest_WhenWeCallGetPetByIdController_Ok() {

		AnimalDTO animalRequest = new AnimalDTO();
		animalRequest.setId(1L);
		animalRequest.setName("firulais");
		animalRequest.setType("cat");
		animalRequest.setAge(2);

		AnimalDTO animalResponse = new AnimalDTO();
		animalResponse.setId(1L);
		animalResponse.setName("firulais");
		animalResponse.setType("cat");
		animalResponse.setAge(2);

		when(animalService.getPetById(animalRequest.getId())).thenReturn(animalResponse);

		ResponseEntity<ResponseDTO<AnimalDTO>> response = animalController.getPet(animalRequest.getId());

		assertNotNull(response);
		assertEquals(response.getBody().getResponse().getId(), animalResponse.getId());

		Mockito.verify(animalService, Mockito.times(1)).getPetById(animalRequest.getId());
	}

	@Test
	public void updatePetTest_WhenWeCallUpdatePetController_Ok() {

		AnimalDTO animalRequest = new AnimalDTO();
		animalRequest.setId(1L);
		animalRequest.setName("firulais");
		animalRequest.setType("cat");
		animalRequest.setAge(2);

		AnimalDTO animalResponse = new AnimalDTO();
		animalResponse.setId(1L);
		animalResponse.setName("firulais");
		animalResponse.setType("cat");
		animalResponse.setAge(2);

		when(animalService.updatePet(animalRequest)).thenReturn(animalResponse);

		ResponseEntity<ResponseDTO<AnimalDTO>> response = animalController.updatePet(animalRequest);

		assertNotNull(response);
		assertEquals(response.getBody().getResponse().getId(), animalRequest.getId());

		Mockito.verify(animalService, Mockito.times(1)).updatePet(animalRequest);

	}

	@Test
	public void savePetTest_WhenWeCallSavePetController_Ok() {
		AnimalDTO animalRequest = new AnimalDTO();
		animalRequest.setId(1L);
		animalRequest.setName("firulais");
		animalRequest.setType("cat");
		animalRequest.setAge(2);

		AnimalDTO animalResponse = new AnimalDTO();
		animalResponse.setId(1L);
		animalResponse.setName("firulais");
		animalResponse.setType("cat");
		animalResponse.setAge(2);

		when(animalService.savePet(animalRequest)).thenReturn(animalResponse);

		ResponseEntity<ResponseDTO<AnimalDTO>> response = animalController.savePet(animalRequest);

		assertNotNull(response);
		assertEquals(response.getBody().getResponse().getId(), animalRequest.getId());

		Mockito.verify(animalService, Mockito.times(1)).savePet(animalRequest);

	}

}
