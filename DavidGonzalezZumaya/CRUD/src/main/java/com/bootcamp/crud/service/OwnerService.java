package com.bootcamp.crud.service;

import com.bootcamp.crud.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {

    OwnerDTO addOwner(OwnerDTO ownerDTO);

    OwnerDTO updateOwner(OwnerDTO ownerDTO, Long id);

    OwnerDTO deleteOwner(Long id);

}
