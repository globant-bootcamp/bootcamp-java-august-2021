package com.bootcamp.springdatacrud.service;

import com.bootcamp.springdatacrud.dto.PetDTO;
import com.bootcamp.springdatacrud.dto.PetOwnerDTO;
import com.bootcamp.springdatacrud.entity.PetOwner;

import java.util.List;

public interface PetOwnerService {
    public List<PetOwner> showList();
    public PetOwnerDTO addPetOwner(PetOwnerDTO petOwnerDTO);
    public PetOwnerDTO getPetOwnerById(Long id_owner);
    public void deletePetOwner(Long id_owner);
    public PetOwnerDTO updatePetOwner(Long id_owner, PetOwnerDTO petOwnerDTO);
}
