package com.bootcamp.springdatajpa.mapper;

import com.bootcamp.springdatajpa.dto.AddressDTO;
import com.bootcamp.springdatajpa.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

  public AddressDTO addressEntityToDTO(Address address) {
    AddressDTO addressDTO = new AddressDTO();
    addressDTO.setId(address.getId());
    addressDTO.setStreet(address.getStreet());
    addressDTO.setExtNumber(address.getExtNumber());
    addressDTO.setIntNumber(address.getIntNumber());
    addressDTO.setColony(address.getColony());
    addressDTO.setMunicipality(address.getMunicipality());
    addressDTO.setState(address.getState());
    addressDTO.setZipCode(address.getZipCode());

    return addressDTO;
  }

  public Address addressDTOToEntity(AddressDTO addressDTO) {
    Address address = new Address();
    address.setStreet(addressDTO.getStreet());
    address.setExtNumber(addressDTO.getExtNumber());
    address.setIntNumber(addressDTO.getIntNumber());
    address.setColony(addressDTO.getColony());
    address.setMunicipality(addressDTO.getMunicipality());
    address.setState(addressDTO.getState());
    address.setZipCode(addressDTO.getZipCode());

    return address;
  }

}
