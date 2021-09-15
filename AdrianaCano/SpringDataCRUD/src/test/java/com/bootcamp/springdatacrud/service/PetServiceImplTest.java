package com.bootcamp.springdatacrud.service;

import com.bootcamp.springdatacrud.dao.PetDAO;
import com.bootcamp.springdatacrud.dao.PetOwnerDAO;
import com.bootcamp.springdatacrud.dto.PetDTO;
import com.bootcamp.springdatacrud.dto.PetOwnerDTO;
import com.bootcamp.springdatacrud.entity.Pet;
import com.bootcamp.springdatacrud.entity.PetOwner;
import com.bootcamp.springdatacrud.exception.NotFoundException;
import com.bootcamp.springdatacrud.mapper.PetMapper;
import com.bootcamp.springdatacrud.mapper.PetOwnerMapper;
import com.bootcamp.springdatacrud.service.impl.PetOwnerServiceImpl;
import com.bootcamp.springdatacrud.service.impl.PetServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PetServiceImplTest {

    @InjectMocks
    private PetServiceImpl petService;

    @Mock
    PetMapper petMapper;

    @Mock
    PetDAO petDAO;

    @Mock
    PetOwnerService petOwnerService;

    @Mock
    PetOwnerMapper petOwnerMapper;

    @Mock
    PetOwnerDAO petOwnerDAO;

    @Test
    public void showListTestPet_NOTNULL(){
        Pet petRequest = new Pet();
        petRequest.setName("GenericName");
        petRequest.setWeight(3.4);
        petRequest.setBreed("GenericBreed");
        petRequest.setAge(4);
        List<Pet> petList = new ArrayList<>();
        petList.add(petRequest);

        when(petDAO.findAll()).thenReturn(List.of(petRequest));

        List<Pet> pet = petService.showList();
        assertNotNull(pet);
        assertEquals("GenericName", pet.get(0).getName());
    }

    @Test(expected = NotFoundException.class)
    public void getPetOwnerById_NULL_NotFoundException(){
        PetOwnerDTO response = petOwnerService.getPetOwnerById(1L);
    }

    @Test
    public void addPetTest(){
        PetOwner petOwnerRequest = new PetOwner();
        petOwnerRequest.setId(1L);
        petOwnerRequest.setName("GenericName");
        petOwnerRequest.setAddress("GenericAddress");
        petOwnerRequest.setPhoneNumber("6656767786");
        Optional<PetOwner> petOwnerOptional = Optional.of(petOwnerRequest);

        PetOwnerDTO petOwnerDTOResponse = new PetOwnerDTO();
        petOwnerDTOResponse.setId(1L);
        petOwnerDTOResponse.setName("GenericName");
        petOwnerDTOResponse.setAddress("GenericAddress");
        petOwnerDTOResponse.setPhoneNumber("6656767786");

        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setName("GenericName");
        petDTORequest.setAge(6);
        petDTORequest.setBreed("GenericBreed");
        petDTORequest.setWeight(5.8);

        Pet petEntityRequest = new Pet();
        petEntityRequest.setName("GenericName");
        petEntityRequest.setAge(6);
        petEntityRequest.setBreed("GenericBreed");
        petEntityRequest.setWeight(5.8);

        Pet petEntityResponse = new Pet();
        petEntityResponse.setId((1L));
        petEntityResponse.setName("GenericName");
        petEntityResponse.setAge(6);
        petEntityResponse.setBreed("GenericBreed");
        petEntityResponse.setWeight(5.8);

        PetDTO petDTOResponse = new PetDTO();
        petEntityResponse.setId((1L));
        petEntityResponse.setName("GenericName");
        petEntityResponse.setAge(6);
        petEntityResponse.setBreed("GenericBreed");
        petEntityResponse.setWeight(5.8);

        PetOwnerServiceImpl ownerServiceMock = mock(PetOwnerServiceImpl.class);
        when(petOwnerDAO.findById(any(Long.class))).thenReturn(Optional.of(petOwnerRequest));
        when(petOwnerMapper.petOwnerEntityToDTO(any(PetOwner.class))).thenReturn(petOwnerDTOResponse);

        PetOwnerDTO response = petOwnerService.getPetOwnerById(1L);

        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);
        when(petDAO.save(any(Pet.class))).thenReturn(petEntityResponse);
        when(petMapper.petDTOToEntity(any(PetDTO.class))).thenReturn(petEntityRequest);
        when(petOwnerService.getPetOwnerById(1L)).thenReturn(response);

        assertNotNull(response);
        assertEquals(response, petOwnerDTOResponse);
        assertEquals(response.getId(), petOwnerDTOResponse.getId());
        assertEquals(response.getName(), petOwnerDTOResponse.getName());

    }

    @Test
    public void getPetByIdTest(){
        Pet petRequest = new Pet();
        petRequest.setId(1L);
        petRequest.setName("GenericName");
        petRequest.setBreed("GenericBreed");
        petRequest.setWeight(6.7);
        Optional<Pet> petOptional = Optional.of(petRequest);

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setName("GenericName");
        petDTOResponse.setBreed("GenericBreed");
        petDTOResponse.setWeight(6.7);


        when(petDAO.findById(any(Long.class))).thenReturn(Optional.of(petRequest));

        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.getPetById(1L);

        assertNotNull(response);
        assertEquals(response, petDTOResponse);
        assertEquals(response.getId(), petDTOResponse.getId());
        assertEquals(response.getName(), petDTOResponse.getName());
    }

    @Test(expected = NotFoundException.class)
    public void getPetById_NULL_NotFoundException(){
        PetDTO response = petService.getPetById(1L);
    }

    @Test
    public void deletePetTest(){
        Pet petRequest = new Pet();
        petRequest.setId(1L);
        petRequest.setName("GenericName");
        petRequest.setBreed("GenericBreed");
        petRequest.setWeight(7.7);
        petRequest.setAge(5);
        Optional<Pet> petOwnerOptional = Optional.of(petRequest);

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setName("GenericName");
        petDTOResponse.setBreed("GenericBreed");
        petDTOResponse.setWeight(7.7);
        petDTOResponse.setAge(5);

        doNothing().when(petDAO).deleteById(any(Long.class));
        PetServiceImpl petServiceMock = mock(PetServiceImpl.class);
        when(petDAO.findById(any(Long.class))).thenReturn(Optional.of(petRequest));
        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.getPetById(1L);
        petService.deletePet(1L);

        assertNotNull(response);
        assertEquals(response, petDTOResponse);
        assertEquals(response.getId(), petDTOResponse.getId());
        assertEquals(response.getName(), petDTOResponse.getName());
    }

    @Test
    public void updatePetTest(){
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setId(1L);
        petDTORequest.setName("GenericNameModified");
        petDTORequest.setBreed("GenericBreed");
        petDTORequest.setWeight(7.7);
        petDTORequest.setAge(5);

        Pet petEntity = new Pet();
        petEntity.setId(1L);
        petEntity.setName("GenericNameModified");
        petEntity.setBreed("GenericBreed");
        petEntity.setWeight(7.7);
        petEntity.setAge(5);
        Optional<Pet> petOptional = Optional.of(petEntity);

        Pet petEntityResponse = new Pet();
        petEntity.setId(1L);
        petEntity.setName("GenericName");
        petEntity.setBreed("GenericBreed");
        petEntity.setWeight(7.7);
        petEntity.setAge(5);


        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setName("GenericName");
        petDTOResponse.setBreed("GenericBreed");
        petDTOResponse.setWeight(7.7);
        petDTOResponse.setAge(5);

        when(petDAO.findById(any(Long.class))).thenReturn(Optional.of(petEntity));
        when(petMapper.petDTOToEntity(any(PetDTO.class))).thenReturn(petEntity);
        when(petDAO.save(any(Pet.class))).thenReturn(petEntityResponse);
        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.updatePet(1L,petDTORequest);

        assertNotNull(response);
        assertEquals(response, petDTOResponse);
        assertEquals(response.getName(), petDTOResponse.getName());
        assertEquals(response.getAge(), petDTOResponse.getAge());
        assertEquals(response.getBreed(), petDTOResponse.getBreed());

        Mockito.verify(petMapper, times(1)).petDTOToEntity((any(PetDTO.class)));
        Mockito.verify(petDAO, times(1)).save((any(Pet.class)));
        Mockito.verify(petMapper, times(2)).petEntityToDTO((any(Pet.class)));
    }

}
