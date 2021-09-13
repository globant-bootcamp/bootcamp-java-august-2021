package com.vetpatitas.veterinary.test;

import com.vetpatitas.veterinary.dao.OwnerDAO;
import com.vetpatitas.veterinary.dto.OwnerDTO;
import com.vetpatitas.veterinary.entity.Owner;
import com.vetpatitas.veterinary.exception.InvalidDataException;
import com.vetpatitas.veterinary.mapper.OwnerMapper;
import com.vetpatitas.veterinary.service.implementation.OwnerServiceImplementation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OwnerServiceImplTest {
    @InjectMocks
    private OwnerServiceImplementation ownerService;

    @Mock
    OwnerDAO ownerDAO;

    @Mock
    OwnerMapper ownerMapper;

    @Test
    public void addOwnerTest() {

        OwnerDTO ownerDTORequest = new OwnerDTO();
        ownerDTORequest.setId(1L);
        ownerDTORequest.setName("GENERIC NAME");
        ownerDTORequest.setEmail("GENERIC EMAIL");
        ownerDTORequest.setPhoneNumber("GENERIC PHONE Number");


        Owner ownerRequest = new Owner();
        ownerRequest.setId(1L);
        ownerRequest.setName("GENERIC NAME");
        ownerRequest.setEmail("GENERIC EMAIL");
        ownerRequest.setPhoneNumber("GENERIC PHONE Number");


        OwnerDTO ownerDTOResponse = new OwnerDTO();
        ownerDTOResponse.setId(1L);
        ownerDTOResponse.setName("GENERIC NAME");
        ownerDTOResponse.setEmail("GENERIC EMAIL");
        ownerDTOResponse.setPhoneNumber("GENERIC PHONE Number");

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setName("GENERIC NAME");
        owner.setEmail("GENERIC EMAIL");
        owner.setPhoneNumber("GENERIC PHONE Number");


        when(ownerMapper.ownerDTOToEntity(any(OwnerDTO.class))).thenReturn(ownerRequest);
        when(ownerDAO.save(any(Owner.class))).thenReturn(owner);
        when(ownerMapper.ownerEntityToDTO(any(Owner.class))).thenReturn(ownerDTOResponse);

        OwnerDTO response = ownerService.addOwner(ownerDTORequest);
        assertNotNull(response);
        assertEquals(response, ownerDTOResponse);
        assertEquals(response.getName(), ownerDTORequest.getName());

        Mockito.verify(ownerMapper, times(1)).ownerDTOToEntity(any(OwnerDTO.class));
        Mockito.verify(ownerDAO, times(1)).save(any(Owner.class));
        Mockito.verify(ownerMapper, times(1)).ownerEntityToDTO(any(Owner.class));
    }

    @Test
    public void selectOwnerTest() {

        OwnerDTO ownerDTORequest = new OwnerDTO();
        ownerDTORequest.setId(1L);
        ownerDTORequest.setName("GENERIC NAME");
        ownerDTORequest.setEmail("GENERIC EMAIL");
        ownerDTORequest.setPhoneNumber("GENERIC PHONE Number");


        Owner ownerRequest = new Owner();
        ownerRequest.setId(1L);
        ownerRequest.setName("GENERIC NAME");
        ownerRequest.setEmail("GENERIC EMAIL");
        ownerRequest.setPhoneNumber("GENERIC PHONE Number");


        OwnerDTO ownerDTOResponse = new OwnerDTO();
        ownerDTOResponse.setId(1L);
        ownerDTOResponse.setName("GENERIC NAME");
        ownerDTOResponse.setEmail("GENERIC EMAIL");
        ownerDTOResponse.setPhoneNumber("GENERIC PHONE Number");

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setName("GENERIC NAME");
        owner.setEmail("GENERIC EMAIL");
        owner.setPhoneNumber("GENERIC PHONE Number");


        when(ownerMapper.ownerDTOToEntity(any(OwnerDTO.class))).thenReturn(ownerRequest);
        when(ownerDAO.getById(ownerRequest.getId())).thenReturn(owner);
        when(ownerMapper.ownerEntityToDTO(any(Owner.class))).thenReturn(ownerDTOResponse);

        OwnerDTO response = ownerService.selectOwner(ownerDTORequest.getId());
        assertNotNull(response);
        assertEquals(response, ownerDTOResponse);
        assertEquals(response.getId(), ownerDTORequest.getId());

        Mockito.verify(ownerMapper, times(1)).ownerDTOToEntity(any(OwnerDTO.class));
        Mockito.verify(ownerDAO, times(1)).getById(ownerDTORequest.getId());
        Mockito.verify(ownerMapper, times(1)).ownerEntityToDTO(any(Owner.class));
    }

    @Test(expected = InvalidDataException.class)
    public void updateOwner() {

        OwnerDTO ownerDTORequest = new OwnerDTO();
        ownerDTORequest.setId(1L);
        ownerDTORequest.setName("GENERIC NAME");
        ownerDTORequest.setEmail("GENERIC EMAIL");
        ownerDTORequest.setPhoneNumber("GENERIC PHONE Number");


        OwnerDTO ownerDTOResponse = new OwnerDTO();
        ownerDTOResponse.setId(1L);
        ownerDTOResponse.setName("GENERIC NAME");
        ownerDTOResponse.setEmail("GENERIC EMAIL");
        ownerDTOResponse.setPhoneNumber("GENERIC PHONE Number");

        when(ownerService.editOwner(ownerDTORequest)).thenReturn(null);
        OwnerDTO response = ownerService.editOwner(ownerDTORequest);
        assertNotNull(response);
        assertNotEquals(ownerDTOResponse.getName(), response.getName());

    }

    @Test(expected = InvalidDataException.class)
    public void deleteOwner() {

        OwnerDTO ownerDTORequest = new OwnerDTO();
        ownerDTORequest.setId(1L);
        ownerDTORequest.setName("GENERIC NAME");
        ownerDTORequest.setEmail("GENERIC EMAIL");
        ownerDTORequest.setPhoneNumber("GENERIC PHONE Number");


        when(ownerService.deleteOwner(ownerDTORequest));
        OwnerDTO response = ownerService.deleteOwner(ownerDTORequest);
        assertNotNull(response);
    }
}
