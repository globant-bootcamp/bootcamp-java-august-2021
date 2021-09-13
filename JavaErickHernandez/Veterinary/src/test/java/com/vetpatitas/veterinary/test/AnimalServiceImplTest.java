package com.vetpatitas.veterinary.test;

import com.vetpatitas.veterinary.controller.AnimalController;
import com.vetpatitas.veterinary.dao.AnimalDAO;
import com.vetpatitas.veterinary.dto.AnimalDTO;
import com.vetpatitas.veterinary.entity.Animal;
import com.vetpatitas.veterinary.exception.InvalidDataException;
import com.vetpatitas.veterinary.mapper.AnimalMapper;
import com.vetpatitas.veterinary.service.implementation.AnimalServiceImplementation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AnimalServiceImplTest {

    @InjectMocks
    private AnimalServiceImplementation animalService;

    @Mock
    AnimalDAO animalDAO;

    @Mock
    AnimalMapper animalMapper;

    @Test
    public void addAnimalTest() {

        AnimalDTO animalDTORequest = new AnimalDTO();
        animalDTORequest.setId(1L);
        animalDTORequest.setName("GENERIC NAME");
        animalDTORequest.setSpecies("GENERIC SPECIE");

        Animal animalRequest = new Animal();
        animalRequest.setId(1L);
        animalRequest.setName("GENERIC NAME");
        animalRequest.setSpecies("GENERIC SPECIE");


        AnimalDTO animalDTOResponse = new AnimalDTO();
        animalDTOResponse.setId(1L);
        animalDTOResponse.setName("GENERIC NAME");
        animalDTOResponse.setSpecies("GENERIC SPECIE");


        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("GENERIC NAME");
        animal.setSpecies("GENERIC SPECIE");


        when(animalMapper.animalDTOToEntity(any(AnimalDTO.class))).thenReturn(animalRequest);
        when(animalDAO.save(any(Animal.class))).thenReturn(animal);
        when(animalMapper.animalEntityToDTO(any(Animal.class))).thenReturn(animalDTOResponse);

        AnimalDTO response = animalService.addAnimal(animalDTORequest);
        assertNotNull(response);
        assertEquals(response, animalDTOResponse);
        assertEquals(response.getName(), animalDTORequest.getName());

        Mockito.verify(animalMapper, times(1)).animalDTOToEntity(any(AnimalDTO.class));
        Mockito.verify(animalDAO, times(1)).save(any(Animal.class));
        Mockito.verify(animalMapper, times(1)).animalEntityToDTO(any(Animal.class));
    }

    @Test
    public void selectAnimalTest() {

        AnimalDTO animalDTORequest = new AnimalDTO();
        animalDTORequest.setId(1L);
        animalDTORequest.setName("GENERIC NAME");
        animalDTORequest.setSpecies("GENERIC SPECIE");

        Animal animalRequest = new Animal();
        animalRequest.setId(1L);
        animalRequest.setName("GENERIC NAME");
        animalRequest.setSpecies("GENERIC SPECIE");


        AnimalDTO animalDTOResponse = new AnimalDTO();
        animalDTOResponse.setId(1L);
        animalDTOResponse.setName("GENERIC NAME");
        animalDTOResponse.setSpecies("GENERIC SPECIE");


        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("GENERIC NAME");
        animal.setSpecies("GENERIC SPECIE");


        when(animalMapper.animalDTOToEntity(any(AnimalDTO.class))).thenReturn(animalRequest);
        when(animalDAO.getById(animalRequest.getId())).thenReturn(animal);
        when(animalMapper.animalEntityToDTO(any(Animal.class))).thenReturn(animalDTOResponse);

        AnimalDTO response = animalService.selectAnimal(animalDTORequest.getId());
        assertNotNull(response);
        assertEquals(response, animalDTOResponse);
        assertEquals(response.getId(), animalDTORequest.getId());

        Mockito.verify(animalMapper, times(1)).animalDTOToEntity(any(AnimalDTO.class));
        Mockito.verify(animalDAO, times(1)).getById(animalDTORequest.getId());
        Mockito.verify(animalMapper, times(1)).animalEntityToDTO(any(Animal.class));
    }

    @Test(expected = InvalidDataException.class)
    public void updateAnimal() {

        AnimalDTO animalDTORequest = new AnimalDTO();
        animalDTORequest.setId(1L);
        animalDTORequest.setName("OLD NAME");
        animalDTORequest.setSpecies("GENERIC SPECIE");

        when(animalService.editAnimal(animalDTORequest)).thenReturn(null);
        AnimalDTO response = animalService.editAnimal(animalDTORequest);
        assertNotNull(response);
        assertNotEquals(animalDTORequest.getName(), response.getName());

    }

    @Test(expected = InvalidDataException.class)
    public void deleteAnimal() {
        long id = 6L;
        when(animalService.deleteAnimal(id));
        AnimalDTO response = animalService.deleteAnimal(id);
        assertNotNull(response);
    }

}
