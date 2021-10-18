package com.globant.vetpatitas.service;

import com.globant.vetpatitas.dao.PetDAO;
import com.globant.vetpatitas.dto.PetDTO;
import com.globant.vetpatitas.entity.Pet;
import com.globant.vetpatitas.exception.InvalidDeactivationRequest;
import com.globant.vetpatitas.exception.NonexistentPetException;
import com.globant.vetpatitas.mapper.PetMapper;
import com.globant.vetpatitas.service.impl.PetServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetServiceImplTest {

    @InjectMocks
    private PetServiceImpl petService;

    @Mock
    private PetMapper petMapper;

    @Mock
    private PetDAO petDAO;

    @Test
    public void getPet_OK(){
        Long id = 1L;

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setName("GenericName");
        petDTOResponse.setOwnerFirstName("GenericFirstName");
        petDTOResponse.setOwnerLastName("GenericLastName");
        petDTOResponse.setOwnerPhoneNumber("PhoneNumber");
        petDTOResponse.setAdmitted(Boolean.FALSE);
        petDTOResponse.setActive(Boolean.TRUE);

        Pet petResponse = new Pet();
        petResponse.setId(1L);
        petResponse.setName("GenericName");
        petResponse.setOwnerFirstName("GenericFirstName");
        petResponse.setOwnerLastName("GenericLastName");
        petResponse.setOwnerPhoneNumber("PhoneNumber");
        petResponse.setAdmitted(Boolean.FALSE);
        petResponse.setActive(Boolean.TRUE);

        Pet petRequest = new Pet();
        petRequest.setId(1L);
        petRequest.setName("GenericName");
        petRequest.setOwnerFirstName("GenericFirstName");
        petRequest.setOwnerLastName("GenericLastName");
        petRequest.setOwnerPhoneNumber("PhoneNumber");
        petRequest.setActive(Boolean.TRUE);
        petRequest.setAdmitted(Boolean.TRUE);

        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);
        when(petDAO.getPetById(any(Long.class))).thenReturn(petRequest);

        PetDTO petDTO = petService.getPet(id);
        assertNotNull(petDTO);
        assertEquals(petDTO, petDTOResponse);


    }

    @Test(expected = NonexistentPetException.class)
    public void findPet_NonexistentPet_ThenNonexistentPetException() {
        Long id = -1L;

        when(petDAO.getPetById(any(Long.class))).thenThrow(NullPointerException.class);
        Pet pet = petService.findPet(id);
    }

    @Test
    public void addPet_OK() {
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setName("GenericName");
        petDTORequest.setOwnerFirstName("GenericFirstName");
        petDTORequest.setOwnerLastName("GenericLastName");
        petDTORequest.setOwnerPhoneNumber("PhoneNumber");
        petDTORequest.setAdmitted(Boolean.FALSE);
        petDTORequest.setActive(Boolean.TRUE);

        Pet petRequest = new Pet();
        petRequest.setId(1L);
        petRequest.setName("GenericName");
        petRequest.setOwnerFirstName("GenericFirstName");
        petRequest.setOwnerLastName("GenericLastName");
        petRequest.setOwnerPhoneNumber("PhoneNumber");
        petRequest.setAdmitted(Boolean.FALSE);
        petRequest.setActive(Boolean.TRUE);

        Pet petResponse = new Pet();
        petResponse.setId(1L);
        petResponse.setName("GenericName");
        petResponse.setOwnerFirstName("GenericFirstName");
        petResponse.setOwnerLastName("GenericLastName");
        petResponse.setOwnerPhoneNumber("PhoneNumber");
        petResponse.setAdmitted(Boolean.FALSE);
        petResponse.setActive(Boolean.TRUE);

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setName("GenericName");
        petDTOResponse.setOwnerFirstName("GenericFirstName");
        petDTOResponse.setOwnerLastName("GenericLastName");
        petDTOResponse.setOwnerPhoneNumber("PhoneNumber");
        petDTOResponse.setAdmitted(Boolean.FALSE);
        petDTOResponse.setActive(Boolean.TRUE);


        when(petMapper.petDTOToEntity(any(PetDTO.class))).thenReturn(petResponse);
        when(petDAO.save(any(Pet.class))).thenReturn(petResponse);
        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);


        PetDTO response = petService.addPet(petDTORequest);
        assertNotNull(response);
        assertEquals(response, petDTOResponse);

        Mockito.verify(petMapper, times(1)).petDTOToEntity(any(PetDTO.class));
        Mockito.verify(petDAO, times(1)).save(any(Pet.class));
        Mockito.verify(petMapper, times(1)).petEntityToDTO(any(Pet.class));

    }

    @Test(expected = InvalidDeactivationRequest.class)
    public void updatePet_deactivateWhileAdmitted_ThenInvalidDeactivationRequest() {
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setName("GenericName");
        petDTORequest.setOwnerFirstName("GenericFirstName");
        petDTORequest.setOwnerLastName("GenericLastName");
        petDTORequest.setOwnerPhoneNumber("PhoneNumber");
        petDTORequest.setAdmitted(Boolean.TRUE);
        petDTORequest.setActive(Boolean.FALSE);

        Pet petRequest = new Pet();
        petRequest.setId(1L);
        petRequest.setName("GenericName");
        petRequest.setOwnerFirstName("GenericFirstName");
        petRequest.setOwnerLastName("GenericLastName");
        petRequest.setOwnerPhoneNumber("PhoneNumber");
        petRequest.setActive(Boolean.TRUE);
        petRequest.setAdmitted(Boolean.TRUE);

        when(petDAO.getPetById(any(Long.class))).thenReturn(petRequest);

        PetDTO petDTOresponse = petService.updatePet(petDTORequest, 1L);

    }

    @Test
    public void updatePet_deactivateWhileNotAdmitted_OK() {
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setName("GenericName");
        petDTORequest.setOwnerFirstName("GenericFirstName");
        petDTORequest.setOwnerLastName("GenericLastName");
        petDTORequest.setOwnerPhoneNumber("PhoneNumber");
        petDTORequest.setAdmitted(Boolean.FALSE);
        petDTORequest.setActive(Boolean.FALSE);

        Pet petRequest = new Pet();
        petRequest.setId(1L);
        petRequest.setName("GenericName");
        petRequest.setOwnerFirstName("GenericFirstName");
        petRequest.setOwnerLastName("GenericLastName");
        petRequest.setOwnerPhoneNumber("PhoneNumber");
        petRequest.setAdmitted(Boolean.FALSE);
        petRequest.setActive(Boolean.TRUE);

        Pet petResponse = new Pet();
        petResponse.setId(1L);
        petResponse.setName("GenericName");
        petResponse.setOwnerFirstName("GenericFirstName");
        petResponse.setOwnerLastName("GenericLastName");
        petResponse.setOwnerPhoneNumber("PhoneNumber");
        petResponse.setAdmitted(Boolean.FALSE);
        petResponse.setActive(Boolean.FALSE);

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setName("GenericName");
        petDTOResponse.setOwnerFirstName("GenericFirstName");
        petDTOResponse.setOwnerLastName("GenericLastName");
        petDTOResponse.setOwnerPhoneNumber("PhoneNumber");
        petDTOResponse.setAdmitted(Boolean.FALSE);
        petDTOResponse.setActive(Boolean.FALSE);

        when(petDAO.getPetById(any(Long.class))).thenReturn(petRequest);
        when(petDAO.save(any(Pet.class))).thenReturn(petResponse);
        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);


        PetDTO response = petService.updatePet(petDTORequest, 1L);
        assertNotNull(response);
        assertEquals(response, petDTOResponse);
        assertEquals(response.getActive(), petDTOResponse.getActive());

        Mockito.verify(petDAO, times(1)).getPetById(any(Long.class));
        Mockito.verify(petDAO, times(1)).save(any(Pet.class));
        Mockito.verify(petMapper, times(1)).petEntityToDTO(any(Pet.class));

    }

    @Test(expected = InvalidDeactivationRequest.class)
    public void updatePet_toggleActivateWhileAdmitted_ThenInvalidDeactivationRequest() {
        Pet petRequest = new Pet();
        petRequest.setId(1L);
        petRequest.setName("GenericName");
        petRequest.setOwnerFirstName("GenericFirstName");
        petRequest.setOwnerLastName("GenericLastName");
        petRequest.setOwnerPhoneNumber("PhoneNumber");
        petRequest.setActive(Boolean.TRUE);
        petRequest.setAdmitted(Boolean.TRUE);

        when(petDAO.getPetById(any(Long.class))).thenReturn(petRequest);
        PetDTO response = petService.updatePet(Boolean.FALSE, 1L);

    }

    @Test
    public void updatePet_toggleActivateWhileNotAdmitted_OK() {
        Pet petRequest = new Pet();
        petRequest.setId(1L);
        petRequest.setName("GenericName");
        petRequest.setOwnerFirstName("GenericFirstName");
        petRequest.setOwnerLastName("GenericLastName");
        petRequest.setOwnerPhoneNumber("PhoneNumber");
        petRequest.setAdmitted(Boolean.FALSE);
        petRequest.setActive(Boolean.TRUE);

        Pet petResponse = new Pet();
        petResponse.setId(1L);
        petResponse.setName("GenericName");
        petResponse.setOwnerFirstName("GenericFirstName");
        petResponse.setOwnerLastName("GenericLastName");
        petResponse.setOwnerPhoneNumber("PhoneNumber");
        petResponse.setAdmitted(Boolean.FALSE);
        petResponse.setActive(Boolean.FALSE);

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setName("GenericName");
        petDTOResponse.setOwnerFirstName("GenericFirstName");
        petDTOResponse.setOwnerLastName("GenericLastName");
        petDTOResponse.setOwnerPhoneNumber("PhoneNumber");
        petDTOResponse.setAdmitted(Boolean.FALSE);
        petDTOResponse.setActive(Boolean.FALSE);

        when(petDAO.getPetById(any(Long.class))).thenReturn(petRequest);
        when(petDAO.save(any(Pet.class))).thenReturn(petResponse);
        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);


        PetDTO response = petService.updatePet(Boolean.FALSE, 1L);
        assertNotNull(response);
        assertEquals(response, petDTOResponse);
        assertEquals(response.getActive(), petDTOResponse.getActive());

        Mockito.verify(petDAO, times(1)).getPetById(any(Long.class));
        Mockito.verify(petDAO, times(1)).save(any(Pet.class));
        Mockito.verify(petMapper, times(1)).petEntityToDTO(any(Pet.class));

    }

}
