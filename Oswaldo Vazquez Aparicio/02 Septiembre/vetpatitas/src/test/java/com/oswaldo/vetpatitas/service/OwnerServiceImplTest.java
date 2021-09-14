package com.oswaldo.vetpatitas.service;

import com.oswaldo.vetpatitas.dao.OwnerDAO;
import com.oswaldo.vetpatitas.dao.PetDAO;
import com.oswaldo.vetpatitas.dto.OwnerDTO;
import com.oswaldo.vetpatitas.dto.PetDTO;
import com.oswaldo.vetpatitas.entity.Owner;
import com.oswaldo.vetpatitas.entity.Pet;
import com.oswaldo.vetpatitas.exception.RecordAlreadyExistsException;
import com.oswaldo.vetpatitas.exception.RecordNotFoundException;
import com.oswaldo.vetpatitas.mapper.OwnerMapper;
import com.oswaldo.vetpatitas.mapper.PetMapper;
import com.oswaldo.vetpatitas.service.impl.OwnerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.oswaldo.vetpatitas.util.Util.createOwner;
import static com.oswaldo.vetpatitas.util.Util.createOwnerDTO;
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
public class OwnerServiceImplTest {

    @InjectMocks
    private OwnerServiceImpl ownerService;

    @Mock
    private OwnerDAO ownerDAO;
    @Mock
    private PetDAO petDAO;

    @Mock
    private OwnerMapper ownerMapper;
    @Mock
    private PetMapper petMapper;

    @Test
    public void addPetTest_whenPetDoesNotExists_Ok(){

        OwnerDTO ownerDTORequest = createOwnerDTO();
        ownerDTORequest.setId(null);

        Owner ownerRequest = createOwner();
        ownerRequest.setId(null);

        Owner ownerSaved = createOwner();

        OwnerDTO ownerDTOResponse = createOwnerDTO();

        when(ownerMapper.ownerDTOToEntity(any(OwnerDTO.class))).thenReturn(ownerRequest);
        when(ownerDAO.save(any(Owner.class))).thenReturn(ownerSaved);
        when(ownerMapper.ownerEntityToOwnerDTO(any(Owner.class))).thenReturn(ownerDTOResponse);

        OwnerDTO response = ownerService.add(ownerDTORequest);

        assertNotNull(response);
        assertEquals(response, ownerDTOResponse);

        verify(ownerMapper, times(1)).ownerDTOToEntity(any(OwnerDTO.class));
        verify(ownerDAO, times(1)).save(any(Owner.class));
        verify(ownerMapper, times(1)).ownerEntityToOwnerDTO(any(Owner.class));

    }

    @Test(expected = RecordAlreadyExistsException.class)
    public void addOwnerTest_whenOwnerAlreadyExistsException(){

        OwnerDTO ownerDTORequest = createOwnerDTO();

        Optional<Owner> optionalOwner = Optional.of(createOwner());

        when(ownerDAO.findById(any(Long.class))).thenReturn(optionalOwner);

        OwnerDTO ownerDTO = ownerService.add(ownerDTORequest);

        verify(ownerDAO, times(1)).findById(any(Long.class));

    }

    @Test
    public void addOwnerTest_whenOwnerHasIdAndDoesNotExists(){

        OwnerDTO ownerDTORequest = createOwnerDTO();

        Optional<Owner> optionalOwner = Optional.empty();

        Owner ownerRequest = createOwner();
        ownerRequest.setId(null);
        ownerRequest.setPetList(null);

        Owner ownerSaved = createOwner();
        ownerSaved.setPetList(null);

        OwnerDTO ownerDTOResponse = createOwnerDTO();

        when(ownerDAO.findById(any(Long.class))).thenReturn(optionalOwner);
        when(ownerMapper.ownerDTOToEntity(any(OwnerDTO.class))).thenReturn(ownerRequest);
        when(ownerDAO.save(any(Owner.class))).thenReturn(ownerSaved);
        when(ownerMapper.ownerEntityToOwnerDTO(any(Owner.class))).thenReturn(ownerDTOResponse);

        OwnerDTO response = ownerService.add(ownerDTORequest);

        assertNotNull(response);
        assertEquals(response, ownerDTOResponse);

        verify(ownerDAO, times(1)).findById(any(Long.class));
        verify(ownerMapper, times(1)).ownerDTOToEntity(any(OwnerDTO.class));
        verify(ownerDAO, times(1)).save(any(Owner.class));
        verify(ownerMapper, times(1)).ownerEntityToOwnerDTO(any(Owner.class));
    }

    @Test
    public void getOwnerTest_whenOwnerDoesNotExists(){

        Long id = 1L;

        Optional<Owner> optionalOwner = Optional.empty();

        when(ownerDAO.findById(any(Long.class))).thenReturn(optionalOwner);

        OwnerDTO response = ownerService.getById(id);

        assertNull(response);

        verify(ownerDAO, times(1)).findById(any(Long.class));

    }

    @Test
    public void getOwnerByIdTest_whenOwnerExists(){

        Long id = 1L;

        Optional<Owner> optionalOwner = Optional.of(createOwner());
        OwnerDTO ownerDTOResponse = createOwnerDTO();

        when(ownerDAO.findById(any(Long.class))).thenReturn(optionalOwner);
        when(ownerMapper.ownerEntityToOwnerDTO(any(Owner.class))).thenReturn(ownerDTOResponse);

        OwnerDTO response = ownerService.getById(id);

        assertNotNull(response);

        verify(ownerDAO, times(1)).findById(any(Long.class));
        verify(ownerMapper, times(1)).ownerEntityToOwnerDTO(any(Owner.class));

    }

