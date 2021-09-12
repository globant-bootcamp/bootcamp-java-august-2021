package com.bootcamp.springdatajpa.service;

import com.bootcamp.springdatajpa.dto.AddressDTO;

import java.util.List;

public interface AddressService {

  List<AddressDTO> getAllAddresses();

  AddressDTO addAddress(AddressDTO petDTO);

  AddressDTO updateAddress(Long id, AddressDTO petDTO) throws Exception;

  AddressDTO deleteAddress(Long id) throws Exception;

}
