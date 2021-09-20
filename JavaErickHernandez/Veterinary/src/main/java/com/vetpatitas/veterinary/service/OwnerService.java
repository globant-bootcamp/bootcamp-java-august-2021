package com.vetpatitas.veterinary.service;


import com.vetpatitas.veterinary.dto.OwnerDTO;

public interface OwnerService {

    OwnerDTO addOwner(OwnerDTO ownerDTO);
    OwnerDTO deleteOwner(OwnerDTO ownerDTO);
    OwnerDTO selectOwner(long id);
    OwnerDTO editOwner(OwnerDTO ownerDTO);
}
