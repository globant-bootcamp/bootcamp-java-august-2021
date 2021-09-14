package com.oswaldo.vetpatitas.controller;

import com.oswaldo.vetpatitas.dto.OwnerDTO;
import com.oswaldo.vetpatitas.dto.PetDTO;
import com.oswaldo.vetpatitas.dto.ResponseDTO;
import com.oswaldo.vetpatitas.service.OwnerService;
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

import static com.oswaldo.vetpatitas.util.Util.createOwnerDTO;
import static com.oswaldo.vetpatitas.util.Util.createPetDTO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OwnerControllerTest {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerService ownerService;

    @Test
    public void getOwnerTest_Ok(){

        OwnerDTO ownerDTO = createOwnerDTO();

        when(ownerService.getById(any(Long.class))).thenReturn(ownerDTO);

        ResponseEntity<ResponseDTO<OwnerDTO>> response =  ownerController.getOwner(ownerDTO.getId());

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getMessage(), Constants.OWNER_RETRIEVED_SUCCESS);

        verify(ownerService, times(1)).getById(any(Long.class));

    }

    @Test
    public void getAllOwnersTest_Ok(){


        List<OwnerDTO> ownerDTOList = new LinkedList<>();

        when(ownerService.getAll()).thenReturn(ownerDTOList);

        ResponseEntity<ResponseDTO<List<OwnerDTO>>> response = ownerController.getAllOwners();

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getMessage(), Constants.OWNER_ALL_RETRIEVED_SUCCESS);

        verify(ownerService, times(1)).getAll();

    }

    @Test
    public void createOwnerTest_Ok(){

        OwnerDTO ownerDTO = createOwnerDTO();

        when(ownerService.add(any(OwnerDTO.class))).thenReturn(ownerDTO);

        ResponseEntity<ResponseDTO<OwnerDTO>> response = ownerController.createOwner(ownerDTO);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().getMessage(), Constants.OWNER_ADDED_SUCCESS);

        verify(ownerService, times(1)).add(any(OwnerDTO.class));

    }

    @Test
    public void updateOwnerDataTest_Ok(){

        OwnerDTO ownerDTO = createOwnerDTO();

        when(ownerService.updateOwnerData(any(Long.class), any(OwnerDTO.class))).thenReturn(ownerDTO);

        ResponseEntity<ResponseDTO<OwnerDTO>> response = ownerController.updateOwner(ownerDTO.getId(), ownerDTO);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getMessage(), Constants.OWNER_UPDATED_SUCCESS);

        verify(ownerService, times(1)).updateOwnerData(any(Long.class), any(OwnerDTO.class));

    }

    @Test
    public void deleteOwnerTest_Ok(){

        Long id = 1L;

        ResponseEntity<ResponseDTO<Void>> response = ownerController.deleteOwner(id);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
        assertEquals(response.getBody().getMessage(), Constants.OWNER_DELETED_SUCCESS);

    }

    @Test
    public void assignPetToOwnerTest_Ok(){

        OwnerDTO ownerDTO = createOwnerDTO();
        PetDTO petDTO = createPetDTO();

        List<PetDTO> petDTOList = new LinkedList<>();
        petDTOList.add(petDTO);

        ownerDTO.setPetList(petDTOList);

        when(ownerService.assignPetToOwner(any(Long.class), any(PetDTO.class))).thenReturn(ownerDTO);

        ResponseEntity<ResponseDTO<OwnerDTO>> response = ownerController.assignPetToOwner(ownerDTO.getId(), petDTO);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);
        assertEquals(response.getBody().getMessage(), Constants.OWNER_PET_ASSIGNED_SUCCESS);

        verify(ownerService, times(1)).assignPetToOwner(any(Long.class), any(PetDTO.class));


    }


}
