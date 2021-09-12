package com.bootcamp.springdatajpa.controller;

import com.bootcamp.springdatajpa.dto.AddressDTO;
import com.bootcamp.springdatajpa.dto.ResponseDTO;
import com.bootcamp.springdatajpa.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.bootcamp.springdatajpa.utils.Constants.*;

@RestController
@RequestMapping("addresses")
@Validated
public class AddressController {

  @Autowired
  AddressService addressService;

  @GetMapping()
  public ResponseEntity<ResponseDTO<List<AddressDTO>>> getAllAddresses() {
    ResponseDTO<List<AddressDTO>> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      ADDRESS_FOUND_SUCCESSFULLY,
      addressService.getAllAddresses()
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<ResponseDTO<AddressDTO>> addAddress(@RequestBody @Valid AddressDTO addressDTO) {
    ResponseDTO<AddressDTO> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      ADDRESS_ADDED_SUCCESSFULLY,
      addressService.addAddress(addressDTO)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<ResponseDTO<AddressDTO>> updateAddress(@PathVariable Long id, @RequestBody @Valid AddressDTO addressDTO) throws Exception {
    ResponseDTO<AddressDTO> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      ADDRESS_UPDATED_SUCCESSFULLY,
      addressService.updateAddress(id, addressDTO)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<ResponseDTO<AddressDTO>> deleteAddress(@PathVariable Long id) throws Exception {
    ResponseDTO<AddressDTO> responseDTO = new ResponseDTO<>(
      ResponseConstants.SUCCESS,
      ADDRESS_DELETED_SUCCESSFULLY,
      addressService.deleteAddress(id)
    );

    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}
