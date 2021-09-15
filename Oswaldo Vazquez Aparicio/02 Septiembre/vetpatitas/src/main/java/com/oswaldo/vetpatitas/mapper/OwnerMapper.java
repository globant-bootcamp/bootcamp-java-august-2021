package com.oswaldo.vetpatitas.mapper;

import com.oswaldo.vetpatitas.dto.OwnerDTO;
import com.oswaldo.vetpatitas.dto.PetDTO;
import com.oswaldo.vetpatitas.entity.Owner;
import com.oswaldo.vetpatitas.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class OwnerMapper {

    @Autowired
    private PetMapper petMapper;

    public Owner ownerDTOToEntity(OwnerDTO ownerDTO){
        Owner owner = new Owner();
        owner.setId(ownerDTO.getId());
        owner.setFirstName(ownerDTO.getFirstName());
        owner.setLastName(ownerDTO.getLastName());
        owner.setAge(ownerDTO.getAge());
        return owner;
    }

    public OwnerDTO ownerEntityToOwnerDTO(Owner owner){
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(owner.getId());
        ownerDTO.setFirstName(owner.getFirstName());
        ownerDTO.setLastName(owner.getLastName());
        ownerDTO.setAge(owner.getAge());
        ownerDTO.setPetList(listOfPetToPetDTO(owner.getPetList()));
        return ownerDTO;
    }

    private List<PetDTO> listOfPetToPetDTO(List<Pet> petList){
        if (petList != null){
            List<PetDTO> petDTOList = new LinkedList<>();
            petList.forEach(pet -> petDTOList.add(petMapper.petEntityToPetDTO(pet)));
            return petDTOList;
        }else{
            return null;
        }
    }

}
