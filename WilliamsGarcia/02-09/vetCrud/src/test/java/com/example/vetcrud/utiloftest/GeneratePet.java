package com.example.vetcrud.utiloftest;

import com.example.vetcrud.dto.PetDTO;
import com.example.vetcrud.entity.Pet;

import static com.example.vetcrud.utiloftest.ConstantsOfTest.NUMBER_CYCLE;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.NAME_PET;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.AGE;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.RACE;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.SPECIE;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.VACCINATED;
import static com.example.vetcrud.utiloftest.ConstantsOfTest.OWNER_ID;

import java.util.ArrayList;
import java.util.List;

public class GeneratePet {

    private static GenerateOwner generateOwner = new GenerateOwner();

    public PetDTO createPetDTO(Long id) {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(id);
        petDTO.setName(NAME_PET);
        petDTO.setAge(AGE);
        petDTO.setSpecie(SPECIE);
        petDTO.setRace(RACE);
        petDTO.setVaccinated(VACCINATED);
        petDTO.setOwnerId(OWNER_ID);

        return petDTO;
    }

    public Pet createPet(Long id) {
        Pet pet = new Pet();
        pet.setId(id);
        pet.setName(NAME_PET);
        pet.setAge(AGE);
        pet.setSpecie(SPECIE);
        pet.setRace(RACE);
        pet.setVaccinated(VACCINATED);
        pet.setOwner(generateOwner.createOwner(OWNER_ID.longValue()));

        return pet;
    }

    public List<Pet> createPetList() {
        List<Pet> petList = new ArrayList<>();
        for (int i = 0; i < NUMBER_CYCLE; i++) {
            petList.add(createPet(Long.parseLong(String.valueOf(i))));
        }
        return petList;
    }

    public List<PetDTO> createPetDTOList() {
        List<PetDTO> petDTOList = new ArrayList<>();
        for (int i = 0; i < NUMBER_CYCLE; i++) {
            petDTOList.add(createPetDTO(Long.parseLong(String.valueOf(i))));
        }
        return petDTOList;
    }
}
