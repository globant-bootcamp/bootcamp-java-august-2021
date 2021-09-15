package com.example.vetcrud.service;

import com.example.vetcrud.dto.OwnerDTO;
import com.example.vetcrud.exception.NotFoundException;
import com.sun.media.sound.InvalidDataException;

import java.util.List;

public interface OwnerService {

    List<OwnerDTO> getAllOwners();

    OwnerDTO createOwner(OwnerDTO ownerDTO) throws InvalidDataException;

    OwnerDTO getOwnerById(long id) throws NotFoundException;

    void deleteOwner(long id) throws NotFoundException;

    OwnerDTO updateOwner(OwnerDTO ownerDTO, long id) throws NotFoundException;
}