    @Test
    public void getAllOwnerTest(){

        List<Owner> ownerList = new LinkedList<>();
        ownerList.add(createOwner());

        when(ownerDAO.findAll()).thenReturn(ownerList);
        when(ownerMapper.ownerEntityToOwnerDTO(any(Owner.class))).thenReturn(createOwnerDTO());

        List<OwnerDTO> ownerDTOList = ownerService.getAll();

        assertNotNull(ownerDTOList);

    }

    @Test(expected = RecordNotFoundException.class)
    public void updateOwnerData_whenOwnerDoesNotExists(){

        Long id = 1L;
        OwnerDTO ownerDTORequest = createOwnerDTO();
        ownerDTORequest.setId(null);
        ownerDTORequest.setPetList(null);

        Optional<Owner> optionalOwner = Optional.empty();

        when(ownerDAO.findById(any(Long.class))).thenReturn(optionalOwner);

        OwnerDTO response = ownerService.updateOwnerData(id, ownerDTORequest);

        verify(ownerDAO, times(1)).findById(any(Long.class));

    }

    @Test
    public void updateOwnerTest_whenOwnerExists(){

        Long id  = 1L;
        OwnerDTO ownerDTORequest = createOwnerDTO();
        ownerDTORequest.setId(null);
        ownerDTORequest.setPetList(null);

        Optional<Owner> optionalOwner = Optional.of(createOwner());

        Owner ownerRequest = createOwner();
        ownerRequest.setId(null);

        Owner ownerSaved = createOwner();
        OwnerDTO ownerDTOResponse = createOwnerDTO();

        when(ownerDAO.findById(any(Long.class))).thenReturn(optionalOwner);
        when(ownerMapper.ownerDTOToEntity(any(OwnerDTO.class))).thenReturn(ownerRequest);
        when(ownerDAO.save(any(Owner.class))).thenReturn(ownerSaved);
        when(ownerMapper.ownerEntityToOwnerDTO(any(Owner.class))).thenReturn(ownerDTOResponse);

        OwnerDTO response = ownerService.updateOwnerData(id, ownerDTORequest);

        assertNotNull(response);
        assertEquals(response, ownerDTOResponse);

        verify(ownerDAO, times(1)).findById(any(Long.class));
        verify(ownerMapper, times(1)).ownerDTOToEntity(any(OwnerDTO.class));
        verify(ownerDAO, times(1)).save(any(Owner.class));
        verify(ownerMapper, times(1)).ownerEntityToOwnerDTO(any(Owner.class));

    }

    @Test(expected = RecordNotFoundException.class)
    public void deleteOwner_whenOwnerDoesNotExists(){

        Long id = 1L;
        Optional<Owner> optionalOwner = Optional.empty();

        when(ownerDAO.findById(any(Long.class))).thenReturn(optionalOwner);

        ownerService.delete(id);

        verify(ownerDAO, times(1)).findById(any(Long.class));

    }

    @Test
    public void deleteOwner_whenOwnerExists(){

        Long id = 1L;
        Optional<Owner> optionalOwner = Optional.of(createOwner());

        when(ownerDAO.findById(any(Long.class))).thenReturn(optionalOwner);

        ownerService.delete(id);

        verify(ownerDAO, times(1)).findById(any(Long.class));

    }

    @Test(expected = RecordNotFoundException.class)
    public void assignPetToOwnerTest_whenOwnerDoesNotExists(){

        Long id = 1L;
        Optional<Owner> optionalOwner = Optional.empty();

        PetDTO petDTO = createPetDTO();

        when(ownerDAO.findById(any(Long.class))).thenReturn(optionalOwner);

        ownerService.assignPetToOwner(id, petDTO);

        verify(ownerDAO, times(1)).findById(any(Long.class));

    }

    @Test
    public void assignPetToOwnerTest_whenOwnerExists(){

        Long id = 1L;
        Owner owner = createOwner();

        List<Pet> petList = new LinkedList<>();
        owner.setPetList(petList);

        Optional<Owner> optionalOwner = Optional.of(owner);

        PetDTO petDTO = createPetDTO();
        petDTO.setId(null);
        Pet pet = createPet();

        Owner ownerSaved = createOwner();

        OwnerDTO ownerDTOResponse = createOwnerDTO();
        PetDTO petDTOResponse = createPetDTO();
        List<PetDTO> petDTOList = new LinkedList<>();
        petDTOList.add(petDTOResponse);
        ownerDTOResponse.setPetList(petDTOList);

        when(ownerDAO.findById(any(Long.class))).thenReturn(optionalOwner);
        when(petMapper.petDTOToEntity(any(PetDTO.class))).thenReturn(pet);
        when(petDAO.save(any(Pet.class))).thenReturn(pet);
        when(ownerDAO.save(any(Owner.class))).thenReturn(ownerSaved);
        when(ownerMapper.ownerEntityToOwnerDTO(any(Owner.class))).thenReturn(ownerDTOResponse);

        OwnerDTO response = ownerService.assignPetToOwner(id, petDTO);

        assertNotNull(response);

        verify(ownerDAO, times(1)).findById(any(Long.class));
        verify(petMapper, times(1)).petDTOToEntity(any(PetDTO.class));
        verify(petDAO, times(1)).save(any(Pet.class));
        verify(ownerDAO, times(1)).save(any(Owner.class));
        verify(ownerMapper, times(1)).ownerEntityToOwnerDTO(any(Owner.class));
    }





}
