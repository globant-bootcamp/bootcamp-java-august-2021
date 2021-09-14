package com.bootcamp.springdatajpa.service.impl;

import com.bootcamp.springdatajpa.dao.AddressDAO;
import com.bootcamp.springdatajpa.dao.OwnerDAO;
import com.bootcamp.springdatajpa.dto.AddressDTO;
import com.bootcamp.springdatajpa.entity.Address;
import com.bootcamp.springdatajpa.entity.Owner;
import com.bootcamp.springdatajpa.exception.InvalidDataException;
import com.bootcamp.springdatajpa.mapper.AddressMapper;
import com.bootcamp.springdatajpa.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_DELETED_SUCCESSFULLY;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_NOT_FOUND;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_CANNOT_BE_DELETED;

@Service
public class AddressServiceImpl implements AddressService {

  @Autowired
  private AddressDAO addressDAO;
  @Autowired
  private OwnerDAO ownerDAO;

  @Autowired
  private AddressMapper addressMapper;

  @Override
  public List<AddressDTO> getAllAddresses() {
    return addressDAO.findAll().stream()
      .map(addressDAO -> addressMapper.addressEntityToDTO(addressDAO))
      .collect(Collectors.toList());
  }

  @Override
  public AddressDTO addAddress(AddressDTO addressDTO) {
    return addressMapper.addressEntityToDTO(addressDAO.save(addressMapper.addressDTOToEntity(addressDTO)));
  }

  @Override
  public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
    return addressMapper.addressEntityToDTO(addressDAO.save(fillAddress(findAddress(id), addressDTO)));
  }

  @Override
  public String deleteAddress(Long id) {
    Optional<Owner> ownerOptional = ownerDAO.findByIdAddress(id);

    if (!ownerOptional.isPresent()) {
      Address address = findAddress(id);
      addressDAO.delete(address);
    } else {
      throw new InvalidDataException(ADDRESS_CANNOT_BE_DELETED);
    }

    return ADDRESS_DELETED_SUCCESSFULLY;
  }

  private Address findAddress(Long id) {
    Optional<Address> addressOptional = addressDAO.findById(id);
    Address address;

    if (addressOptional.isPresent()) {
      address = addressOptional.get();
    } else {
      throw new InvalidDataException(ADDRESS_NOT_FOUND);
    }

    return address;
  }

  private Address fillAddress(Address address, AddressDTO addressDTO) {
    address.setId(addressDTO.getId());
    address.setStreet(addressDTO.getStreet());
    address.setExtNumber(addressDTO.getExtNumber());
    address.setIntNumber(addressDTO.getIntNumber());
    address.setColony(addressDTO.getColony());
    address.setMunicipality(addressDTO.getMunicipality());
    address.setState(addressDTO.getState());
    address.setZipCode(addressDTO.getZipCode());

    return address;
  }

  protected AddressDTO addressEntityToDTO(Address address) {
    return addressMapper.addressEntityToDTO(address);
  }

}
