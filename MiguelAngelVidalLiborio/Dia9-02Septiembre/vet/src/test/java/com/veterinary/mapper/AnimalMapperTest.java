package com.veterinary.mapper;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.veterinary.dto.AnimalDTO;
import com.veterinary.entity.Animal;

@RunWith(MockitoJUnitRunner.class)
public class AnimalMapperTest {

	@Mock
	private AnimalMapper animalMapper;

	@Test
	public void animalMapperTest_WhenAnimalEntityToAnimalDTO_Ok() {

		Animal animalEntity = new Animal();
		animalEntity.setId(1L);
		animalEntity.setName("pikachu");
		animalEntity.setType("rat");
		animalEntity.setAge(4);

		AnimalDTO animalDTO = new AnimalDTO();
		animalDTO.setId(1L);
		animalDTO.setName("pikachu");
		animalDTO.setType("rat");
		animalDTO.setAge(4);

		when(animalMapper.entityToAnimalDTO(animalEntity)).thenReturn(animalDTO);

		AnimalDTO response = animalMapper.entityToAnimalDTO(animalEntity);

		assertNotNull(response);

		Mockito.verify(animalMapper, times(1)).entityToAnimalDTO(animalEntity);
	}

	@Test
	public void animalMapperTest_WhenAnimalDTOToAnimalEntity_Ok() {

		AnimalDTO animalDTO = new AnimalDTO();
		animalDTO.setId(1L);
		animalDTO.setName("pikachu");
		animalDTO.setType("rat");
		animalDTO.setAge(4);

		Animal animalEntity = new Animal();
		animalEntity.setId(1L);
		animalEntity.setName("pikachu");
		animalEntity.setType("rat");
		animalEntity.setAge(4);

		when(animalMapper.animalDTOToEntity(animalDTO)).thenReturn(animalEntity);

		Animal response = animalMapper.animalDTOToEntity(animalDTO);

		assertNotNull(response);

		Mockito.verify(animalMapper, times(1)).animalDTOToEntity(animalDTO);
	}

}
