package com.bootcamp.springdatajpa.service.impl;

import com.bootcamp.springdatajpa.dao.OwnerDAO;
import com.bootcamp.springdatajpa.dto.AddressDTO;
import com.bootcamp.springdatajpa.dto.OwnerDTO;
import com.bootcamp.springdatajpa.entity.Owner;
import com.bootcamp.springdatajpa.exception.InvalidDataException;
import com.bootcamp.springdatajpa.mapper.OwnerMapper;
import com.bootcamp.springdatajpa.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bootcamp.springdatajpa.utils.Constants.OWNER_NOT_FOUND;

@Service
public class OwnerServiceImpl implements OwnerService {

  @Autowired
  private OwnerDAO ownerDAO;
  @Autowired
  private OwnerMapper ownerMapper;

  @Autowired
  private AddressServiceImpl addressServiceImpl;

  @Override
  public List<OwnerDTO> getAllOwners() {
    return ownerDAO.findAllActive().stream()
      .map(ownerDAO -> ownerMapper.ownerEntityToDTO(ownerDAO))
      .collect(Collectors.toList());
  }

  @Override
  public OwnerDTO addOwner(OwnerDTO ownerDTO) {
    return ownerMapper.ownerEntityToDTO(ownerDAO.save(ownerMapper.ownerDTOToEntity(ownerDTO)));
  }

  @Override
  public OwnerDTO updateOwner(Long id, OwnerDTO ownerDTO) {
    AddressDTO bodyAddressDTO = addressServiceImpl.addressEntityToDTO(ownerDTO.getAddress());
    addressServiceImpl.updateAddress(bodyAddressDTO.getId(), bodyAddressDTO);

    return ownerMapper.ownerEntityToDTO(ownerDAO.save(fillOwner(findOwnerById(id), ownerDTO)));
  }

  @Override
  public OwnerDTO deleteOwner(Long id) {
    Owner owner = findOwnerById(id);
    owner.setActive(false);
    return ownerMapper.ownerEntityToDTO(ownerDAO.save(owner));
  }

  public Owner findOwnerById(Long id) {
    Optional<Owner> ownerOptional = ownerDAO.findById(id);
    Owner owner;

    if (ownerOptional.isPresent()) {
      owner = ownerOptional.get();
    } else {
      throw new InvalidDataException(OWNER_NOT_FOUND);
    }
    return owner;
  }

  public Owner fillOwner(Owner owner, OwnerDTO ownerDTO) {
    owner.setAddress(ownerDTO.getAddress());
    owner.setFirstName(ownerDTO.getFirstName());
    owner.setLastName(ownerDTO.getLastName());
    owner.setAge(ownerDTO.getAge());
    owner.setEmail(ownerDTO.getEmail());
    owner.setPhone(ownerDTO.getPhone());
    owner.setActive(ownerDTO.isActive());

    return owner;
  }

}
