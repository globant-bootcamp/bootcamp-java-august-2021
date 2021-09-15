package com.example.globant.springdataproject.controller;

import com.example.globant.springdataproject.dto.PetDTO;
import com.example.globant.springdataproject.dto.ResponseDTO;
import com.example.globant.springdataproject.service.PetService;
import com.example.globant.springdataproject.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static com.example.globant.springdataproject.utils.Constants.PET_ADDED_SUCCESSFULLY;
import static com.example.globant.springdataproject.utils.Constants.PET_DELETED_SUCCESSFULLY;
import static com.example.globant.springdataproject.utils.Constants.PET_EDITED_SUCCESSFULLY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetControllerTest {

    @InjectMocks
    private PetController petController;

    @Mock
    private PetService petService;

    @Test
    public void addPetTest_OK() {
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setNameOfPet("Pet name");
        petDTORequest.setBreed("breed");
        petDTORequest.setSpecies("Species");
        petDTORequest.setDateOfBirth("2021-07-12");
        petDTORequest.setClientId(1L);

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setNameOfPet("Pet name");
        petDTOResponse.setBreed("breed");
        petDTOResponse.setSpecies("Species");
        petDTOResponse.setDateOfBirth("2021-07-12");
        petDTOResponse.setClientId(1L);

        when(petService.addPet(any(PetDTO.class))).thenReturn(petDTOResponse);

        ResponseEntity<ResponseDTO<PetDTO>> response = petController.addPet(petDTORequest);

        assertNotNull(response);

        assertEquals(response.getBody().getResponseConstants(), Constants.ResponseConstants.SUCCESS);
        assertEquals(response.getBody().getMessage(), PET_ADDED_SUCCESSFULLY);
        assertEquals(response.getBody().getContent().getId(), petDTORequest.getId());
        assertEquals(response.getBody().getContent().getNameOfPet(), petDTORequest.getNameOfPet());
        assertEquals(response.getBody().getContent().getBreed(), petDTORequest.getBreed());
        assertEquals(response.getBody().getContent().getSpecies(), petDTORequest.getSpecies());
        assertEquals(response.getBody().getContent().getDateOfBirth(), petDTORequest.getDateOfBirth());
        assertEquals(response.getBody().getContent().getClientId(), petDTORequest.getClientId());

        Mockito.verify(petService, times(1)).addPet(any(PetDTO.class));
    }

    @Test
    public void getPetsTest_OK() {
        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setNameOfPet("Pet name");
        petDTOResponse.setBreed("breed");
        petDTOResponse.setSpecies("Species");
        petDTOResponse.setDateOfBirth("2021-07-12");
        petDTOResponse.setClientId(1L);

        List<PetDTO> petsDTOResponse = new ArrayList<>();
        petsDTOResponse.add(petDTOResponse);

        when(petService.getPets()).thenReturn(petsDTOResponse);

        ResponseEntity<ResponseDTO<List<PetDTO>>> response = petController.getPets();

        assertNotNull(response);

        assertEquals(response.getBody().getResponseConstants(), Constants.ResponseConstants.SUCCESS);
        assertEquals(response.getBody().getMessage(), "");
        assertEquals(response.getBody().getContent(), petsDTOResponse);
        assertEquals(response.getBody().getContent().size(), 1);

        Mockito.verify(petService, times(1)).getPets();
    }

    @Test
    public void getPetByIDTest_OK() {
        Long idRequest = 1L;

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setNameOfPet("Name of pet");
        petDTOResponse.setSpecies("Species of pet");
        petDTOResponse.setBreed("Breed of pet");
        petDTOResponse.setDateOfBirth("2021-07-12");
        petDTOResponse.setClientId(1L);

        when(petService.getPetByID(any(Long.class))).thenReturn(petDTOResponse);

        ResponseEntity<ResponseDTO<PetDTO>> response = petController.getPetByID(idRequest);

        assertNotNull(response);

        assertEquals(response.getBody().getResponseConstants(), Constants.ResponseConstants.SUCCESS);
        assertEquals(response.getBody().getMessage(), "");
        assertEquals(response.getBody().getContent(), petDTOResponse);
        assertEquals(response.getBody().getContent().getId(), idRequest);

        Mockito.verify(petService, times(1)).getPetByID(any(Long.class));
    }

    @Test
    public void deletePetByIDTest_OK() {
        Long idRequest = 1L;

        ResponseEntity<ResponseDTO<PetDTO>> response = petController.deletePetByID(idRequest);

        assertNotNull(response);

        assertEquals(response.getBody().getResponseConstants(), Constants.ResponseConstants.SUCCESS);
        assertEquals(response.getBody().getMessage(), PET_DELETED_SUCCESSFULLY);
        assertEquals(response.getBody().getContent(), null);

        Mockito.verify(petService, times(1)).deletePetByID(any(Long.class));
    }

    @Test
    public void editPetByIDTest_OK() {
        Long idRequest = 1L;
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setNameOfPet("Pet");
        petDTORequest.setBreed("Pet breed");
        petDTORequest.setSpecies("Pet species");

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setNameOfPet("Pet");
        petDTOResponse.setBreed("Pet breed");
        petDTOResponse.setSpecies("Pet species");
        petDTOResponse.setDateOfBirth("2021-07-12");
        petDTOResponse.setClientId(1L);

        when(petService.editPetByID(any(Long.class), any(PetDTO.class))).thenReturn(petDTOResponse);

        ResponseEntity<ResponseDTO<PetDTO>> response = petController.editPetByID(idRequest, petDTORequest);

        assertNotNull(response);

        assertEquals(response.getBody().getResponseConstants(), Constants.ResponseConstants.SUCCESS);
        assertEquals(response.getBody().getMessage(), PET_EDITED_SUCCESSFULLY);
        assertEquals(response.getBody().getContent(), petDTOResponse);
        assertEquals(response.getBody().getContent().getId(), idRequest);
        assertEquals(response.getBody().getContent().getNameOfPet(), petDTORequest.getNameOfPet());
        assertEquals(response.getBody().getContent().getBreed(), petDTORequest.getBreed());

        Mockito.verify(petService, times(1)).editPetByID(any(Long.class), any(PetDTO.class));
    }
}
