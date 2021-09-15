package com.oswaldo.vetpatitas.mapper;

import com.oswaldo.vetpatitas.dto.PetDTO;
import com.oswaldo.vetpatitas.entity.Pet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.oswaldo.vetpatitas.util.Util.createPet;
import static com.oswaldo.vetpatitas.util.Util.createPetDTO;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class PetMapperTest {

    @InjectMocks
    private PetMapper petMapper;

    @Test
    public void petDTOToEntityTest_Ok(){
        PetDTO petDTO = createPetDTO();
        Pet pet = petMapper.petDTOToEntity(petDTO);

        assertEquals(petDTO.getId(), pet.getId());
        assertEquals(petDTO.getName(), pet.getName());
        assertEquals(petDTO.getAge(), pet.getAge());
    }

    @Test
    public void petEntityToPetDTOTest_Ok(){
        Pet pet = createPet();
        PetDTO petDTO = petMapper.petEntityToPetDTO(pet);

        assertEquals(petDTO.getId(), pet.getId());
        assertEquals(petDTO.getName(), pet.getName());
        assertEquals(petDTO.getAge(), pet.getAge());
    }


}
