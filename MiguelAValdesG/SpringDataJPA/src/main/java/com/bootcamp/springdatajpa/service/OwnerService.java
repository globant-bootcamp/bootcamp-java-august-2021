package com.bootcamp.springdatajpa.service;

import com.bootcamp.springdatajpa.dto.OwnerDTO;

import java.util.List;

public interface OwnerService {

  List<OwnerDTO> getAllOwners();

  OwnerDTO addOwner(OwnerDTO petDTO);

  OwnerDTO updateOwner(Long id, OwnerDTO petDTO);

  OwnerDTO deleteOwner(Long id);
}
