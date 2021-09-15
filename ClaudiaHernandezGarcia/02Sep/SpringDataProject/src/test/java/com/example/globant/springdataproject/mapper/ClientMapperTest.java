package com.example.globant.springdataproject.mapper;

import com.example.globant.springdataproject.dto.ClientDTO;
import com.example.globant.springdataproject.dto.PetDTO;
import com.example.globant.springdataproject.entity.Client;
import com.example.globant.springdataproject.entity.Pet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientMapperTest {

    @InjectMocks
    ClientMapper clientMapper;

    @Mock
    PetMapper petMapper;

    @Test()
    public void clientDTOToEntityTest_OK() {
        ClientDTO clientDTORequest = new ClientDTO();
        clientDTORequest.setFirstName("client name");
        clientDTORequest.setLastName("client last name");
        clientDTORequest.setPhoneNumber("12346");

        Client clientResponse = new Client();
        clientResponse.setFirstName("client name");
        clientResponse.setLastName("client last name");
        clientResponse.setPhoneNumber("12346");

        Client response = clientMapper.clientDTOToEntity(clientDTORequest);

        assertNotNull(response);

        assertEquals(response.getFirstName(), clientDTORequest.getFirstName());
        assertEquals(response.getLastName(), clientDTORequest.getLastName());
        assertEquals(response.getPhoneNumber(), clientDTORequest.getPhoneNumber());
    }

    @Test()
    public void clientEntityToDTOTest_OK() {
        Client clientRequest = new Client();
        clientRequest.setId(1L);
        clientRequest.setFirstName("client name");
        clientRequest.setLastName("client last name");
        clientRequest.setPhoneNumber("12346");
        clientRequest.setPets(new ArrayList<>());

        ClientDTO clientDTOResponse = new ClientDTO();
        clientDTOResponse.setId(1L);
        clientDTOResponse.setFirstName("client name");
        clientDTOResponse.setLastName("client last name");
        clientDTOResponse.setPhoneNumber("12346");
        clientDTOResponse.setPets(new ArrayList<>());

        ClientDTO response = clientMapper.clientEntityToDTO(clientRequest);

        assertNotNull(response);

        assertEquals(response.getId(), clientDTOResponse.getId());
        assertEquals(response.getFirstName(), clientDTOResponse.getFirstName());
        assertEquals(response.getLastName(), clientDTOResponse.getLastName());
        assertEquals(response.getPhoneNumber(), clientDTOResponse.getPhoneNumber());
        assertEquals(response.getPhoneNumber(), clientDTOResponse.getPhoneNumber());
    }

    @Test()
    public void clientEntityToDTOTest_WithPets_OK() {
        Client clientRequest = new Client();
        clientRequest.setId(1L);
        clientRequest.setFirstName("client name");
        clientRequest.setLastName("client last name");
        clientRequest.setPhoneNumber("12346");

        Pet petRequest = new Pet();
        petRequest.setNameOfPet("Pet name");
        petRequest.setBreed("breed");
        petRequest.setSpecies("Species");
        petRequest.setDateOfBirth(new Date(2021, 7, 12));

        List<Pet> pets = new ArrayList<>();
        pets.add(petRequest);
        clientRequest.setPets(pets);

        ClientDTO clientDTOResponse = new ClientDTO();
        clientDTOResponse.setId(1L);
        clientDTOResponse.setFirstName("client name");
        clientDTOResponse.setLastName("client last name");
        clientDTOResponse.setPhoneNumber("12346");

        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setNameOfPet("Pet name");
        petDTORequest.setBreed("breed");
        petDTORequest.setSpecies("Species");
        petDTORequest.setDateOfBirth("2021-07-12");

        List<PetDTO> petsDTO = new ArrayList<>();
        petsDTO.add(petDTORequest);

        clientDTOResponse.setPets(petsDTO);

        when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTORequest);

        ClientDTO response = clientMapper.clientEntityToDTO(clientRequest);

        assertNotNull(response);

        assertEquals(response.getId(), clientDTOResponse.getId());
        assertEquals(response.getFirstName(), clientDTOResponse.getFirstName());
        assertEquals(response.getLastName(), clientDTOResponse.getLastName());
        assertEquals(response.getPhoneNumber(), clientDTOResponse.getPhoneNumber());
        assertEquals(response.getPhoneNumber(), clientDTOResponse.getPhoneNumber());
    }
}