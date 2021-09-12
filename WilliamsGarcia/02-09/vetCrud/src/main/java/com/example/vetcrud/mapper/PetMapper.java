package com.example.vetcrud.mapper;

import com.example.vetcrud.dao.OwnerDAO;
import com.example.vetcrud.dto.PetDTO;
import com.example.vetcrud.entity.Owner;
import com.example.vetcrud.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetMapper {

    @Autowired
    private OwnerDAO ownerDAO;

    public PetDTO petToDTO(Pet pet) {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(pet.getId());
        petDTO.setName(pet.getName());
        petDTO.setAge(pet.getAge());
        petDTO.setRace(pet.getRace());
        petDTO.setSpecie(pet.getSpecie());
        petDTO.setVaccinated(pet.getVaccinated());
        petDTO.setOwnerId(pet.getOwner().getId().intValue());

        return petDTO;
    }

    public Pet petDTOToPet(PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setId(petDTO.getId());
        pet.setName(petDTO.getName());
        pet.setAge(petDTO.getAge());
        pet.setRace(petDTO.getRace());
        pet.setSpecie(petDTO.getSpecie());
        pet.setVaccinated(petDTO.getVaccinated());
        pet.setOwner(ownerDAO.getById(Long.valueOf(petDTO.getOwnerId())));
        return pet;
    }

    public List<PetDTO> petListToDTO(List<Pet> petList) {
        List<PetDTO> petDTOList = new ArrayList<>();
        for (Pet pet : petList) {
            petDTOList.add(this.petToDTO(pet));
        }

        return petDTOList;
    }
}
