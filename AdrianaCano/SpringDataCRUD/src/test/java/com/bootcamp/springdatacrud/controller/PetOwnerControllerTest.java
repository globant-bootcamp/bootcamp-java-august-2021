package com.bootcamp.springdatacrud.controller;

import com.bootcamp.springdatacrud.dto.PetOwnerDTO;
import com.bootcamp.springdatacrud.dto.ResponseDTO;
import com.bootcamp.springdatacrud.entity.PetOwner;
import com.bootcamp.springdatacrud.service.PetOwnerService;
import com.bootcamp.springdatacrud.service.impl.PetOwnerServiceImpl;
import org.apache.catalina.connector.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class PetOwnerControllerTest {

    @InjectMocks
    private PetOwnerServiceImpl petOwnerService;

    @Mock
    PetOwnerController petOwnerController = new PetOwnerController();

    @Test
    public void addPetOwnerTest_addPetOwner(){
        PetOwnerDTO petOwnerDTO = new PetOwnerDTO();
        PetOwnerDTO petOwnerSpy = spy(petOwnerDTO);
        petOwnerSpy.setId(1L);
        petOwnerSpy.setName("GenericName");
        petOwnerSpy.setPhoneNumber("6655443322");
        petOwnerSpy.setAddress("GenericName");

        when(petOwnerService.addPetOwner(any(PetOwnerDTO.class))).thenReturn(petOwnerSpy);

        ResponseEntity<ResponseDTO<PetOwnerDTO>>  responseEntity = petOwnerController.addPetOwner(petOwnerDTO);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }
}
