package com.oswaldo.vetpatitas.service;

import com.oswaldo.vetpatitas.dao.PetDAO;
import com.oswaldo.vetpatitas.dto.PetDTO;
import com.oswaldo.vetpatitas.entity.Pet;
import com.oswaldo.vetpatitas.exception.RecordAlreadyExistsException;
import com.oswaldo.vetpatitas.exception.RecordNotFoundException;
import com.oswaldo.vetpatitas.mapper.PetMapper;
import com.oswaldo.vetpatitas.service.impl.PetServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.oswaldo.vetpatitas.util.Util.createPet;
import static com.oswaldo.vetpatitas.util.Util.createPetDTO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetServiceImplTest {

    @InjectMocks
    private PetServiceImpl petService;

    @Mock
    PetMapper petMapper;

    @Mock
    PetDAO petDAO;

    @Test
    public void addPetTest_whenPetDoesNotExists_Ok(){

        PetDTO petDTORequest = createPetDTO();
        petDTORequest.setId(null);

        Pet petRequest = createPet();
        petRequest.setId(null);

        Pet petSaved = createPet();

        PetDTO petDTOResponse = createPetDTO();

        when(petMapper.petDTOToEntity(any(PetDTO.class))).thenReturn(petRequest);
        when(petDAO.save(any(Pet.class))).thenReturn(petSaved);
        when(petMapper.petEntityToPetDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.add(petDTORequest);

        assertNotNull(response);
        assertEquals(response, petDTOResponse);

        verify(petMapper, times(1)).petDTOToEntity(any(PetDTO.class));
        verify(petDAO, times(1)).save(any(Pet.class));
        verify(petMapper, times(1)).petEntityToPetDTO(any(Pet.class));

    }

    @Test(expected = RecordAlreadyExistsException.class)
    public void addPetTest_whenPetAlreadyExistsException(){

        PetDTO petDTORequest = createPetDTO();

        Optional<Pet> optionalPet = Optional.of(createPet());

        when(petDAO.findById(any(Long.class))).thenReturn(optionalPet);

        PetDTO response = petService.add(petDTORequest);

        verify(petDAO, times(1)).findById(any(Long.class));

    }

    @Test
    public void addPetTest_whenPetHasIdAndDoesNotExists(){

        PetDTO petDTORequest = createPetDTO();

        Optional<Pet> optionalPet = Optional.empty();

        Pet petRequest = createPet();
        petRequest.setId(null);

        Pet petSaved = createPet();

        PetDTO petDTOResponse = createPetDTO();

        when(petDAO.findById(any(Long.class))).thenReturn(optionalPet);
        when(petMapper.petDTOToEntity(any(PetDTO.class))).thenReturn(petRequest);
        when(petDAO.save(any(Pet.class))).thenReturn(petSaved);
        when(petMapper.petEntityToPetDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.add(petDTORequest);

        assertNotNull(response);
        assertEquals(response, petDTOResponse);

        verify(petDAO, times(1)).findById(any(Long.class));
        verify(petMapper, times(1)).petDTOToEntity(any(PetDTO.class));
        verify(petDAO, times(1)).save(any(Pet.class));
        verify(petMapper, times(1)).petEntityToPetDTO(any(Pet.class));

    }

    @Test
    public void getPetByIdTest_whenPetExists(){

        Long id = 1L;

        Optional<Pet> optionalPet = Optional.of(createPet());
        PetDTO petDTOResponse = createPetDTO();

        when(petDAO.findById(any(Long.class))).thenReturn(optionalPet);
        when(petMapper.petEntityToPetDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.getById(id);

        assertNotNull(response);

        verify(petDAO, times(1)).findById(any(Long.class));
        verify(petMapper, times(1)).petEntityToPetDTO(any(Pet.class));

    }

    @Test
    public void getPetByIdTest_whenPetDoesNotExists(){

        Long id = 1L;

        Optional<Pet> optionalPet = Optional.empty();

        when(petDAO.findById(any(Long.class))).thenReturn(optionalPet);

        PetDTO response = petService.getById(id);

        assertNull(response);

        verify(petDAO, times(1)).findById(any(Long.class));

    }

    @Test
    public void getAllPetsTest(){

        List<Pet> petList = new LinkedList<>();
        petList.add(createPet());

        when(petDAO.findAll()).thenReturn(petList);
        when(petMapper.petEntityToPetDTO(any(Pet.class))).thenReturn(createPetDTO());

        List<PetDTO> petDAOList = petService.getAll();

        assertNotNull(petDAOList);

    }

    @Test(expected = RecordNotFoundException.class)
    public void updatePetTest_whenDoesNotExists(){

        Long id = 1L;
        PetDTO petDTO = createPetDTO();
        petDTO.setId(null);

        Optional<Pet> optionalPet = Optional.empty();

        when(petDAO.findById(any(Long.class))).thenReturn(optionalPet);

        PetDTO response = petService.update(id, petDTO);

        verify(petDAO, times(1)).findById(any(Long.class));
    }

    @Test
    public void updatePetTest_whenPetExists(){

        PetDTO petDTORequest = createPetDTO();
        Optional<Pet> optionalPet = Optional.of(createPet());
        Pet petRequest = createPet();
        PetDTO petDTOResponse = createPetDTO();

        when(petDAO.findById(any(Long.class))).thenReturn(optionalPet);
        when(petMapper.petDTOToEntity(any(PetDTO.class))).thenReturn(petRequest);
        when(petDAO.save(any(Pet.class))).thenReturn(petRequest);
        when(petMapper.petEntityToPetDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.update(petDTORequest.getId(), petDTORequest);

        assertNotNull(response);
        assertEquals(response, petDTOResponse);

        verify(petDAO, times(1)).findById(any(Long.class));
        verify(petMapper, times(1)).petDTOToEntity(any(PetDTO.class));
        verify(petDAO, times(1)).save(any(Pet.class));
        verify(petMapper, times(1)).petEntityToPetDTO(any(Pet.class));

    }

    @Test(expected = RecordNotFoundException.class)
    public void deletePetTest_whenPetDoesNotExists(){

        Long id = 1L;

        Optional<Pet> optionalPet = Optional.empty();

        when(petDAO.findById(any(Long.class))).thenReturn(optionalPet);

        petService.delete(id);

        verify(petDAO, times(1)).findById(any(Long.class));

    }

    @Test
    public void deletePetTest_whenPetExists(){

        Long id = 1L;

        Optional<Pet> optionalPet = Optional.of(createPet());

        when(petDAO.findById(any(Long.class))).thenReturn(optionalPet);

        petService.delete(id);

        verify(petDAO, times(1)).findById(any(Long.class));

    }


}
