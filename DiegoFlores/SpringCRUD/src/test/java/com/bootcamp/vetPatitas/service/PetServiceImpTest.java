package com.bootcamp.vetPatitas.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.bootcamp.vetPatitas.dao.PetDAO;
import com.bootcamp.vetPatitas.dto.PetDTO;
import com.bootcamp.vetPatitas.entity.Pet;
import com.bootcamp.vetPatitas.exception.InvalidDataException;
import com.bootcamp.vetPatitas.mapper.PetMapper;

@RunWith(MockitoJUnitRunner.class)
public class PetServiceImpTest {

	@InjectMocks
	private PetServiceImp petServiceImp;
	
	@Mock
	PetMapper petMapper;
	
	@Mock
	PetDAO petDAO;
	
	@Test
	public void addPet_WhenPhoneNumberHave10Digits() {
	
		PetDTO petDTORequest = new PetDTO();		
		petDTORequest.setName("Zelda");
		petDTORequest.setType("Dog");
		petDTORequest.setAge(1);
		petDTORequest.setPhoneNumber("5587412369");
		petDTORequest.setOwner("Diego Flores");
		
		PetDTO petDTOResponse = new PetDTO();
		petDTOResponse.setId(1L);
		petDTOResponse.setName("Zelda");
		petDTOResponse.setType("Dog");
		petDTOResponse.setAge(1);
		petDTOResponse.setPhoneNumber("5587412369");
		petDTOResponse.setOwner("Diego Flores");
		petDTORequest.setStatus(true);
		
		Pet petRequest = new Pet();
		petRequest.setName("Zelda");
		petRequest.setType("Dog");
		petRequest.setAge(1);
		petRequest.setPhoneNumber("5587412369");
		petRequest.setOwner("Diego Flores");
		
		Pet petResponse = new Pet();
		petResponse.setId(1L);
		petResponse.setName("Zelda");
		petResponse.setType("Dog");
		petResponse.setAge(1);
		petResponse.setPhoneNumber("5587412369");
		petResponse.setOwner("Diego Flores");
		petResponse.setStatus(true);
		
		when(petMapper.PetDTOToEntity(petDTORequest)).thenReturn(petRequest);
		when(petDAO.save(petRequest)).thenReturn(petResponse);
		when(petMapper.EntityToUserDTO(petRequest)).thenReturn(petDTOResponse);
		
		PetDTO response = petServiceImp.addPet(petDTORequest);
		
		assertNotNull(response);
		assertEquals(response, petDTOResponse);
		assertEquals(response.getName(), petDTORequest.getName());
		assertEquals(response.getAge(), petDTORequest.getAge());
		assertEquals(response.getPhoneNumber(), petDTORequest.getPhoneNumber());
		assertEquals(response.getOwner(), petDTORequest.getOwner());
	
		verify(petMapper, times(1)).PetDTOToEntity(petDTORequest);
		verify(petDAO, times(1)).save(petRequest);
		verify(petMapper, times(1)).EntityToUserDTO(petRequest);
		
	}
	
	@Test(expected = InvalidDataException.class)
	public void addPet_WhenPhoneNumberLessThan10Digits_ThenInvalidDataException() {
		
		PetDTO petDTORequest = new PetDTO();		
		petDTORequest.setName("Zelda");
		petDTORequest.setType("Dog");
		petDTORequest.setAge(1);
		petDTORequest.setPhoneNumber("12");
		petDTORequest.setOwner("Diego Flores");
		
		petServiceImp.addPet(petDTORequest);
		
	}
	
	@Test(expected = InvalidDataException.class)
	public void addPet_WhenNameIsNull_ThenInvalidDataException() {
		
		PetDTO petDTORequest = new PetDTO();
		petDTORequest.setType("Dog");
		petDTORequest.setAge(1);
		petDTORequest.setPhoneNumber("1234567890");
		petDTORequest.setOwner("Diego Flores");
		
		petServiceImp.addPet(petDTORequest);
		
	}
	
	@Test(expected = InvalidDataException.class)
	public void addPet_WhenTypeIsNull_ThenInvalidDataException() {
		
		PetDTO petDTORequest = new PetDTO();
		petDTORequest.setName("Zelda");
		petDTORequest.setAge(1);
		petDTORequest.setPhoneNumber("12");
		petDTORequest.setOwner("Diego Flores");
		
		petServiceImp.addPet(petDTORequest);
		
	}
	
	@Test(expected = InvalidDataException.class)
	public void addPet_WhenAgeIsNull_ThenInvalidDataException() {
		
		PetDTO petDTORequest = new PetDTO();		
		petDTORequest.setName("Zelda");
		petDTORequest.setType("Dog");
		petDTORequest.setPhoneNumber("12");
		petDTORequest.setOwner("Diego Flores");
		
		petServiceImp.addPet(petDTORequest);
		
	}
	
	@Test(expected = InvalidDataException.class)
	public void addPet_WhenOwnerIsNull_ThenInvalidDataException() {
		
		PetDTO petDTORequest = new PetDTO();		
		petDTORequest.setName("Zelda");
		petDTORequest.setType("Dog");
		petDTORequest.setAge(1);
		petDTORequest.setPhoneNumber("12");
		petDTORequest.setOwner("Diego Flores");
		
		petServiceImp.addPet(petDTORequest);
		
	}
	
