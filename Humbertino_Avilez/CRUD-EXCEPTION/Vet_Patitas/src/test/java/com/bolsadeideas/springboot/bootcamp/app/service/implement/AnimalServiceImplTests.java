package com.bolsadeideas.springboot.bootcamp.app.service.implement;

import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.NO_FOUND_ANIMAL;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.bolsadeideas.springboot.bootcamp.app.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bolsadeideas.springboot.bootcamp.app.dao.AnimalDao;
import com.bolsadeideas.springboot.bootcamp.app.entity.Animal;

@RunWith(MockitoJUnitRunner.class)	
public class AnimalServiceImplTests {

	private static final int NUMBER_INVOCATIONS_ONE = 1;
	private static final Long  ID_SUCCESS = 1L;
	private static final Long ID_UNSUCCESS = 2L;

	@Mock
	private AnimalDao animalDao;
	
	@InjectMocks
	private AnimalServiceImpl animalServiceImpl;
	
	@Test
	public void findAllTest_ListTotalAnimals() {
		Animal animal = new Animal();
		animal.setId((long) 1);
		animal.setName("Skrapy");
		animal.setType("Dog");
		animal.setSterilization(true);
		animal.setAge(3);

		Animal animalTwo = new Animal();
		animalTwo.setId((long) 1);
		animalTwo.setName("Mr.Cat");
		animalTwo.setType("Cat");
		animalTwo.setSterilization(false);
		animalTwo.setAge(1);
		
		when(animalDao.findAll()).thenReturn(Arrays.asList(animal, animalTwo));

		List<Animal>list =  animalServiceImpl.findAll();
		
		assertNotNull(list);
		assertEquals(list.get(0).getId(), animal.getId());
		assertEquals(list.get(1).getName(), animalTwo.getName());
	}

	@Test
	public void findByIdTest_GetAnimal_ok() {
		Animal animal = new Animal();
		animal.setId((long) 1);
		animal.setName("Skrapy");
		animal.setType("Dog");
		animal.setSterilization(true);
		animal.setAge(3);
		Optional<Animal> animalOptional = Optional.of(animal);

		when(animalDao.findById(any(Long.class))).thenReturn(animalOptional);

		Animal newAnimal = animalServiceImpl.findById(ID_SUCCESS);
		assertNotNull(newAnimal);
		verify(animalDao).findById(ID_SUCCESS);
		assertEquals(animal.getName(), newAnimal.getName());
		assertEquals(animal.getType(), newAnimal.getType());
	}

	@Test(expected = NotFoundException.class)
	public void findByIdTest_AnimalexceptionNotFound() {
		when(animalDao.findById(ID_UNSUCCESS)).thenThrow(new NotFoundException(NO_FOUND_ANIMAL));

		Animal newAnimal = animalServiceImpl.findById(ID_UNSUCCESS);

		verify(animalDao,times(NUMBER_INVOCATIONS_ONE)).findById(ID_UNSUCCESS);
		assertNull(newAnimal);
	}

	@Test
	public void saveTest_saveAnimal(){
		Animal animal = new Animal();
		animal.setId(1L);
		animal.setName("Mrs. dog");
		animal.setType("Dog");
		animal.setSterilization(true);
		animal.setAge(3);

		when(animalDao.save(any(Animal.class))).thenReturn(animal);

		Animal newAnimal = animalServiceImpl.save(animal);

		assertNotNull(newAnimal);
		assertEquals(animal.getName(),newAnimal.getName());
		assertEquals(animal.getAge(), newAnimal.getAge());
		verify(animalDao,times(NUMBER_INVOCATIONS_ONE)).save(any(Animal.class));
	}

	@Test
	public void deleteAnimalTest_deleteAnimal_ok(){
		Animal animalResponse = new Animal();
		animalResponse.setId((long) 1);
		animalResponse.setName("Mrs. dog");
		animalResponse.setType("Dog");
		animalResponse.setSterilization(true);
		animalResponse.setAge(3);
		Optional<Animal> animalOptional = Optional.of(animalResponse);
		AnimalServiceImpl animalServiceMock = mock(AnimalServiceImpl.class);

		doNothing().when(animalDao).deleteById(any(Long.class));
		when(animalDao.findById(any(Long.class))).thenReturn(animalOptional);
		when(animalServiceMock.findById(any(Long.class))).thenReturn(animalResponse);

		Animal animal = animalServiceImpl.delete(ID_SUCCESS);

		assertNotNull(animal);
		assertEquals(animal.getName(),animalResponse.getName());
		verify(animalDao,times(NUMBER_INVOCATIONS_ONE)).deleteById(any(Long.class));
	}

	@Test(expected = NotFoundException.class)
	public void deleteAnimalTest_exceptionNotFoundAnimal(){
		AnimalServiceImpl animalServiceMock = mock(AnimalServiceImpl.class);
		when(animalDao.findById(any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_ANIMAL));
		when(animalServiceMock.findById(any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_ANIMAL));

		Animal animal = animalServiceImpl.delete(ID_UNSUCCESS);
		assertNull(animal);
		verify(animalDao, times(NUMBER_INVOCATIONS_ONE)).findById(any(Long.class));
	}

	@Test
	public void updateTest_updateAnimal_ok(){
		Animal animalRequest = new Animal();
		Animal animalRequestSpy = Mockito.spy(animalRequest);
		animalRequestSpy.setId(1L);
		animalRequestSpy.setName("Mrs. dog");
		animalRequestSpy.setType("Dog");
		animalRequestSpy.setSterilization(true);
		animalRequestSpy.setAge(3);

		Animal animalDataBase = new Animal();
		Animal animalDatabaseSpy = Mockito.spy(animalDataBase);
		animalDatabaseSpy.setId(1L);
		animalDatabaseSpy.setName("Mr.Cat");
		animalDatabaseSpy.setType("Cat");
		animalDatabaseSpy.setSterilization(false);
		animalDatabaseSpy.setAge(1);
		Optional<Animal> animalOptional = Optional.of(animalDatabaseSpy);

		AnimalServiceImpl animalServiceMock = mock(AnimalServiceImpl.class);

		when(animalDao.save(any(Animal.class))).thenReturn(animalRequestSpy);
		when(animalServiceMock.save(any(Animal.class))).thenReturn(animalRequestSpy);
		when(animalDao.findById(any(Long.class))).thenReturn(animalOptional);
		when(animalServiceMock.findById(any(Long.class))).thenReturn(animalDatabaseSpy);

		Animal animal = animalServiceImpl.update(animalRequestSpy);

		assertNotNull(animal);
		assertEquals(animal.getName(),animalDatabaseSpy.getName());
		verify(animalDatabaseSpy).setName(animalRequestSpy.getName());
		verify(animalRequestSpy,times(NUMBER_INVOCATIONS_ONE)).getAge();
	}

	@Test(expected = NotFoundException.class)
	public void updateTest_notFoundANimalException(){
		Animal animalRequest = new Animal();
		animalRequest.setId((long) 1);
		animalRequest.setName("Mrs. dog");
		animalRequest.setType("Dog");
		animalRequest.setSterilization(true);
		animalRequest.setAge(3);

		AnimalServiceImpl animalServiceMock = mock(AnimalServiceImpl.class);

		when(animalDao.findById(any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_ANIMAL));
		when(animalServiceMock.findById(any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_ANIMAL));

		Animal animal = animalServiceImpl.update(animalRequest);

		assertNull(animal);
		verify(animalDao,times(NUMBER_INVOCATIONS_ONE)).findById(any(Long.class));
	}
}
