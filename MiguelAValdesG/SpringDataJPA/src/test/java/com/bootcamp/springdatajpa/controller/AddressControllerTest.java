package com.bootcamp.springdatajpa.controller;

import com.bootcamp.springdatajpa.dto.AddressDTO;
import com.bootcamp.springdatajpa.dto.ResponseDTO;
import com.bootcamp.springdatajpa.service.AddressService;
import com.bootcamp.springdatajpa.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_ZIP_CODE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_ZIP_CODE_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ONE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_STREET;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_STREET_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_COLONY;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_COLONY_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_MUNICIPALITY;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_MUNICIPALITY_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_EXT_NUMBER;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_EXT_NUMBER_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_INT_NUMBER;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_INT_NUMBER_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_STATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_STATE_UPDATE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressControllerTest {

  @InjectMocks
  private AddressController addressController;

  @Mock
  private AddressService addressService;

  @Test
  public void whenGetAllAddresses_ThenGetAddressesDTO_Ok() {
    List<AddressDTO> addressDTOList = new ArrayList<>();

    AddressDTO addressDTO = createAddressDTO();
    addressDTO.setId(Constants.OWNER_ID);
    AddressDTO addressDTO2 = createAddressDTO();
    addressDTO2.setId(2L);

    addressDTOList.add(addressDTO);
    addressDTOList.add(addressDTO2);

    when(addressService.getAllAddresses()).thenReturn(addressDTOList);

    ResponseEntity<ResponseDTO<List<AddressDTO>>> response = addressController.getAllAddresses();

    assertNotNull(response);
    verify(addressService, times(ONE)).getAllAddresses();
  }

  @Test
  public void whenAddAddress_ThenGetAddressDTO_Ok() {
    AddressDTO addressDTORequest = createAddressDTO();

    AddressDTO addressDTOResponse = createAddressDTO();
    addressDTOResponse.setId(Constants.OWNER_ID);

    when(addressService.addAddress(any(AddressDTO.class))).thenReturn(addressDTOResponse);

    ResponseEntity<ResponseDTO<AddressDTO>> response = addressController.addAddress(addressDTORequest);

    assertNotNull(response);
    assertEquals(Objects.requireNonNull(response.getBody()).getContent().getStreet(), addressDTORequest.getStreet());
    assertEquals(response.getBody().getContent().getExtNumber(), addressDTORequest.getExtNumber());
    assertEquals(response.getBody().getContent().getIntNumber(), addressDTORequest.getIntNumber());
    assertEquals(response.getBody().getContent().getColony(), addressDTORequest.getColony());
    assertEquals(response.getBody().getContent().getMunicipality(), addressDTORequest.getMunicipality());
    assertEquals(response.getBody().getContent().getState(), addressDTORequest.getState());
    assertEquals(response.getBody().getContent().getZipCode(), addressDTORequest.getZipCode());
    verify(addressService, times(ONE)).addAddress(any(AddressDTO.class));
  }

  @Test
  public void whenUpdateAddress_ThenGetAddressDTO_Ok() {
    AddressDTO addressDTORequest = new AddressDTO();
    addressDTORequest.setStreet(ADDRESS_STREET_UPDATE);
    addressDTORequest.setExtNumber(ADDRESS_EXT_NUMBER_UPDATE);
    addressDTORequest.setIntNumber(ADDRESS_INT_NUMBER_UPDATE);
    addressDTORequest.setColony(ADDRESS_COLONY_UPDATE);
    addressDTORequest.setMunicipality(ADDRESS_MUNICIPALITY_UPDATE);
    addressDTORequest.setState(ADDRESS_STATE_UPDATE);
    addressDTORequest.setZipCode(ADDRESS_ZIP_CODE_UPDATE);

    AddressDTO addressDTOResponse = new AddressDTO();
    addressDTOResponse.setId(Constants.OWNER_ID);
    addressDTOResponse.setStreet(ADDRESS_STREET_UPDATE);
    addressDTOResponse.setExtNumber(ADDRESS_EXT_NUMBER_UPDATE);
    addressDTOResponse.setIntNumber(ADDRESS_INT_NUMBER_UPDATE);
    addressDTOResponse.setColony(ADDRESS_COLONY_UPDATE);
    addressDTOResponse.setMunicipality(ADDRESS_MUNICIPALITY_UPDATE);
    addressDTOResponse.setState(ADDRESS_STATE_UPDATE);
    addressDTOResponse.setZipCode(ADDRESS_ZIP_CODE_UPDATE);

    when(addressService.updateAddress(any(Long.class), any(AddressDTO.class))).thenReturn(addressDTOResponse);

    ResponseEntity<ResponseDTO<AddressDTO>> response = addressController.updateAddress(any(Long.class), addressDTORequest);

    assertNotNull(response);
    assertEquals(Objects.requireNonNull(response.getBody()).getContent().getStreet(), addressDTORequest.getStreet());
    assertEquals(response.getBody().getContent().getExtNumber(), addressDTORequest.getExtNumber());
    assertEquals(response.getBody().getContent().getIntNumber(), addressDTORequest.getIntNumber());
    assertEquals(response.getBody().getContent().getColony(), addressDTORequest.getColony());
    assertEquals(response.getBody().getContent().getMunicipality(), addressDTORequest.getMunicipality());
    assertEquals(response.getBody().getContent().getState(), addressDTORequest.getState());
    assertEquals(response.getBody().getContent().getZipCode(), addressDTORequest.getZipCode());
    verify(addressService, times(ONE)).updateAddress(any(Long.class), any(AddressDTO.class));
  }

  @Test
  public void whenDeleteAddress_ThenGetInactiveAddress_Ok() {
    when(addressService.deleteAddress(any(Long.class))).thenReturn(any(String.class));

    ResponseEntity<ResponseDTO<String>> response = addressController.deleteAddress(any(Long.class));

    assertNotNull(response);
    verify(addressService, times(ONE)).deleteAddress(any(Long.class));
  }

  private AddressDTO createAddressDTO() {
    AddressDTO addressDTO = new AddressDTO();
    addressDTO.setStreet(ADDRESS_STREET);
    addressDTO.setExtNumber(ADDRESS_EXT_NUMBER);
    addressDTO.setIntNumber(ADDRESS_INT_NUMBER);
    addressDTO.setColony(ADDRESS_COLONY);
    addressDTO.setMunicipality(ADDRESS_MUNICIPALITY);
    addressDTO.setState(ADDRESS_STATE);
    addressDTO.setZipCode(ADDRESS_ZIP_CODE);

    return addressDTO;
  }

}
