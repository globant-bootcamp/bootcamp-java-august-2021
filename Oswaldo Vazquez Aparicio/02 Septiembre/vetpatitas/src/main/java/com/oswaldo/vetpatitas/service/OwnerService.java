package com.oswaldo.vetpatitas.service;

import com.oswaldo.vetpatitas.dto.OwnerDTO;
import com.oswaldo.vetpatitas.dto.PetDTO;

import java.util.List;

public interface OwnerService {

    OwnerDTO add(OwnerDTO ownerDTO);
    OwnerDTO getById(Long id);
    List<OwnerDTO> getAll();
    OwnerDTO updateOwnerData(Long id, OwnerDTO ownerDTO);
    void delete(Long id);

    OwnerDTO assignPetToOwner(Long ownerId, PetDTO petDTO);

}
