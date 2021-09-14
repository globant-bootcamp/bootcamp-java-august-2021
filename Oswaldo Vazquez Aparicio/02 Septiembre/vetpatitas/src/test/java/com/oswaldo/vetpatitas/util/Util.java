package com.oswaldo.vetpatitas.util;

import com.oswaldo.vetpatitas.dto.OwnerDTO;
import com.oswaldo.vetpatitas.dto.PetDTO;
import com.oswaldo.vetpatitas.entity.Owner;
import com.oswaldo.vetpatitas.entity.Pet;

import java.util.LinkedList;
import java.util.List;

public class Util {

    public static OwnerDTO createOwnerDTO(){
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(1L);
        ownerDTO.setFirstName("Oswaldo");
        ownerDTO.setLastName("Vazquez");
        ownerDTO.setAge(25);
        return ownerDTO;
    }

    public static Owner createOwner(){
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

    public static PetDTO createPetDTO(){
        PetDTO petDTO = new PetDTO();
        petDTO.setId(1L);
        petDTO.setName("Kira");
        petDTO.setAge((byte) 5);
        return petDTO;
    }

    public static Pet createPet(){
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Kira");
        pet.setAge((byte) 5);
        return pet;
    }

}
