package com.oswaldo.vetpatitas.controller;

import com.oswaldo.vetpatitas.dto.PetDTO;
import com.oswaldo.vetpatitas.dto.ResponseDTO;
import com.oswaldo.vetpatitas.service.PetService;
import com.oswaldo.vetpatitas.util.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedList;
import java.util.List;

import static com.oswaldo.vetpatitas.util.Util.createPetDTO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetControllerTest {

    @InjectMocks
    private PetController petController;

    @Mock
    private PetService petService;

    @Test
    public void getPetTest_Ok(){

        PetDTO petDTO = createPetDTO();

        when(petService.getById(any(Long.class))).thenReturn(petDTO);

        ResponseEntity<ResponseDTO<PetDTO>> response = petController.getPet(petDTO.getId());

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getMessage(), Constants.PET_RETRIEVED_SUCCESS);

        verify(petService, times(1)).getById(any(Long.class));

    }

    @Test
    public void getAllPetsTest_Ok(){

        List<PetDTO> petDTOList = new LinkedList<>();

        when(petService.getAll()).thenReturn(petDTOList);

        ResponseEntity<ResponseDTO<List<PetDTO>>> response = petController.getAllPets();

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getMessage(), Constants.PET_ALL_RETRIEVED_SUCCESS);

        verify(petService, times(1)).getAll();
    }

    @Test
    public void createPetTest_Ok(){

        PetDTO petDTO = createPetDTO();

        when(petService.add(any(PetDTO.class))).thenReturn(petDTO);

        ResponseEntity<ResponseDTO<PetDTO>> response = petController.createPet(petDTO);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().getMessage(), Constants.PET_ADDED_SUCCESS);

        verify(petService, times(1)).add(any(PetDTO.class));

    }

    @Test
    public void updatePetTest_Ok(){

        PetDTO petDTO = createPetDTO();

        when(petService.update(any(Long.class), any(PetDTO.class))).thenReturn(petDTO);

        ResponseEntity<ResponseDTO<PetDTO>> response = petController.updatePet(petDTO.getId(), petDTO);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getMessage(), Constants.PET_UPDATED_SUCCESS);

        verify(petService, times(1)).update(any(Long.class), any(PetDTO.class));

    }

    @Test
    public void deletePetTest_Ok(){

        Long id = 1L;

        ResponseEntity<ResponseDTO<Void>> response = petController.deletePet(id);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
        assertEquals(response.getBody().getMessage(), Constants.PET_DELETED_SUCCESS);

    }



}
