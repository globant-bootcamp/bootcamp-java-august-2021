package com.example.vetcrud.mapper;

import com.example.vetcrud.dto.PetDTO;
import com.example.vetcrud.entity.Pet;
import com.example.vetcrud.utiloftest.GeneratePet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.example.vetcrud.utiloftest.ConstantsOfTest.ONE_EXECUTED;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.PET_ID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetMapperTest {

    @Mock
    private PetMapper petMapper;

    private static GeneratePet generatePet = new GeneratePet();

    @Test
    public void ownerToDTOTestSuccess() {
        Pet pet = generatePet.createPet(PET_ID);
        PetDTO petDTOGenerated = generatePet.createPetDTO(PET_ID);

        when(petMapper.petToDTO(pet)).thenReturn(petDTOGenerated);
        PetDTO petDTOResponse = petMapper.petToDTO(pet);
        assertNotNull(petDTOResponse);
        assertEquals(petDTOResponse, petDTOGenerated);
        verify(petMapper, times(ONE_EXECUTED)).petToDTO(pet);
    }

    @Test
    public void ownerDTOToOwnerTestSuccess() {
        Pet pet = generatePet.createPet(PET_ID);
        PetDTO petDTO = generatePet.createPetDTO(PET_ID);

        when(petMapper.petDTOToPet(petDTO)).thenReturn(pet);
        Pet petResponse = petMapper.petDTOToPet(petDTO);
        assertNotNull(petResponse);
        assertEquals(petResponse, pet);
        verify(petMapper, times(ONE_EXECUTED)).petDTOToPet(petDTO);
    }

    @Test
    public void ownerListToDTOSuccess() {
        List<PetDTO> petDTOList = generatePet.createPetDTOList();
        List<Pet> petList = generatePet.createPetList();

        when(petMapper.petListToDTO(petList)).thenReturn(petDTOList);
        List<PetDTO> petListDTOResponse = petMapper.petListToDTO(petList);
        assertNotNull(petListDTOResponse);
        assertEquals(petListDTOResponse, petDTOList);
        verify(petMapper, times(ONE_EXECUTED)).petListToDTO(petList);
    }

}
