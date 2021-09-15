package com.example.globant.springdataproject.service;

import com.example.globant.springdataproject.dao.ClientDAO;
import com.example.globant.springdataproject.dao.PetDAO;
import com.example.globant.springdataproject.dto.PetDTO;
import com.example.globant.springdataproject.entity.Client;
import com.example.globant.springdataproject.entity.Pet;
import com.example.globant.springdataproject.exception.InvalidDataException;
import com.example.globant.springdataproject.mapper.PetMapper;
import com.example.globant.springdataproject.service.impl.PetServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Mock
    private ClientDAO clientDAO;

    @Test
    public void addPetTest_WithAllRequiredFields_OK() throws InvalidDataException {
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setNameOfPet("Pet name");
        petDTORequest.setBreed("breed");
        petDTORequest.setSpecies("Species");
        petDTORequest.setDateOfBirth("2021-07-12");
        petDTORequest.setClientId(1L);

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setNameOfPet("Pet name");
        petDTOResponse.setBreed("breed");
        petDTOResponse.setSpecies("Species");
        petDTOResponse.setDateOfBirth("2021-07-12");
        petDTOResponse.setClientId(1L);

        Pet petRequest = new Pet();
        petRequest.setNameOfPet("Pet name");
        petRequest.setBreed("breed");
        petRequest.setSpecies("Species");
        petRequest.setDateOfBirth(new Date(2021, 7, 12));
        Client clientRequest = new Client();
        clientRequest.setId(1L);
        clientRequest.setFirstName("client name");
        clientRequest.setLastName("client last name");
        clientRequest.setPhoneNumber("12346");
        petRequest.setClient(clientRequest);

        Pet petResponse = new Pet();
        petResponse.setNameOfPet("Pet name");
        petResponse.setBreed("breed");
        petResponse.setSpecies("Species");
        petResponse.setDateOfBirth(new Date(2021, 7, 12));
        petResponse.setClient(clientRequest);

        when(clientDAO.findClientById(any(Long.class))).thenReturn(clientRequest);
        when(petMapper.petDTOToEntity(any(PetDTO.class))).thenReturn(petRequest);
        when(petDAO.save(any(Pet.class))).thenReturn(petResponse);
        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.addPet(petDTORequest);

        assertNotNull(response);
        assertEquals(response, petDTOResponse);

        assertEquals(response.getId(), petDTOResponse.getId());
        assertEquals(response.getNameOfPet(), petDTORequest.getNameOfPet());
        assertEquals(response.getBreed(), petDTORequest.getBreed());
        assertEquals(response.getSpecies(), petDTORequest.getSpecies());
        assertEquals(response.getDateOfBirth(), petDTORequest.getDateOfBirth());
        assertEquals(response.getClientId(), petDTORequest.getClientId());

        Mockito.verify(petDAO, times(1)).save(any(Pet.class));
    }

    @Test(expected = InvalidDataException.class)
    public void addPetTest_WithMissingFields_ThemInvalidDataException() throws InvalidDataException {
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setSpecies("Species");
        petDTORequest.setBreed("Breed");

        petService.addPet(petDTORequest);
    }

    @Test(expected = InvalidDataException.class)
    public void addPetTest_WithInvalidClientId_ThemInvalidDataException() throws InvalidDataException {
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setNameOfPet("Pet name");
        petDTORequest.setBreed("breed");
        petDTORequest.setSpecies("Species");
        petDTORequest.setDateOfBirth("2021-07-12");
        petDTORequest.setClientId(1L);

        petService.addPet(petDTORequest);
    }

    @Test
    public void getPetsTest_Ok() {
        Client ClientResponse = new Client();
        ClientResponse.setId(1L);
        ClientResponse.setFirstName("client name");
        ClientResponse.setLastName("client last name");
        ClientResponse.setPhoneNumber("12346");

        Pet petResponse = new Pet();
        petResponse.setId(1L);
        petResponse.setNameOfPet("Name of pet");
        petResponse.setSpecies("Species of pet");
        petResponse.setBreed("Breed of pet");
        petResponse.setDateOfBirth(new Date(2021, 07, 12));
        petResponse.setClient(ClientResponse);

        List<Pet> petsResponse = new ArrayList<>();
        petsResponse.add(petResponse);

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setNameOfPet("Name of pet");
        petDTOResponse.setSpecies("Species of pet");
        petDTOResponse.setBreed("Breed of pet");
        petDTOResponse.setDateOfBirth("2021-07-12");
        petDTOResponse.setId(1L);

        List<PetDTO> petsDTOResponse = new ArrayList<>();
        petsDTOResponse.add(petDTOResponse);

        when(petDAO.findAll()).thenReturn(petsResponse);
        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);

        List<PetDTO> response = petService.getPets();

        assertNotNull(response);
        assertEquals(response, petsDTOResponse);

        Mockito.verify(petDAO, times(1)).findAll();
    }

    @Test
    public void getPetTest_WithValidPetId_Ok() throws InvalidDataException {
        Long petIdRequest = 1L;

        Client ClientResponse = new Client();
        ClientResponse.setId(1L);
        ClientResponse.setFirstName("client name");
        ClientResponse.setLastName("client last name");
        ClientResponse.setPhoneNumber("12346");

        Pet petResponse = new Pet();
        petResponse.setId(1L);
        petResponse.setNameOfPet("Name of pet");
        petResponse.setSpecies("Species of pet");
        petResponse.setBreed("Breed of pet");
        petResponse.setDateOfBirth(new Date(2021, 07, 12));
        petResponse.setClient(ClientResponse);

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setNameOfPet("Name of pet");
        petDTOResponse.setSpecies("Species of pet");
        petDTOResponse.setBreed("Breed of pet");
        petDTOResponse.setDateOfBirth("2021-07-12");
        petDTOResponse.setClientId(1L);

        when(petDAO.findPetById(any(Long.class))).thenReturn(petResponse);
        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.getPetByID(petIdRequest);

        assertNotNull(response);
        assertEquals(response, petDTOResponse);

        Mockito.verify(petDAO, times(1)).findPetById(any(Long.class));
    }

    @Test(expected = InvalidDataException.class)
    public void getPetTest_WithNullPetIdl_ThemInvalidDataException() throws InvalidDataException {
        petService.getPetByID(null);
    }

    @Test(expected = InvalidDataException.class)
    public void getPetTest_WithPetIdInvalid_ThemInvalidDataException() throws InvalidDataException {
        Long petIdRequest = 1L;

        when(petDAO.findPetById(any(Long.class))).thenReturn(null);
        petService.getPetByID(petIdRequest);
    }

    @Test
    public void deletePetTest_WithPetIdValid_Ok() throws InvalidDataException {
        Long petIdRequest = 1L;

        petService.deletePetByID(petIdRequest);

        Mockito.verify(petDAO, times(1)).deleteById(any(Long.class));
    }

    @Test(expected = InvalidDataException.class)
    public void deletePetTest_WithPetIdNull_ThemInvalidDataException() throws InvalidDataException {
        petService.deletePetByID(null);
    }

    @Test
    public void editPetTest_WithPetIdValid_Ok() throws InvalidDataException {
        Long petIdRequest = 1L;
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setNameOfPet("Pet");
        petDTORequest.setBreed("Pet breed");
        petDTORequest.setSpecies("Pet species");

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setNameOfPet("Pet");
        petDTOResponse.setBreed("Pet breed");
        petDTOResponse.setSpecies("Pet species");
        petDTOResponse.setDateOfBirth("2021-07-12");
        petDTOResponse.setClientId(1L);

        Pet petResponse = new Pet();
        petResponse.setNameOfPet("Pet");
        petResponse.setBreed("Pet breed");
        petResponse.setSpecies("Pet species");
        petResponse.setDateOfBirth(new Date(2021, 7, 12));
        Client clientRequest = new Client();
        clientRequest.setId(1L);
        clientRequest.setFirstName("client name");
        clientRequest.setLastName("client last name");
        clientRequest.setPhoneNumber("12346");
        petResponse.setClient(clientRequest);

        Pet modifiedPetResponse = new Pet();
        modifiedPetResponse.setNameOfPet("Pet name");
        modifiedPetResponse.setBreed("breed");
        modifiedPetResponse.setSpecies("Species");
        modifiedPetResponse.setDateOfBirth(new Date(2021, 7, 12));
        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12346");
        modifiedPetResponse.setClient(clientResponse);

        when(petDAO.findPetById(any(Long.class))).thenReturn(petResponse);
        when(petDAO.save(any(Pet.class))).thenReturn(modifiedPetResponse);
        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.editPetByID(petIdRequest, petDTORequest);

        assertNotNull(response);
        assertEquals(response, petDTOResponse);

        assertEquals(response.getId(), petDTOResponse.getId());
        assertEquals(response.getNameOfPet(), petDTORequest.getNameOfPet());
        assertEquals(response.getBreed(), petDTORequest.getBreed());
        assertEquals(response.getSpecies(), petDTORequest.getSpecies());
        assertEquals(response.getDateOfBirth(), petDTOResponse.getDateOfBirth());
        assertEquals(response.getClientId(), petDTOResponse.getClientId());

        Mockito.verify(petDAO, times(1)).save(any(Pet.class));
    }

    @Test
    public void editPetTest_WithValidPetId_AndOnlyPetName_OK() throws InvalidDataException {
        Long petIdRequest = 1L;
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setNameOfPet("Pet name");

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setNameOfPet("Pet name");
        petDTOResponse.setBreed("Pet breed");
        petDTOResponse.setSpecies("Pet species");
        petDTOResponse.setDateOfBirth("2021-07-12");
        petDTOResponse.setClientId(1L);

        Pet petResponse = new Pet();
        petResponse.setNameOfPet("Pet");
        petResponse.setBreed("Pet breed");
        petResponse.setSpecies("Pet species");
        petResponse.setDateOfBirth(new Date(2021, 7, 12));
        Client clientRequest = new Client();
        clientRequest.setId(1L);
        clientRequest.setFirstName("client name");
        clientRequest.setLastName("client last name");
        clientRequest.setPhoneNumber("12346");
        petResponse.setClient(clientRequest);

        Pet modifiedPetResponse = new Pet();
        modifiedPetResponse.setId(1L);
        modifiedPetResponse.setNameOfPet("Pet name");
        modifiedPetResponse.setBreed("Pet breed");
        modifiedPetResponse.setSpecies("Pet species");
        modifiedPetResponse.setDateOfBirth(new Date(2021, 7, 12));
        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12346");
        modifiedPetResponse.setClient(clientResponse);

        when(petDAO.findPetById(any(Long.class))).thenReturn(petResponse);
        when(petDAO.save(any(Pet.class))).thenReturn(modifiedPetResponse);
        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.editPetByID(petIdRequest, petDTORequest);

        assertNotNull(response);
        assertEquals(response, petDTOResponse);

        assertEquals(response.getId(), petDTOResponse.getId());
        assertEquals(response.getNameOfPet(), petDTORequest.getNameOfPet());
        assertEquals(response.getBreed(), petDTOResponse.getBreed());
        assertEquals(response.getSpecies(), petDTOResponse.getSpecies());
        assertEquals(response.getDateOfBirth(), petDTOResponse.getDateOfBirth());
        assertEquals(response.getClientId(), petDTOResponse.getClientId());

        Mockito.verify(petDAO, times(1)).save(any(Pet.class));
    }

    @Test
    public void editPetTest_WithValidPetId_AndOnlyPetBreed_OK() throws InvalidDataException {
        Long petIdRequest = 1L;
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setBreed("breed");

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setNameOfPet("Pet name");
        petDTOResponse.setBreed("breed");
        petDTOResponse.setSpecies("Pet species");
        petDTOResponse.setDateOfBirth("2021-07-12");
        petDTOResponse.setClientId(1L);

        Pet petResponse = new Pet();
        petResponse.setNameOfPet("Pet name");
        petResponse.setBreed("Pet breed");
        petResponse.setSpecies("Pet species");
        petResponse.setDateOfBirth(new Date(2021, 7, 12));
        Client clientRequest = new Client();
        clientRequest.setId(1L);
        clientRequest.setFirstName("client name");
        clientRequest.setLastName("client last name");
        clientRequest.setPhoneNumber("12346");
        petResponse.setClient(clientRequest);

        Pet modifiedPetResponse = new Pet();
        modifiedPetResponse.setId(1L);
        modifiedPetResponse.setNameOfPet("Pet name");
        modifiedPetResponse.setBreed("breed");
        modifiedPetResponse.setSpecies("Pet species");
        modifiedPetResponse.setDateOfBirth(new Date(2021, 7, 12));
        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12346");
        modifiedPetResponse.setClient(clientResponse);

        when(petDAO.findPetById(any())).thenReturn(petResponse);
        when(petDAO.save(any(Pet.class))).thenReturn(modifiedPetResponse);
        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.editPetByID(petIdRequest, petDTORequest);

        assertNotNull(response);
        assertEquals(response, petDTOResponse);

        assertEquals(response.getId(), petDTOResponse.getId());
        assertEquals(response.getNameOfPet(), petDTOResponse.getNameOfPet());
        assertEquals(response.getBreed(), petDTORequest.getBreed());
        assertEquals(response.getSpecies(), petDTOResponse.getSpecies());
        assertEquals(response.getDateOfBirth(), petDTOResponse.getDateOfBirth());
        assertEquals(response.getClientId(), petDTOResponse.getClientId());

        Mockito.verify(petDAO, times(1)).save(any(Pet.class));
    }

    @Test
    public void editPetTest_WithValidPetId_AndOnlyPetSpecies_OK() throws InvalidDataException {
        Long petIdRequest = 1L;
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setSpecies("species");

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setNameOfPet("Pet name");
        petDTOResponse.setBreed("Pet breed");
        petDTOResponse.setSpecies("species");
        petDTOResponse.setDateOfBirth("2021-07-12");
        petDTOResponse.setClientId(1L);

        Pet petResponse = new Pet();
        petResponse.setNameOfPet("Pet name");
        petResponse.setBreed("Pet breed");
        petResponse.setSpecies("Pet species");
        petResponse.setDateOfBirth(new Date(2021, 7, 12));
        Client clientRequest = new Client();
        clientRequest.setId(1L);
        clientRequest.setFirstName("client name");
        clientRequest.setLastName("client last name");
        clientRequest.setPhoneNumber("12346");
        petResponse.setClient(clientRequest);

        Pet modifiedPetResponse = new Pet();
        modifiedPetResponse.setId(1L);
        modifiedPetResponse.setNameOfPet("Pet name");
        modifiedPetResponse.setBreed("Pet breed");
        modifiedPetResponse.setSpecies("species");
        modifiedPetResponse.setDateOfBirth(new Date(2021, 7, 12));
        Client clientResponse = new Client();
        clientResponse.setId(1L);
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12346");
        modifiedPetResponse.setClient(clientResponse);

        when(petDAO.findPetById(any())).thenReturn(petResponse);
        when(petDAO.save(any(Pet.class))).thenReturn(modifiedPetResponse);
        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);

        PetDTO response = petService.editPetByID(petIdRequest, petDTORequest);

        assertNotNull(response);
        assertEquals(response, petDTOResponse);

        assertEquals(response.getId(), petDTOResponse.getId());
        assertEquals(response.getNameOfPet(), petDTOResponse.getNameOfPet());
        assertEquals(response.getBreed(), petDTOResponse.getBreed());
        assertEquals(response.getSpecies(), petDTORequest.getSpecies());
        assertEquals(response.getDateOfBirth(), petDTOResponse.getDateOfBirth());
        assertEquals(response.getClientId(), petDTOResponse.getClientId());


        Mockito.verify(petDAO, times(1)).save(any(Pet.class));
    }

    @Test(expected = InvalidDataException.class)
    public void editPetTest_WithPetIdNull_ThemInvalidDataException() throws InvalidDataException {
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setNameOfPet("pet name");
        petDTORequest.setBreed("Breed");
        petDTORequest.setSpecies("Species");

        petService.editPetByID(null, petDTORequest);
    }

    @Test(expected = InvalidDataException.class)
    public void editPetTest_WithInvalidPetId_ThemInvalidDataException() throws InvalidDataException {
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setNameOfPet("pet name");
        petDTORequest.setBreed("Breed");
        petDTORequest.setSpecies("Species");

        petService.editPetByID(1L, petDTORequest);
    }
}
