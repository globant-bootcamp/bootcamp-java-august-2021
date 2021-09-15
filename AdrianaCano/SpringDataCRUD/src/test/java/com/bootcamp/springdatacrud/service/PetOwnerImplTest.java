package com.bootcamp.springdatacrud.service;

import com.bootcamp.springdatacrud.dao.PetOwnerDAO;
import com.bootcamp.springdatacrud.dto.PetOwnerDTO;
import com.bootcamp.springdatacrud.entity.Pet;
import com.bootcamp.springdatacrud.entity.PetOwner;
import com.bootcamp.springdatacrud.exception.NotFoundException;
import com.bootcamp.springdatacrud.mapper.PetOwnerMapper;
import com.bootcamp.springdatacrud.service.impl.PetOwnerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class PetOwnerImplTest {

    @InjectMocks
    private PetOwnerServiceImpl petOwnerService;

    @Mock
    PetOwnerMapper petOwnerMapper;

    @Mock
    PetOwnerDAO petOwnerDAO;

    @Test
    public void addPetOwner_Ok(){

        PetOwnerDTO petOwnerDTORequest = new PetOwnerDTO();
        petOwnerDTORequest.setName("GenericName");
        petOwnerDTORequest.setAddress("GenericAddress");
        petOwnerDTORequest.setPhoneNumber("6656767786");

        PetOwner petOwnerEntity = new PetOwner();
        petOwnerEntity.setName("GenericName");
        petOwnerEntity.setAddress("GenericAddress");
        petOwnerEntity.setPhoneNumber("6656767786");

        PetOwner petOwnerEntityResponse = new PetOwner();
        petOwnerEntityResponse.setId(1L);
        petOwnerEntityResponse.setName("GenericName");
        petOwnerEntityResponse.setAddress("GenericAddress");
        petOwnerEntityResponse.setPhoneNumber("6656767786");

        PetOwnerDTO petOwnerDTOResponse = new PetOwnerDTO();
        petOwnerDTOResponse.setId(1L);
        petOwnerDTOResponse.setName("GenericName");
        petOwnerDTOResponse.setAddress("GenericAddress");
        petOwnerEntityResponse.setPhoneNumber("6656767786");

        when(petOwnerMapper.petOwnerDTOToEntity(any(PetOwnerDTO.class))).thenReturn(petOwnerEntity);
        when(petOwnerDAO.save(any(PetOwner.class))).thenReturn(petOwnerEntityResponse);
        when(petOwnerMapper.petOwnerEntityToDTO(any(PetOwner.class))).thenReturn(petOwnerDTOResponse);

        PetOwnerDTO response = petOwnerService.addPetOwner(petOwnerDTORequest);

        assertNotNull(response);
        assertEquals(response, petOwnerDTOResponse);
        assertEquals(response.getName(), petOwnerDTOResponse.getName());
        assertEquals(response.getAddress(), petOwnerDTOResponse.getAddress());
        assertEquals(response.getPhoneNumber(), petOwnerDTOResponse.getPhoneNumber());

        Mockito.verify(petOwnerMapper, times(1)).petOwnerDTOToEntity((any(PetOwnerDTO.class)));
        Mockito.verify(petOwnerDAO, times(1)).save((any(PetOwner.class)));
        Mockito.verify(petOwnerMapper, times(1)).petOwnerEntityToDTO((any(PetOwner.class)));

    }

    @Test
    public void showListTestPetOwner_NOTNULL(){
        Pet pet = new Pet();
        pet.setName("GenericName");
        pet.setAge(3);
        pet.setBreed("GenericBreed");
        pet.setWeight(3.5);
        List<Pet> petList = new ArrayList<>();
        petList.add(pet);

        PetOwner petOwnerRequest = new PetOwner();
        petOwnerRequest.setName("GenericName");
        petOwnerRequest.setAddress("GenericAddress");
        petOwnerRequest.setPhoneNumber("6656768798");
        petOwnerRequest.setPet(petList);

        when(petOwnerDAO.findAll()).thenReturn(List.of(petOwnerRequest));

        List<PetOwner> petOwnerList = petOwnerService.showList();
        assertNotNull(petOwnerList);
        assertEquals("GenericName", petOwnerList.get(0).getName());
    }


    @Test
    public void getPetOwnerById_Ok(){

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


        when(petOwnerDAO.findById(any(Long.class))).thenReturn(Optional.of(petOwnerRequest));
        when(petOwnerMapper.petOwnerEntityToDTO(any(PetOwner.class))).thenReturn(petOwnerDTOResponse);

        PetOwnerDTO response = petOwnerService.getPetOwnerById(1L);

        assertNotNull(response);
        assertEquals(response, petOwnerDTOResponse);
        assertEquals(response.getId(), petOwnerDTOResponse.getId());
        assertEquals(response.getName(), petOwnerDTOResponse.getName());
    }

    @Test(expected = NotFoundException.class)
    public void getPetOwnerById_NULL_NotFoundException(){
        PetOwnerDTO response = petOwnerService.getPetOwnerById(1L);
    }

    @Test
    public void deletePetOwnerTest_NOTNULL(){
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

        doNothing().when(petOwnerDAO).deleteById(any(Long.class));
        PetOwnerServiceImpl ownerServiceMock = mock(PetOwnerServiceImpl.class);
        when(petOwnerDAO.findById(any(Long.class))).thenReturn(Optional.of(petOwnerRequest));
        when(petOwnerMapper.petOwnerEntityToDTO(any(PetOwner.class))).thenReturn(petOwnerDTOResponse);

        PetOwnerDTO response = petOwnerService.getPetOwnerById(1L);
        petOwnerService.deletePetOwner(1L);

        assertNotNull(response);
        assertEquals(response, petOwnerDTOResponse);
        assertEquals(response.getId(), petOwnerDTOResponse.getId());
        assertEquals(response.getName(), petOwnerDTOResponse.getName());

    }

    @Test
    public void updatePetOwnerTest_NOTNULL(){
        PetOwnerDTO petOwnerDTORequest = new PetOwnerDTO();
        petOwnerDTORequest.setId(1L);
        petOwnerDTORequest.setName("GenericNameModified");
        petOwnerDTORequest.setAddress("GenericAddressModified");
        petOwnerDTORequest.setPhoneNumber("6656767786");

        PetOwner petOwnerEntity = new PetOwner();
        petOwnerEntity.setId(1L);
        petOwnerEntity.setName("GenericNameModified");
        petOwnerEntity.setAddress("GenericAddressModified");
        petOwnerEntity.setPhoneNumber("6656767786");
        Optional<PetOwner> petOwnerOptional = Optional.of(petOwnerEntity);

        PetOwner petOwnerEntityResponse = new PetOwner();
        petOwnerEntityResponse.setId(1L);
        petOwnerEntityResponse.setName("GenericName");
        petOwnerEntityResponse.setAddress("GenericAddress");
        petOwnerEntityResponse.setPhoneNumber("6656767786");


        PetOwnerDTO petOwnerDTOResponse = new PetOwnerDTO();
        petOwnerDTOResponse.setId(1L);
        petOwnerDTOResponse.setName("GenericName");
        petOwnerDTOResponse.setAddress("GenericAddress");
        petOwnerEntityResponse.setPhoneNumber("6656767786");

        when(petOwnerDAO.findById(any(Long.class))).thenReturn(Optional.of(petOwnerEntity));
        when(petOwnerMapper.petOwnerDTOToEntity(any(PetOwnerDTO.class))).thenReturn(petOwnerEntity);
        when(petOwnerDAO.save(any(PetOwner.class))).thenReturn(petOwnerEntityResponse);
        when(petOwnerMapper.petOwnerEntityToDTO(any(PetOwner.class))).thenReturn(petOwnerDTOResponse);

        PetOwnerDTO response = petOwnerService.updatePetOwner(1L,petOwnerDTORequest);

        assertNotNull(response);
        assertEquals(response, petOwnerDTOResponse);
        assertEquals(response.getName(), petOwnerDTOResponse.getName());
        assertEquals(response.getAddress(), petOwnerDTOResponse.getAddress());
        assertEquals(response.getPhoneNumber(), petOwnerDTOResponse.getPhoneNumber());

        Mockito.verify(petOwnerMapper, times(1)).petOwnerDTOToEntity((any(PetOwnerDTO.class)));
        Mockito.verify(petOwnerDAO, times(1)).save((any(PetOwner.class)));
        Mockito.verify(petOwnerMapper, times(2)).petOwnerEntityToDTO((any(PetOwner.class)));
    }

}
