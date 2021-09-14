package com.bolsadeideas.springboot.bootcamp.app.controllers;

import com.bolsadeideas.springboot.bootcamp.app.dto.RequestDTO;
import com.bolsadeideas.springboot.bootcamp.app.entity.Owner;
import com.bolsadeideas.springboot.bootcamp.app.entity.Response;
import com.bolsadeideas.springboot.bootcamp.app.exception.NotFoundException;
import com.bolsadeideas.springboot.bootcamp.app.service.InterfaceOwnerService;
import com.bolsadeideas.springboot.bootcamp.app.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.NO_FOUND_OWNER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OwnerControllerTests {

    private final Long ID_SUCCESS = 1L;
    private final Long ID_UNSUCCESSFUL = 2L;
    private final int NUMBER_INVOCATIONS_ONE = 1;

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private InterfaceOwnerService ownerService;

    @Test
    public void findAll_toListAllOwners(){
        Owner ownerOne = new Owner();
        ownerOne.setName("Pablo");
        ownerOne.setPhone("7771851777");

        Owner ownerTwo = new Owner();
        ownerTwo.setName("Tyrone");
        ownerTwo.setPhone("5551478965");

        PowerMockito.when(ownerService.findAll()).thenReturn(List.of(ownerOne, ownerTwo));

        List<Owner> ownerList = ownerController.findAll();

        assertNotNull(ownerList);
        assertEquals(ownerOne.getName(),ownerList.get(0).getName());
        verify(ownerService,times(NUMBER_INVOCATIONS_ONE)).findAll();
    }

    @Test
    public void findByIdOwner_findOwner_ok(){
        Owner owner = new Owner();
        owner.setName("Austin");
        owner.setPhone("7771851777");

        when(ownerService.findById(any(Long.class))).thenReturn(owner);

        ResponseEntity<Response<String>> responseEntity = ownerController.findByIdOwner(ID_SUCCESS);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.FOUND);
        verify(ownerService, times(NUMBER_INVOCATIONS_ONE)).findById(ID_SUCCESS);
    }

    @Test(expected = NotFoundException.class)
    public void findByIdOwner_findOwner_NotFoundException(){

        when(ownerService.findById(any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_OWNER));

        ResponseEntity<Response<String>> responseEntity = ownerController.findByIdOwner(ID_UNSUCCESSFUL);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
        verify(ownerService, times(NUMBER_INVOCATIONS_ONE)).findById(ID_UNSUCCESSFUL);
    }

    @Test
    public void add_addOwner(){
        Owner owner = new Owner();
        owner.setName("Austin");
        owner.setPhone("7771851777");
        RequestDTO requestDTO = new RequestDTO(owner);

        when(ownerService.save(any(RequestDTO.class))).thenReturn(owner);

        ResponseEntity<Response<String>> responseEntity = ownerController.add(requestDTO);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(),HttpStatus.CREATED);
        verify(ownerService, times(NUMBER_INVOCATIONS_ONE)).save(requestDTO);
    }

    @Test
    public void updateOwner_updateOwner_ok(){
        Owner owner = new Owner();
        owner.setName("Uniqua");
        owner.setPhone("7771851777");
        RequestDTO requestDTO = new RequestDTO(owner);

        when(ownerService.updateOwner(any(RequestDTO.class))).thenReturn(owner);

        ResponseEntity<Response<String>> responseEntity = ownerController.updateOwner(requestDTO);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(ownerService, times(NUMBER_INVOCATIONS_ONE)).updateOwner(requestDTO);
    }

    @Test(expected = NotFoundException.class)
    public void updateOwner_updateOwner_NotFoundException(){
        Owner owner = new Owner();
        owner.setName("Uniqua");
        owner.setPhone("7771851777");
        RequestDTO requestDTO = new RequestDTO(owner);

        when(ownerService.updateOwner(any(RequestDTO.class))).thenThrow(new NotFoundException(NO_FOUND_OWNER));

        ResponseEntity<Response<String>> responseEntity = ownerController.updateOwner(requestDTO);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
        verify(ownerService, times(NUMBER_INVOCATIONS_ONE)).updateOwner(requestDTO);
    }

    @Test
    public void deleteOwner_deleteOwner_ok(){
        Owner owner = new Owner();
        owner.setName("Tasha");
        owner.setPhone("7771851777");

        when(ownerService.deleteOwner(any(Long.class))).thenReturn(owner);

        ResponseEntity<Response<String>> responseEntity = ownerController.deleteOwner(ID_SUCCESS);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        verify(ownerService, times(NUMBER_INVOCATIONS_ONE)).deleteOwner(ID_SUCCESS);
    }

    @Test(expected = NotFoundException.class)
    public void deleteOwner_deleteOwner_notFoundException(){
        when(ownerService.deleteOwner(any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_OWNER));

        ResponseEntity<Response<String>> responseEntity = ownerController.deleteOwner(ID_UNSUCCESSFUL);

        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
        verify(ownerService, times(NUMBER_INVOCATIONS_ONE)).deleteOwner(ID_UNSUCCESSFUL);
    }
}
