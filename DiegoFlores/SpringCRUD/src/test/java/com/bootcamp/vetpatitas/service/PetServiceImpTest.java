package com.bootcamp.vetpatitas.service;

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

import com.bootcamp.vetpatitas.dao.PetDAO;
import com.bootcamp.vetpatitas.dto.PetDTO;
import com.bootcamp.vetpatitas.entity.Pet;
import com.bootcamp.vetpatitas.exception.InvalidDataException;
import com.bootcamp.vetpatitas.mapper.PetMapper;
import com.bootcamp.vetpatitas.service.PetServiceImp;

@RunWith(MockitoJUnitRunner.class)
public class PetServiceImpTest {

	@InjectMocks
	private PetServiceImp petServiceImp;
	
	@Mock
	private PetMapper petMapper;
	
	@Mock
	private PetDAO petDAO;
	
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
		petDTOResponse.setStatus(true);
		
		Pet petRequest = new Pet();
		petRequest.setName("Zelda");
		petRequest.setType("Dog");
		petRequest.setAge(1);
		petRequest.setPhoneNumber("5587412369");
		petRequest.setOwner("Diego Flores");
		
		Pet petResponse = new Pet();
		petResponse.setId(50L);
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
		petDTORequest.setPhoneNumber("123");
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
		petDTORequest.setId(13L);
		petDTORequest.setName("Zelda");
		petDTORequest.setType("Dog");
		petDTORequest.setAge(1);
		petDTORequest.setPhoneNumber("1230456789");
		petDTORequest.setOwner("Diego");
		petDTORequest.setStatus(true);
		
		Pet petResponse = new Pet();
		petResponse.setId(13L);
		petResponse.setName("Zelda");
		petResponse.setType("Dog");
		petResponse.setAge(1);
		petResponse.setPhoneNumber("1230456789");
		petResponse.setOwner("Diego");
		petResponse.setStatus(true);
		
		PetDTO petDTOResponse = new PetDTO();
		petDTOResponse.setId(13L);
		petDTOResponse.setName("Zelda");
		petDTOResponse.setType("Dog");
		petDTOResponse.setAge(1);
		petDTOResponse.setPhoneNumber("1230456789");
		petDTOResponse.setOwner("Diego");
		petDTOResponse.setStatus(true);
		
		when(petMapper.PetDTOToEntity(petDTORequest)).thenReturn(petResponse);
		when(petDAO.save(petResponse)).thenReturn(petResponse);		
		when(petMapper.EntityToUserDTO(petResponse)).thenReturn(petDTOResponse);
		
		PetDTO response = petServiceImp.updatePet(petDTORequest);
		
		assertNotNull(response);
		assertEquals(response, petDTOResponse);
		assertEquals(response.getId(), petDTOResponse.getId());
		assertEquals(response.getName(), petDTORequest.getName());
		assertEquals(response.getType(), petDTOResponse.getType());
		assertEquals(response.getAge(), petDTORequest.getAge());
		assertEquals(response.getPhoneNumber(), petDTORequest.getPhoneNumber());
		assertEquals(response.getOwner(), petDTORequest.getOwner());
		assertEquals(response.getStatus(), petDTOResponse.getStatus());		
	
		verify(petMapper, times(1)).PetDTOToEntity(petDTORequest);
		verify(petDAO, times(1)).save(petResponse);
		verify(petMapper, times(1)).EntityToUserDTO(petResponse);
		
	}
	
	public void getPetTest() {
		
		Long petId = 14L;
		
		Pet petResponse = new Pet();
		petResponse.setId(14L);
		petResponse.setName("Zelda");
		petResponse.setType("Dog");
		petResponse.setAge(1);
		petResponse.setPhoneNumber("5587412369");
		petResponse.setOwner("Diego Flores");
		petResponse.setStatus(true);
		
		PetDTO petDTOResponse = new PetDTO();
		petDTOResponse.setId(14L);
		petDTOResponse.setName("Zelda");
		petDTOResponse.setType("Dog");
		petDTOResponse.setAge(1);
		petDTOResponse.setPhoneNumber("5587412369");
		petDTOResponse.setOwner("Diego Flores");
		petDTOResponse.setStatus(true);

		
		when(petDAO.getById(petId)).thenReturn(petResponse);
		when(petMapper.EntityToUserDTO(petResponse)).thenReturn(petDTOResponse);	
		
		PetDTO response = petServiceImp.getPet(1L);
		
		assertNotNull(response);
		assertEquals(response, petResponse);
		assertEquals(response.getName(), petResponse.getName());
		assertEquals(response.getAge(), petResponse.getAge());
		assertEquals(response.getPhoneNumber(), petResponse.getPhoneNumber());
		assertEquals(response.getOwner(), petResponse.getOwner());
	
		verify(petDAO, times(1)).getById(petId);
		verify(petMapper, times(1)).EntityToUserDTO(petResponse);
		
	}

	public void deletePet() {
		
		Long petId = 14L;
		
		Pet petResponse = new Pet();
		petResponse.setId(14L);
		petResponse.setName("Zelda");
		petResponse.setType("Dog");
		petResponse.setAge(1);
		petResponse.setPhoneNumber("5511223344");
		petResponse.setOwner("Diego Flores");
		petResponse.setStatus(true);
		
		Pet petResponse2 = new Pet();
		petResponse2.setId(14L);
		petResponse2.setName("Zelda");
		petResponse2.setType("Dog");
		petResponse2.setAge(1);
		petResponse2.setPhoneNumber("5511223344");
		petResponse2.setOwner("Diego Flores");
		petResponse2.setStatus(false);
		
		PetDTO petDTOResponse = new PetDTO();
		petDTOResponse.setId(14L);
		petDTOResponse.setName("Zelda");
		petDTOResponse.setType("Dog");
		petDTOResponse.setAge(1);
		petDTOResponse.setPhoneNumber("5511223344");
		petDTOResponse.setOwner("Diego Flores");
		petDTOResponse.setStatus(false);
		
		when(petDAO.getById(petId)).thenReturn(petResponse);
		when(petDAO.save(petResponse2)).thenReturn(petResponse2);	
		when(petMapper.EntityToUserDTO(petResponse2)).thenReturn(petDTOResponse);	
		
		PetDTO response = petServiceImp.deletePet(3L);
		
		assertNotNull(response);
		assertEquals(response, petDTOResponse);
		assertEquals(response.getId(), petDTOResponse.getId());
		assertEquals(response.getName(), petDTOResponse.getName());
		assertEquals(response.getType(), petDTOResponse.getType());
		assertEquals(response.getAge(), petDTOResponse.getAge());
		assertEquals(response.getPhoneNumber(), petDTOResponse.getPhoneNumber());
		assertEquals(response.getOwner(), petDTOResponse.getOwner());
		assertEquals(response.getStatus(), petDTOResponse.getStatus());
	
		verify(petDAO, times(1)).save(petResponse2);
		verify(petMapper, times(1)).EntityToUserDTO(petResponse2);
		
	}
	
	
}
