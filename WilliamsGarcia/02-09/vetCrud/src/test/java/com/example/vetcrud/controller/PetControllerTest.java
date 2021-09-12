package com.example.vetcrud.controller;

import com.example.vetcrud.dto.OwnerDTO;
import com.example.vetcrud.dto.PetDTO;
import com.example.vetcrud.dto.ResponseDTO;
import com.example.vetcrud.service.PetService;
import com.example.vetcrud.utiloftest.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PetControllerTest {

    private final Long PET_ID = 1L;
    private final Long OWNER_ID = 1L;
    private static GeneratePet generatePet = new GeneratePet();
    private static int ONE_EXECUTED = BigDecimal.ONE.intValue();

    @InjectMocks
    private PetController petController;

    @Mock
    private PetService petService;

    @Test
    public void getAllPetsTestSuccess() {
        List<PetDTO> petDTOList = generatePet.createPetDTOList();

        when(petService.getAllPets()).thenReturn(petDTOList);

        ResponseEntity<ResponseDTO<PetDTO>> responseEntity = petController.getAllPets();

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(petService, times(ONE_EXECUTED)).getAllPets();
    }

    @Test
    public void getPetByIdTestSuccess() {
        PetDTO petDTO = generatePet.createPetDTO(PET_ID);

        when(petService.getPetById(PET_ID)).thenReturn(petDTO);

        ResponseEntity<ResponseDTO<PetDTO>> responseEntity = petController.getPetById(PET_ID);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(petService, times(ONE_EXECUTED)).getPetById(PET_ID);
    }

    @Test
    public void getPetByOwnerTestSuccess() {
        List<PetDTO> petDTOList = generatePet.createPetDTOList();

        when(petService.getPetsByOwner(OWNER_ID)).thenReturn(petDTOList);

        ResponseEntity<ResponseDTO<PetDTO>> responseEntity = petController.getPetsByOwner(OWNER_ID);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(petService, times(ONE_EXECUTED)).getPetsByOwner(OWNER_ID);
    }

    @Test
    public void registerPetTestSuccess() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        PetDTO petDTO = generatePet.createPetDTO(null);

        when(petService.createPet(petDTO)).thenReturn(any(PetDTO.class));

        ResponseEntity<ResponseDTO<PetDTO>> responseEntity = petController.registerPet(petDTO);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
        verify(petService, times(ONE_EXECUTED)).createPet(any(PetDTO.class));
    }

    @Test
    public void updatePetTestSuccess() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        PetDTO petDTOEntry = generatePet.createPetDTO(null);
        PetDTO petDTOGenerated = generatePet.createPetDTO(PET_ID);

        when(petService.updatePet(petDTOEntry, PET_ID)).thenReturn(petDTOGenerated);

        ResponseEntity<ResponseDTO<PetDTO>> responseEntity = petController.updatePet(petDTOEntry, PET_ID);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(petService, times(ONE_EXECUTED)).updatePet(any(PetDTO.class), any(Long.class));
    }

    @Test
    public void deletePetTestSuccess() {
        when(petService.deletePet(PET_ID)).thenReturn(null);

        ResponseEntity<ResponseDTO<PetDTO>> responseEntity = petController.deletePet(PET_ID);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(petService, times(ONE_EXECUTED)).deletePet(PET_ID);
    }
}