	public void updatePetTest() {
		
		PetDTO petDTORequest = new PetDTO();		
		petDTORequest.setName("Zelda");
		petDTORequest.setType("Dog");
		petDTORequest.setAge(1);
		petDTORequest.setPhoneNumber("6321478525");
		petDTORequest.setOwner("Diego");
		
		PetDTO petDTOResponse = new PetDTO();
		petDTOResponse.setId(1L);
		petDTOResponse.setName("Zelda");
		petDTOResponse.setType("Dog");
		petDTOResponse.setAge(1);
		petDTOResponse.setPhoneNumber("6321478525");
		petDTOResponse.setOwner("Diego");
		petDTORequest.setStatus(true);
		
		Pet petRequest = new Pet();
		petRequest.setName("Zelda");
		petRequest.setType("Dog");
		petRequest.setAge(1);
		petRequest.setPhoneNumber("6321478525");
		petRequest.setOwner("Diego");
		
		Pet petResponse = new Pet();
		petResponse.setId(1L);
		petResponse.setName("Zelda");
		petResponse.setType("Dog");
		petResponse.setAge(1);
		petResponse.setPhoneNumber("6321478525");
		petResponse.setOwner("Diego");
		petResponse.setStatus(true);
		
		when(petDAO.getById(petDTORequest.getId())).thenReturn(petResponse);
		when(petDAO.save(petRequest)).thenReturn(petResponse);		
		when(petMapper.EntityToUserDTO(petRequest)).thenReturn(petDTOResponse);
		
		PetDTO response = petServiceImp.updatePet(petDTORequest);
		
		assertNotNull(response);
		assertEquals(response, petDTOResponse);
		assertEquals(response.getName(), petDTORequest.getName());
		assertEquals(response.getAge(), petDTORequest.getAge());
		assertEquals(response.getPhoneNumber(), petDTORequest.getPhoneNumber());
		assertEquals(response.getOwner(), petDTORequest.getOwner());
	
		verify(petDAO, times(1)).save(petRequest);
		verify(petMapper, times(1)).EntityToUserDTO(petRequest);
		
	}
	
	public void getPetTest() {
		
		PetDTO petDTOResponse = new PetDTO();
		petDTOResponse.setId(1L);
		petDTOResponse.setName("Zelda");
		petDTOResponse.setType("Dog");
		petDTOResponse.setAge(1);
		petDTOResponse.setPhoneNumber("5587412369");
		petDTOResponse.setOwner("Diego Flores");
		
		Pet petRequest = new Pet();
		petRequest.setName("Zelda");
		petRequest.setType("Dog");
		petRequest.setAge(1);
		petRequest.setPhoneNumber("5587412369");
		petRequest.setOwner("Diego Flores");
		
		Pet petResponse = new Pet();
		petResponse.setId(1L);
		petResponse.setName("Zelda");
		petResponse.setType("Dog");
		petResponse.setAge(1);
		petResponse.setPhoneNumber("5587412369");
		petResponse.setOwner("Diego Flores");
		petResponse.setStatus(true);
		
		
		when(petDAO.getById(1L)).thenReturn(petResponse);
		when(petMapper.EntityToUserDTO(petRequest)).thenReturn(petDTOResponse);	
		
		PetDTO response = petServiceImp.getPet(1L);
		
		assertNotNull(response);
		assertEquals(response, petResponse);
		assertEquals(response.getName(), petResponse.getName());
		assertEquals(response.getAge(), petResponse.getAge());
		assertEquals(response.getPhoneNumber(), petResponse.getPhoneNumber());
		assertEquals(response.getOwner(), petResponse.getOwner());
	
		verify(petDAO, times(1)).save(petRequest);
		verify(petMapper, times(1)).EntityToUserDTO(petRequest);
		
	}

	public void deletePet() {
		
		PetDTO petDTORequest = new PetDTO();		
		petDTORequest.setName("Zelda");
		petDTORequest.setType("Dog");
		petDTORequest.setAge(1);
		petDTORequest.setPhoneNumber("6321478525");
		petDTORequest.setOwner("Diego");
		
		PetDTO petDTOResponse = new PetDTO();
		petDTOResponse.setId(1L);
		petDTOResponse.setName("Zelda");
		petDTOResponse.setType("Dog");
		petDTOResponse.setAge(1);
		petDTOResponse.setPhoneNumber("5587412369");
		petDTOResponse.setOwner("Diego Flores");
		petDTOResponse.setStatus(false);
		
		Pet petRequest = new Pet();
		petRequest.setName("Zelda");
		petRequest.setType("Dog");
		petRequest.setAge(1);
		petRequest.setPhoneNumber("5587412369");
		petRequest.setOwner("Diego Flores");
		
		Pet petResponse = new Pet();
		petResponse.setId(1L);
		petResponse.setName("Zelda");
		petResponse.setType("Dog");
		petResponse.setAge(1);
		petResponse.setPhoneNumber("5587412369");
		petResponse.setOwner("Diego Flores");
		petResponse.setStatus(false);
		
		
		when(petDAO.getById(1L)).thenReturn(petResponse);
		when(petDAO.save(petRequest)).thenReturn(petResponse);	
		when(petMapper.EntityToUserDTO(petRequest)).thenReturn(petDTOResponse);	
		
		PetDTO response = petServiceImp.deletePet(petDTORequest);
		
		assertNotNull(response);
		assertEquals(response, petResponse);
		assertEquals(response.getName(), petResponse.getName());
		assertEquals(response.getAge(), petResponse.getAge());
		assertEquals(response.getPhoneNumber(), petResponse.getPhoneNumber());
		assertEquals(response.getOwner(), petResponse.getOwner());
	
		verify(petDAO, times(1)).save(petRequest);
		verify(petMapper, times(1)).EntityToUserDTO(petRequest);
		
	}
	
	
}
