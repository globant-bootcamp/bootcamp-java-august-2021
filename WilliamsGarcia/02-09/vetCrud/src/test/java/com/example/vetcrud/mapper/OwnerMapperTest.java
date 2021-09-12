package com.example.vetcrud.mapper;

import com.example.vetcrud.dto.OwnerDTO;
import com.example.vetcrud.entity.Owner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.vetcrud.utiloftest.GenerateOwner;

import java.util.List;

import static com.example.vetcrud.utiloftest.ConstantsOfTest.ONE_EXECUTED;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.OWNER_ID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OwnerMapperTest {

    @Mock
    private OwnerMapper ownerMapper;

    private static GenerateOwner generateOwner = new GenerateOwner();

    @Test
    public void ownerToDTOTestSuccess() {
        Owner owner = generateOwner.createOwner(OWNER_ID.longValue());
        OwnerDTO ownerDTOGenerated = generateOwner.createOwnerDTO(OWNER_ID.longValue());

        when(ownerMapper.ownerToDTO(owner)).thenReturn(ownerDTOGenerated);
        OwnerDTO ownerDTOResponse = ownerMapper.ownerToDTO(owner);
        assertNotNull(ownerDTOResponse);
        assertEquals(ownerDTOResponse, ownerDTOGenerated);
        verify(ownerMapper, times(ONE_EXECUTED)).ownerToDTO(owner);
    }

    @Test
    public void ownerDTOToOwnerTestSuccess() {
        Owner owner = generateOwner.createOwner(OWNER_ID.longValue());
        OwnerDTO ownerDTO = generateOwner.createOwnerDTO(OWNER_ID.longValue());

        when(ownerMapper.ownerDTOToOwner(ownerDTO)).thenReturn(owner);
        Owner ownerResponse = ownerMapper.ownerDTOToOwner(ownerDTO);
        assertNotNull(ownerResponse);
        assertEquals(ownerResponse, owner);
        verify(ownerMapper, times(ONE_EXECUTED)).ownerDTOToOwner(ownerDTO);
    }

    @Test
    public void ownerListToDTOSuccess() {
        List<OwnerDTO> ownerDTOList = generateOwner.createOwnerDTOList();
        List<Owner> ownerList = generateOwner.createOwnerList();

        when(ownerMapper.ownerListToDTO(ownerList)).thenReturn(ownerDTOList);
        List<OwnerDTO> ownerListDTOResponse = ownerMapper.ownerListToDTO(ownerList);
        assertNotNull(ownerListDTOResponse);
        assertEquals(ownerListDTOResponse, ownerDTOList);
        verify(ownerMapper, times(ONE_EXECUTED)).ownerListToDTO(ownerList);
    }
}
