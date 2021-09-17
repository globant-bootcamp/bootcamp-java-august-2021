package com.bolsadeideas.springboot.bootcamp.app.controllers;

import com.bolsadeideas.springboot.bootcamp.app.dto.RequestDTO;
import com.bolsadeideas.springboot.bootcamp.app.entity.Animal;
import com.bolsadeideas.springboot.bootcamp.app.entity.Owner;
import com.bolsadeideas.springboot.bootcamp.app.entity.Response;
import com.bolsadeideas.springboot.bootcamp.app.exception.NotFoundException;
import com.bolsadeideas.springboot.bootcamp.app.service.InterfaceAnimalService;
import com.bolsadeideas.springboot.bootcamp.app.service.InterfaceOwnerService;
import com.bolsadeideas.springboot.bootcamp.app.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.ANIMAL_CREATED;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.NO_FOUND_ANIMAL;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AnimalControllerTests {
    private final Long ID_SUCCESS = 1L;
    private final Long ID_UNSUCCESSFUL = 2L;
    private final int NUMBER_INVOCATIONS_ONE = 1;

    @InjectMocks
    AnimalController animalController;

    @Mock
    private InterfaceAnimalService animalService;

    @Mock
    private InterfaceOwnerService ownerService;

    @Test
    public void getAllMappingTest_getAllAnimals(){
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("Skrapy");
        animal.setType("Dog");
        animal.setSterilization(true);
        animal.setAge(3);

        Animal animalTwo = new Animal();
        animalTwo.setId(2L);
        animalTwo.setName("Mr.Cat");
        animalTwo.setType("Cat");
        animalTwo.setSterilization(false);
        animalTwo.setAge(1);

        Mockito.when(animalService.findAll()).thenReturn(List.of(animal,animalTwo));

        List<Animal> animalList = animalController.toList();

        assertNotNull(animalList);
        assertEquals(animal.getName(), animalList.get(0).getName());
        Mockito.verify(animalService,Mockito.times(NUMBER_INVOCATIONS_ONE)).findAll();
    }

    @Test
    public void detailsAnimalTest_getAnimalById_ok(){
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("Skrapy");
        animal.setType("Dog");
        animal.setSterilization(true);
        animal.setAge(3);

        when(animalService.findById(Mockito.any(Long.class))).thenReturn(animal);

        ResponseEntity<Response<String>> responseEntity = animalController.detailsAnimal(ID_SUCCESS);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.FOUND);
        verify(animalService,times(NUMBER_INVOCATIONS_ONE)).findById(ID_SUCCESS);
    }

    @Test(expected = NotFoundException.class)
    public void detailsAnimalTest_getAnimalById_exceptionNotFound(){

        when(animalService.findById(Mockito.any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_ANIMAL));

        ResponseEntity<Response<String>> responseEntity = animalController.detailsAnimal(ID_SUCCESS);

        assertNotNull(responseEntity);
        verify(animalService,times(NUMBER_INVOCATIONS_ONE)).findById(ID_UNSUCCESSFUL);
        assertEquals(responseEntity.getStatusCode(),HttpStatus.BAD_REQUEST);
    }

    @Test
    public void addAnimalTest_addAnimal(){
        Animal animal = new Animal();
        animal.setId(4L);
        animal.setName("Don perro");
        animal.setType("Dog");
        animal.setSterilization(true);
        animal.setAge(3);

        Owner owner = new Owner();
        Owner ownerSpy = spy(owner);
        ownerSpy.setId(1L);
        ownerSpy.setName("pancho");
        ownerSpy.setPhone("1118884869");

        when(ownerService.findById(any(Long.class))).thenReturn(ownerSpy);

        ResponseEntity<Response<String>> responseEntity = animalController.addAnimal(animal,ID_SUCCESS);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(),HttpStatus.CREATED);
        verify(ownerService,times(NUMBER_INVOCATIONS_ONE)).save(any(RequestDTO.class));
        verify(ownerSpy,times(NUMBER_INVOCATIONS_ONE)).addAnimal(animal);
    }

    @Test
    public void updateAnimal_updateAnimal_ok(){
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("Skrapy");
        animal.setType("Dog");
        animal.setSterilization(true);
        animal.setAge(3);

        when(animalService.update(any(Animal.class))).thenReturn(animal);

        ResponseEntity<Response<String>> responseEntity = animalController.updateAnimal(animal);

        assertNotNull(responseEntity);
        verify(animalService, times(NUMBER_INVOCATIONS_ONE)).update(any(Animal.class));
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test(expected = NotFoundException.class)
    public void updateAnimal_updateAnimalExceptionNotFoundAnimal(){
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("Skrapy");
        animal.setType("Dog");
        animal.setSterilization(true);
        animal.setAge(3);

        when(animalService.update(any(Animal.class))).thenThrow(new NotFoundException(NO_FOUND_ANIMAL));

        ResponseEntity<Response<String>> responseEntity = animalController.updateAnimal(animal);

        assertNotNull(responseEntity);
        verify(animalService, times(NUMBER_INVOCATIONS_ONE)).update(any(Animal.class));
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void deleteAnimal_deleteAnimal_ok(){
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("Skrapy");
        animal.setType("Dog");
        animal.setSterilization(true);
        animal.setAge(3);

        when(animalService.delete(any(Long.class))).thenReturn(animal);

        ResponseEntity<Response<String>> responseEntity = animalController.deleteAnimal(ID_SUCCESS);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(animalService, times(NUMBER_INVOCATIONS_ONE)).delete(ID_SUCCESS);
    }

    @Test(expected = NotFoundException.class)
    public void deleteAnimal_deleteAnimal_notFoundException(){

        when(animalService.delete(any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_ANIMAL));

        ResponseEntity<Response<String>> responseEntity = animalController.deleteAnimal(ID_UNSUCCESSFUL);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
        verify(animalService, times(NUMBER_INVOCATIONS_ONE)).delete(ID_UNSUCCESSFUL);
    }
}
