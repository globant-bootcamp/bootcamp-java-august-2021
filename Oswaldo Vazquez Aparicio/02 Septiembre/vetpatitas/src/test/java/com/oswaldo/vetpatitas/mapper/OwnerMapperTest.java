package com.oswaldo.vetpatitas.mapper;

import com.oswaldo.vetpatitas.dto.OwnerDTO;
import com.oswaldo.vetpatitas.entity.Owner;
import com.oswaldo.vetpatitas.entity.Pet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static com.oswaldo.vetpatitas.util.Util.createPet;
import static com.oswaldo.vetpatitas.util.Util.createPetDTO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OwnerMapperTest {

    @InjectMocks
    private OwnerMapper ownerMapper;

    @Mock
    private PetMapper petMapper;

    @Test
    public void ownerDTOToEntityTest_Ok(){
        OwnerDTO ownerDTO = createOwnerDTO();
        Owner owner = ownerMapper.ownerDTOToEntity(ownerDTO);

        assertEquals(ownerDTO.getId(), owner.getId());
        assertEquals(ownerDTO.getFirstName(), owner.getFirstName());
        assertEquals(ownerDTO.getLastName(), owner.getLastName());
        assertEquals(ownerDTO.getAge(), owner.getAge());
    }

    @Test
    public void ownerEntityToOwnerDTO_whenListNotNull_Ok(){
        Owner owner = createOwner();

        when(petMapper.petEntityToPetDTO(any(Pet.class))).thenReturn(createPetDTO());

        OwnerDTO ownerDTO = ownerMapper.ownerEntityToOwnerDTO(owner);

        assertEquals(ownerDTO.getId(), owner.getId());
        assertEquals(ownerDTO.getFirstName(), owner.getFirstName());
        assertEquals(ownerDTO.getLastName(), owner.getLastName());
        assertEquals(ownerDTO.getAge(), owner.getAge());
        assertEquals(ownerDTO.getPetList().size(), owner.getPetList().size());

        verify(petMapper, times(1)).petEntityToPetDTO(any(Pet.class));
    }

    @Test
    public void ownerEntityToOwnerDTO_whenListNull_Ok(){
        Owner owner = createOwner();
        owner.setPetList(null);

        OwnerDTO ownerDTO = ownerMapper.ownerEntityToOwnerDTO(owner);

        assertEquals(ownerDTO.getId(), owner.getId());
        assertEquals(ownerDTO.getFirstName(), owner.getFirstName());
        assertEquals(ownerDTO.getLastName(), owner.getLastName());
        assertEquals(ownerDTO.getAge(), owner.getAge());
        assertNull(ownerDTO.getPetList());
    }

    private OwnerDTO createOwnerDTO(){
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(1L);
        ownerDTO.setFirstName("Oswaldo");
        ownerDTO.setLastName("Vazquez");
        ownerDTO.setAge(25);
        return ownerDTO;
    }

    private Owner createOwner(){
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Oswaldo");
        owner.setLastName("Vazquez");
        owner.setAge(25);

        List<Pet> petList = new LinkedList<>();
        petList.add(createPet());
        owner.setPetList(petList);

        return owner;
    }


}
