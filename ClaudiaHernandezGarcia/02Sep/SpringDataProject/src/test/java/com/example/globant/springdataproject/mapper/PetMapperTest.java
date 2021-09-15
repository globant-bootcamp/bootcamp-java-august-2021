package com.example.globant.springdataproject.mapper;

import com.example.globant.springdataproject.dto.PetDTO;
import com.example.globant.springdataproject.entity.Pet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class PetMapperTest {

    @InjectMocks
    private PetMapper petMapper;

    @Test()
    public void petDTOToEntityTest_OK() {
        PetDTO petDTORequest = new PetDTO();
        petDTORequest.setNameOfPet("Pet name");
        petDTORequest.setBreed("breed");
        petDTORequest.setSpecies("Species");
        petDTORequest.setDateOfBirth("2021-07-12");

        Pet petResponse = new Pet();
        petResponse.setNameOfPet("Pet name");
        petResponse.setBreed("breed");
        petResponse.setSpecies("Species");
        petResponse.setDateOfBirth(new Date(2021, 7, 12));

        Pet response = petMapper.petDTOToEntity(petDTORequest);

        System.out.println(response.getDateOfBirth());

        assertNotNull(response);

        assertEquals(response.getNameOfPet(), petResponse.getNameOfPet());
        assertEquals(response.getBreed(), petResponse.getBreed());
        assertEquals(response.getSpecies(), petResponse.getSpecies());
        assertEquals(response.getDateOfBirth(), "2021-07-12");
    }

    @Test()
    public void petEntityToDTOTest_OK() {
        Pet petRequest = new Pet();
        petRequest.setId(1L);
        petRequest.setNameOfPet("Pet name");
        petRequest.setBreed("breed");
        petRequest.setSpecies("Species");
        petRequest.setDateOfBirth(new Date(2021, 7, 12));

        PetDTO petDTOResponse = new PetDTO();
        petDTOResponse.setId(1L);
        petDTOResponse.setNameOfPet("Pet name");
        petDTOResponse.setBreed("breed");
        petDTOResponse.setSpecies("Species");
        petDTOResponse.setDateOfBirth("2021-07-12");

        PetDTO response = petMapper.petEntityToDTO(petRequest);

        assertNotNull(response);

        assertEquals(response.getNameOfPet(), petDTOResponse.getNameOfPet());
        assertEquals(response.getBreed(), petDTOResponse.getBreed());
        assertEquals(response.getSpecies(), petDTOResponse.getSpecies());
        assertEquals(response.getDateOfBirth(), new Date(2021, 7, 12));
    }
}
