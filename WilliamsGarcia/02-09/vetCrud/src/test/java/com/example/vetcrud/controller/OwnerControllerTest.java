package com.example.vetcrud.controller;

import com.example.vetcrud.dto.OwnerDTO;
import com.example.vetcrud.dto.ResponseDTO;
import com.example.vetcrud.exception.NotFoundException;
import com.example.vetcrud.service.OwnerService;
import com.sun.media.sound.InvalidDataException;
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

import java.util.List;

import static com.example.vetcrud.utiloftest.ConstantsOfTest.ONE_EXECUTED;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.OWNER_ID;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.generateOwner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OwnerControllerTest {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerService ownerService;

    @Test
    public void getAllOwnersTestSuccess() {
        List<OwnerDTO> ownerDTOList = generateOwner.createOwnerDTOList();

        when(ownerService.getAllOwners()).thenReturn(ownerDTOList);

        ResponseEntity<ResponseDTO<OwnerDTO>> responseEntity = ownerController.getAllOwners();

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(ownerService, times(ONE_EXECUTED)).getAllOwners();
    }

    @Test
    public void getOwnerByIdTestSuccess() throws NotFoundException {
        OwnerDTO ownerDTO = generateOwner.createOwnerDTO(OWNER_ID.longValue());

        when(ownerService.getOwnerById(OWNER_ID)).thenReturn(ownerDTO);

        ResponseEntity<ResponseDTO<OwnerDTO>> responseEntity = ownerController.getOwnerById(OWNER_ID);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(ownerService, times(ONE_EXECUTED)).getOwnerById(OWNER_ID);
    }

    @Test
    public void registerOwnerTestSuccess() throws InvalidDataException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        OwnerDTO ownerDTO = generateOwner.createOwnerDTO(null);

        when(ownerService.createOwner(ownerDTO)).thenReturn(any(OwnerDTO.class));

        ResponseEntity<ResponseDTO<OwnerDTO>> responseEntity = ownerController.registerOwner(ownerDTO);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
        verify(ownerService, times(ONE_EXECUTED)).createOwner(any(OwnerDTO.class));
    }

    @Test
    public void updateOwnerTestSuccess() throws NotFoundException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        OwnerDTO ownerDTOEntry = generateOwner.createOwnerDTO(null);
        OwnerDTO ownerDTOGenerated = generateOwner.createOwnerDTO(OWNER_ID.longValue());

        when(ownerService.updateOwner(ownerDTOEntry, OWNER_ID)).thenReturn(ownerDTOGenerated);

        ResponseEntity<ResponseDTO<OwnerDTO>> responseEntity = ownerController.updateOwner(ownerDTOEntry, OWNER_ID);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(ownerService, times(ONE_EXECUTED)).updateOwner(any(OwnerDTO.class), any(Long.class));
    }

    @Test
    public void deleteOwnerTestSuccess() throws NotFoundException {
        ResponseEntity<ResponseDTO<OwnerDTO>> responseEntity = ownerController.deleteOwner(OWNER_ID);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(ownerService, times(ONE_EXECUTED)).deleteOwner(OWNER_ID);
    }

}
