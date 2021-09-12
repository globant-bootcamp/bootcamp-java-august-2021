package com.example.vetcrud.service;

import com.example.vetcrud.dto.OwnerDTO;
import com.example.vetcrud.dto.PetDTO;
import com.example.vetcrud.entity.Owner;

import java.util.List;

public interface OwnerService {

    List<OwnerDTO> getAllOwners();

    OwnerDTO createOwner(OwnerDTO ownerDTO);

    OwnerDTO getOwnerById(long id);

    OwnerDTO deleteOwner(long id);

    OwnerDTO updateOwner(OwnerDTO ownerDTO, long id);
}
