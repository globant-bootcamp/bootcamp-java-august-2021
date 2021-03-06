package com.example.vetcrud.service;

import com.example.vetcrud.dao.OwnerDAO;
import com.example.vetcrud.dao.PetDAO;
import com.example.vetcrud.dto.PetDTO;
import com.example.vetcrud.entity.Pet;
import com.example.vetcrud.exception.EmptyListException;
import com.example.vetcrud.exception.NotFoundException;
import com.example.vetcrud.mapper.PetMapper;
import com.example.vetcrud.service.impl.PetServiceImpl;

import com.sun.media.sound.InvalidDataException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.example.vetcrud.utiloftest.ConstantsOfTest.ONE_EXECUTED;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.TWO_EXECUTED;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.OWNER_ID;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.PET_ID;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.generatePet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetServiceImplTest {

    @InjectMocks
    private PetServiceImpl petService;

    @Mock
    private PetDAO petDAO;

    @Mock
    private OwnerDAO ownerDAO;

    @Mock
    private PetMapper petMapper;

    @Test
    public void getPetsByOwnerTestSuccess() {
        List<Pet> petList = generatePet.createPetList();
        List<PetDTO> petDTOList = generatePet.createPetDTOList();

        when(petDAO.getPetsByOwner(ownerDAO.getById(OWNER_ID.longValue()))).thenReturn(petList);
        when(petMapper.petListToDTO(petList)).thenReturn(petDTOList);

        List<PetDTO> petDTOListResponse = petService.getPetsByOwner(OWNER_ID.longValue());
        assertNotNull(petDTOListResponse);
        verify(petMapper, times(ONE_EXECUTED)).petListToDTO(petList);
    }

    @Test(expected = EmptyListException.class)
    public void getPetsByOwnerTestFailure() {
        List<Pet> petList = new ArrayList<>();

        when(petDAO.getPetsByOwner(ownerDAO.getById(OWNER_ID.longValue()))).thenReturn(petList);
        petService.getPetsByOwner(OWNER_ID);
    }

    @Test
    public void getAllPetsTestSuccess() {
        List<Pet> petList = generatePet.createPetList();
        List<PetDTO> petDTOList = generatePet.createPetDTOList();

        when(petDAO.findAll()).thenReturn(petList);
        when(petMapper.petListToDTO(petList)).thenReturn(petDTOList);

        List<PetDTO> petDTOListResponse = petService.getAllPets();
        assertNotNull(petDTOListResponse);
        verify(petMapper, times(ONE_EXECUTED)).petListToDTO(petList);
    }

    @Test(expected = EmptyListException.class)
    public void getAllPetsTestFailure() {
        List<Pet> petList = new ArrayList<>();

        when(petDAO.findAll()).thenReturn(petList);
        petService.getAllPets();
    }

    @Test
    public void createPetTestSuccess() throws InvalidDataException {
        Pet petEntry = generatePet.createPet(null);
        Pet petGenerated = generatePet.createPet(PET_ID);

        PetDTO petDTOEntry = generatePet.createPetDTO(null);
        PetDTO petDTOGenerated = generatePet.createPetDTO(PET_ID);

        when(petMapper.petDTOToPet(petDTOEntry)).thenReturn(petEntry);
        when(petDAO.save(petEntry)).thenReturn(petGenerated);
        when(petMapper.petToDTO(petGenerated)).thenReturn(petDTOGenerated);

        PetDTO petDTOResponse = petService.createPet(petDTOEntry);

        assertNotNull(petDTOResponse);
        assertEquals(petDTOGenerated, petDTOResponse);
        verify(petMapper, times(ONE_EXECUTED)).petDTOToPet(any(PetDTO.class));
        verify(petMapper, times(ONE_EXECUTED)).petToDTO(any(Pet.class));
        verify(petDAO, times(ONE_EXECUTED)).save(any(Pet.class));
    }

    @Test
    public void updatePetTestSuccess() throws NotFoundException {
        Pet petEntry = generatePet.createPet(PET_ID);
        Pet petGenerated = generatePet.createPet(PET_ID);

        PetDTO petDTOEntry = generatePet.createPetDTO(PET_ID);
        PetDTO petDTOGenerated = generatePet.createPetDTO(PET_ID);

        when(petDAO.existsById(PET_ID)).thenReturn(Boolean.TRUE);
        when(petMapper.petDTOToPet(petDTOEntry)).thenReturn(petEntry);
        when(petDAO.save(petEntry)).thenReturn(petGenerated);
        when(petMapper.petToDTO(petGenerated)).thenReturn(petDTOGenerated);

        PetDTO petDTOResponse = petService.updatePet(petDTOEntry, PET_ID);
        assertNotNull(petDTOResponse);
        assertEquals(petDTOResponse, petDTOGenerated);
        verify(petMapper, times(ONE_EXECUTED)).petDTOToPet(petDTOEntry);
        verify(petDAO, times(ONE_EXECUTED)).save(petEntry);
        verify(petMapper, times(ONE_EXECUTED)).petToDTO(petGenerated);
    }

    @Test(expected = NotFoundException.class)
    public void updatePetTestFailure() throws NotFoundException {
        when(petDAO.existsById(PET_ID)).thenReturn(Boolean.FALSE);
        petService.updatePet(null, PET_ID);
    }

    @Test
    public void getPetByIdTestSuccess() throws NotFoundException {
        Pet pet = generatePet.createPet(PET_ID);
        PetDTO petDTO = generatePet.createPetDTO(PET_ID);

        when(petDAO.existsById(PET_ID)).thenReturn(Boolean.TRUE);
        when(petDAO.getById(PET_ID)).thenReturn(pet);
        when(petService.getPetById(PET_ID)).thenReturn(petDTO);

        PetDTO petDTOResponse = petService.getPetById(PET_ID);
        assertNotNull(petDTOResponse);
        assertEquals(petDTO, petDTOResponse);
        verify(petDAO, times(TWO_EXECUTED)).getById(PET_ID);
        verify(petMapper, times(ONE_EXECUTED)).petToDTO(pet);
    }

    @Test(expected = NotFoundException.class)
    public void getPetByIdTestFailure() throws NotFoundException {
        when(petDAO.existsById(PET_ID)).thenReturn(Boolean.FALSE);

        petService.getPetById(PET_ID);
    }

    @Test
    public void deletePetTestSuccess() throws NotFoundException {
        Pet pet = generatePet.createPet(PET_ID);
        Pet petSimulatorDelete = generatePet.createPet(PET_ID);

        when(petDAO.existsById(PET_ID)).thenReturn(Boolean.TRUE);
        when(petDAO.getById(any(long.class))).thenReturn(petSimulatorDelete);
        when(petDAO.getById(any(long.class))).thenReturn(pet);

        petService.deletePet(PET_ID);

        verify(petDAO, times(ONE_EXECUTED)).getById(any(long.class));
    }

    @Test(expected = NotFoundException.class)
    public void deletePetTestFailure() throws NotFoundException {
        when(petDAO.existsById(PET_ID)).thenReturn(Boolean.FALSE);

        petService.deletePet(PET_ID);
    }
}
