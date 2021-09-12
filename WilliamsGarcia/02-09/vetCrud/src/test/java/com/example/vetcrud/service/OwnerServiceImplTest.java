package com.example.vetcrud.service;

import com.example.vetcrud.dao.OwnerDAO;
import com.example.vetcrud.dto.OwnerDTO;
import com.example.vetcrud.entity.Owner;
import com.example.vetcrud.exception.EmptyListException;
import com.example.vetcrud.exception.NotFoundException;
import com.example.vetcrud.mapper.OwnerMapper;
import com.example.vetcrud.service.impl.OwnerServiceImpl;

import static com.example.vetcrud.utiloftest.ConstantsOfTest.ONE_EXECUTED;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.TWO_EXECUTED;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.OWNER_ID;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.generateOwner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OwnerServiceImplTest {

    @InjectMocks
    private OwnerServiceImpl ownerService;

    @Mock
    private OwnerDAO ownerDAO;

    @Mock
    private OwnerMapper ownerMapper;

    @Test
    public void getAllOwnersTestSuccess() {
        List<Owner> ownerList = generateOwner.createOwnerList();
        List<OwnerDTO> ownerDTOList = generateOwner.createOwnerDTOList();

        when(ownerDAO.findAll()).thenReturn(ownerList);
        when(ownerMapper.ownerListToDTO(ownerList)).thenReturn(ownerDTOList);

        List<OwnerDTO> ownerDTOListResponse = ownerService.getAllOwners();
        assertNotNull(ownerDTOListResponse);

        verify(ownerMapper, times(ONE_EXECUTED)).ownerListToDTO(ownerList);
    }

    @Test(expected = EmptyListException.class)
    public void getAllOwnersTestFailure() {
        List<Owner> ownerList = new ArrayList<>();

        when(ownerDAO.findAll()).thenReturn(ownerList);
        ownerService.getAllOwners();
    }

    @Test
    public void createOwnerTestSuccess() {
        Owner ownerEntry = generateOwner.createOwner(null);
        Owner ownerGenerated = generateOwner.createOwner(OWNER_ID.longValue());

        OwnerDTO ownerDTOEntry = generateOwner.createOwnerDTO(null);
        OwnerDTO ownerDTOGenerated = generateOwner.createOwnerDTO(OWNER_ID.longValue());

        when(ownerMapper.ownerDTOToOwner(ownerDTOEntry)).thenReturn(ownerEntry);
        when(ownerDAO.save(ownerEntry)).thenReturn(ownerGenerated);
        when(ownerMapper.ownerToDTO(ownerGenerated)).thenReturn(ownerDTOGenerated);

        OwnerDTO ownerDTOResponse = ownerService.createOwner(ownerDTOEntry);

        assertNotNull(ownerDTOResponse);
        assertEquals(ownerDTOGenerated, ownerDTOResponse);
        verify(ownerMapper, times(ONE_EXECUTED)).ownerDTOToOwner(any(OwnerDTO.class));
        verify(ownerMapper, times(ONE_EXECUTED)).ownerToDTO(any(Owner.class));
        verify(ownerDAO, times(ONE_EXECUTED)).save(any(Owner.class));
    }

    @Test
    public void updateOwnerTestSuccess() {
        Owner ownerEntry = generateOwner.createOwner(OWNER_ID.longValue());
        Owner ownerGenerated = generateOwner.createOwner(OWNER_ID.longValue());

        OwnerDTO ownerDTOEntry = generateOwner.createOwnerDTO(OWNER_ID.longValue());
        OwnerDTO ownerDTOGenerated = generateOwner.createOwnerDTO(OWNER_ID.longValue());

        when(ownerDAO.existsById(OWNER_ID.longValue())).thenReturn(Boolean.TRUE);
        when(ownerMapper.ownerDTOToOwner(ownerDTOEntry)).thenReturn(ownerEntry);
        when(ownerDAO.save(ownerEntry)).thenReturn(ownerGenerated);
        when(ownerMapper.ownerToDTO(ownerGenerated)).thenReturn(ownerDTOGenerated);

        OwnerDTO ownerDTOResponse = ownerService.updateOwner(ownerDTOEntry, OWNER_ID);
        assertNotNull(ownerDTOGenerated);
        assertEquals(ownerDTOResponse, ownerDTOGenerated);
        verify(ownerMapper, times(ONE_EXECUTED)).ownerDTOToOwner(ownerDTOEntry);
        verify(ownerDAO, times(ONE_EXECUTED)).save(ownerEntry);
        verify(ownerMapper, times(ONE_EXECUTED)).ownerToDTO(ownerGenerated);
    }

    @Test(expected = NotFoundException.class)
    public void updateOwnerTestFailure() {
        when(ownerDAO.existsById(OWNER_ID.longValue())).thenReturn(Boolean.FALSE);
        ownerService.updateOwner(null, OWNER_ID);
    }

    @Test
    public void getOwnerByIdTestSuccess() {
        Owner owner = generateOwner.createOwner(OWNER_ID.longValue());
        OwnerDTO ownerDTO = generateOwner.createOwnerDTO(OWNER_ID.longValue());

        when(ownerDAO.existsById(OWNER_ID.longValue())).thenReturn(Boolean.TRUE);
        when(ownerDAO.getById(OWNER_ID.longValue())).thenReturn(owner);
        when(ownerService.getOwnerById(OWNER_ID)).thenReturn(ownerDTO);

        OwnerDTO ownerDTOResponse = ownerService.getOwnerById(OWNER_ID);
        assertNotNull(ownerDTOResponse);
        assertEquals(ownerDTO, ownerDTOResponse);
        verify(ownerDAO, times(TWO_EXECUTED)).getById(OWNER_ID.longValue());
        verify(ownerMapper, times(ONE_EXECUTED)).ownerToDTO(owner);
    }

    @Test(expected = NotFoundException.class)
    public void getOwnerByIdTestFailure() {
        when(ownerDAO.existsById(OWNER_ID.longValue())).thenReturn(Boolean.FALSE);

        ownerService.getOwnerById(OWNER_ID);
    }

    @Test
    public void deleteOwnerTestSuccess() {
        Owner owner = generateOwner.createOwner(OWNER_ID.longValue());
        Owner ownerSimulatorDelete = generateOwner.createOwner(OWNER_ID.longValue());

        when(ownerDAO.existsById(OWNER_ID.longValue())).thenReturn(Boolean.TRUE);
        when(ownerDAO.getById(any(long.class))).thenReturn(ownerSimulatorDelete);
        when(ownerDAO.getById(any(long.class))).thenReturn(owner);

        ownerService.deleteOwner(OWNER_ID);

        verify(ownerDAO, times(ONE_EXECUTED)).getById(any(long.class));
    }

    @Test(expected = NotFoundException.class)
    public void deleteOwnerTestFailure() {
        when(ownerDAO.existsById(OWNER_ID.longValue())).thenReturn(Boolean.FALSE);

        ownerService.deleteOwner(OWNER_ID);
    }
}
