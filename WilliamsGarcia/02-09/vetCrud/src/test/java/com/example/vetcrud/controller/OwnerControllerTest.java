package com.example.vetcrud.controller;

import com.example.vetcrud.dao.OwnerDAO;
import com.example.vetcrud.dto.OwnerDTO;
import com.example.vetcrud.dto.ResponseDTO;
import com.example.vetcrud.service.OwnerService;
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
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class OwnerControllerTest {

    private final Long OWNER_ID = 1L;
    private static GenerateOwner generateOwner = new GenerateOwner();
    private static int ONE_EXECUTED = BigDecimal.ONE.intValue();

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
    public void getOwnerByIdTestSuccess() {
        OwnerDTO ownerDTO = generateOwner.createOwnerDTO(OWNER_ID);

        when(ownerService.getOwnerById(OWNER_ID)).thenReturn(ownerDTO);

        ResponseEntity<ResponseDTO<OwnerDTO>> responseEntity = ownerController.getOwnerById(OWNER_ID);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(ownerService, times(ONE_EXECUTED)).getOwnerById(OWNER_ID);
    }

    @Test
    public void registerOwnerTestSuccess() {
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
    public void updateOwnerTestSuccess() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        OwnerDTO ownerDTOEntry = generateOwner.createOwnerDTO(null);
        OwnerDTO ownerDTOGenerated = generateOwner.createOwnerDTO(OWNER_ID);

        when(ownerService.updateOwner(ownerDTOEntry, OWNER_ID)).thenReturn(ownerDTOGenerated);

        ResponseEntity<ResponseDTO<OwnerDTO>> responseEntity = ownerController.updateOwner(ownerDTOEntry, OWNER_ID);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(ownerService, times(ONE_EXECUTED)).updateOwner(any(OwnerDTO.class), any(Long.class));
    }

    @Test
    public void deleteOwnerTestSuccess() {
        when(ownerService.deleteOwner(OWNER_ID)).thenReturn(null);

        ResponseEntity<ResponseDTO<OwnerDTO>> responseEntity = ownerController.deleteOwner(OWNER_ID);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(ownerService, times(ONE_EXECUTED)).deleteOwner(OWNER_ID);
    }

}
