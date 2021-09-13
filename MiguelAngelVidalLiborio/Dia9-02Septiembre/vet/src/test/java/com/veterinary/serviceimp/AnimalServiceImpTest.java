package com.veterinary.serviceimp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.veterinary.dto.AnimalDTO;
import com.veterinary.entity.Animal;
import com.veterinary.mapper.AnimalMapper;
import com.veterinary.repository.AnimalRepository;

@RunWith(MockitoJUnitRunner.class)
public class AnimalServiceImpTest {

	@InjectMocks
	private AnimalServiceImp animalService;

	@Mock
	private AnimalMapper animalMapper;

	@Mock
	private AnimalRepository animalRepository;

	@Test
	public void getAllPetsTest_WhenWeGetAllPets_Ok() {

		Animal animalRequest = new Animal();
		animalRequest.setId(1L);
		animalRequest.setName("firulais");
		animalRequest.setType("cat");
		animalRequest.setAge(2);

		Animal animalResponse = new Animal();
		animalResponse.setId(1L);
		animalResponse.setName("firulais");
		animalResponse.setType("cat");
		animalResponse.setAge(2);

		List<Animal> listOfPets = new ArrayList<Animal>();
		listOfPets.add(animalResponse);

		when(animalRepository.findAll()).thenReturn(listOfPets);

		List<Animal> response = animalService.getAllPets();

		assertNotNull(response);
		assertEquals(response.get(0).getId(), animalRequest.getId());

		Mockito.verify(animalRepository, Mockito.times(1)).findAll();

	}

	@Test
	public void savePetTest_WhenWeSaveAPet_Ok() {
		AnimalDTO animalDTORequest = new AnimalDTO();
		animalDTORequest.setName("firulais");
		animalDTORequest.setType("cat");
		animalDTORequest.setAge(2);

		AnimalDTO animalDTOResponse = new AnimalDTO();
		animalDTOResponse.setId(1L);
		animalDTOResponse.setName("firulais");
		animalDTOResponse.setType("cat");
		animalDTOResponse.setAge(2);

		Animal animalRequest = new Animal();
		animalRequest.setName("firulais");
		animalRequest.setType("cat");
		animalRequest.setAge(2);

		Animal animalResponse = new Animal();
		animalResponse.setId(1L);
		animalResponse.setName("firulais");
		animalResponse.setType("cat");
		animalResponse.setAge(2);

		when(animalMapper.animalDTOToEntity(Mockito.any(AnimalDTO.class))).thenReturn(animalRequest);
		when(animalRepository.save(Mockito.any(Animal.class))).thenReturn(animalResponse);
		when(animalMapper.entityToAnimalDTO(Mockito.any(Animal.class))).thenReturn(animalDTOResponse);

		AnimalDTO response = animalService.savePet(animalDTORequest);

		assertNotNull(response);
		assertEquals(response, animalDTOResponse);
		assertEquals(response.getName(), animalDTOResponse.getName());

		Mockito.verify(animalMapper, times(1)).animalDTOToEntity(Mockito.any(AnimalDTO.class));
		Mockito.verify(animalRepository, times(1)).save(Mockito.any(Animal.class));
		Mockito.verify(animalMapper, times(1)).entityToAnimalDTO(Mockito.any(Animal.class));

	}

	@Test
	public void getPetByIdTest_WhenWeGetAPet_Ok() {

		long idMustBeNumber = 1L;

		AnimalDTO animalDTOResponse = new AnimalDTO();
		animalDTOResponse.setId(1L);
		animalDTOResponse.setName("firulais");
		animalDTOResponse.setType("cat");
		animalDTOResponse.setAge(2);

		Animal animalResponse = new Animal();
		animalResponse.setId(1L);
		animalResponse.setName("firulais");
		animalResponse.setType("cat");
		animalResponse.setAge(2);

		when(animalRepository.findById(idMustBeNumber)).thenReturn(Optional.of(animalResponse));
		when(animalMapper.entityToAnimalDTO(Mockito.any(Animal.class))).thenReturn(animalDTOResponse);

		AnimalDTO responseGet = animalService.getPetById(1L);

		assertEquals(1L, idMustBeNumber);
		assertEquals(responseGet.getName(), animalDTOResponse.getName());

		Mockito.verify(animalRepository, times(1)).findById(1L);
		Mockito.verify(animalMapper, times(1)).entityToAnimalDTO(Mockito.any(Animal.class));
	}

	@Test
	public void updatePetByIdTest_WeUpdateAPet_Ok() {
		long petId = 1L;
		AnimalDTO animalDTORequest = new AnimalDTO();
		animalDTORequest.setId(1L);
		animalDTORequest.setName("firulais");
		animalDTORequest.setType("cat");
		animalDTORequest.setAge(2);

		AnimalDTO animalDTOResponse = new AnimalDTO();
		animalDTOResponse.setId(1L);
		animalDTOResponse.setName("firulais");
		animalDTOResponse.setType("cat");
		animalDTOResponse.setAge(2);

		Animal animalRequest = new Animal();
		animalRequest.setName("firulais");
		animalRequest.setType("cat");
		animalRequest.setAge(2);

		Animal animalResponse = new Animal();
		animalResponse.setId(1L);
		animalResponse.setName("firulais");
		animalResponse.setType("cat");
		animalResponse.setAge(2);

		when(animalRepository.findById(petId)).thenReturn(Optional.of(animalResponse));
		when(animalMapper.animalDTOToEntity(Mockito.any(AnimalDTO.class))).thenReturn(animalRequest);
		when(animalRepository.save(Mockito.any(Animal.class))).thenReturn(animalResponse);
		when(animalMapper.entityToAnimalDTO(Mockito.any(Animal.class))).thenReturn(animalDTOResponse);

		AnimalDTO response = animalService.updatePet(animalDTORequest);

		assertNotNull(response);
		assertEquals(response.getId(), animalDTOResponse.getId());

		Mockito.verify(animalMapper, times(1)).animalDTOToEntity(Mockito.any(AnimalDTO.class));
		Mockito.verify(animalRepository, times(1)).save(Mockito.any(Animal.class));

	}

	public void deletePetByIdTest_WeDeletedAPet_Ok() {
		long petId = 1L;

		Animal animalRequest = new Animal();
		animalRequest.setName("firulais");
		animalRequest.setType("cat");
		animalRequest.setAge(2);

		Animal animalResponse = new Animal();
		animalResponse.setId(1L);
		animalResponse.setName("firulais");
		animalResponse.setType("cat");
		animalResponse.setAge(2);

		when(animalRepository.findById(petId)).thenReturn(Optional.of(animalResponse));
		when(animalMapper.animalDTOToEntity(Mockito.any(AnimalDTO.class))).thenReturn(animalRequest);

		animalRepository.delete(animalRequest);

		Mockito.verify(animalMapper, times(1)).animalDTOToEntity(Mockito.any(AnimalDTO.class));
	}

}
