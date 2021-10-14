package com.bootcamp.springdatajpa.service;

import com.bootcamp.springdatajpa.dao.AddressDAO;
import com.bootcamp.springdatajpa.dao.OwnerDAO;
import com.bootcamp.springdatajpa.dto.AddressDTO;
import com.bootcamp.springdatajpa.entity.Address;
import com.bootcamp.springdatajpa.entity.Owner;
import com.bootcamp.springdatajpa.exception.InvalidDataException;
import com.bootcamp.springdatajpa.mapper.AddressMapper;
import com.bootcamp.springdatajpa.service.impl.AddressServiceImpl;
import com.bootcamp.springdatajpa.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.bootcamp.springdatajpa.utils.Constants.OWNER_ACTIVE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_AGE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_COLONY;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_COLONY_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_EMAIL;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_EXT_NUMBER;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_EXT_NUMBER_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_FIRST_NAME;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_ID;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_INT_NUMBER;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_INT_NUMBER_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_LAST_NAME;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_MUNICIPALITY;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_MUNICIPALITY_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ONE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_PHONE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_STATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_STATE_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_STREET;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_STREET_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ZERO;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_ZIP_CODE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_ZIP_CODE_UPDATE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceImplTest {

  @InjectMocks
  private AddressServiceImpl addressService;

  @Mock
  private AddressMapper addressMapper;
  @Mock
  private AddressDAO addressDAO;
  @Mock
  private OwnerDAO ownerDAO;

  @Test
  public void whenGetAllAddresses_ThenGetAddressesDTO_Ok() {
    List<Address> addressList = new ArrayList<>();
    List<AddressDTO> addressDTOList = new ArrayList<>();

    Address address = createAddress();
    address.setId(ADDRESS_ID);

    Address address2 = createAddress();
    address2.setId(2L);

    addressList.add(address);
    addressList.add(address2);

    AddressDTO addressDTOONE = createAddressDTO();
    addressDTOONE.setId(ADDRESS_ID);

    AddressDTO addressDTO2 = createAddressDTO();
    addressDTO2.setId(2L);

    addressDTOList.add(addressDTOONE);
    addressDTOList.add(addressDTO2);

    when(addressDAO.findAll()).thenReturn(addressList);

    List<AddressDTO> response = addressService.getAllAddresses();

    assertNotNull(response);
    assertEquals(addressList.get(ZERO).getId(), addressDTOList.get(ZERO).getId());
    assertEquals(addressList.get(ZERO).getStreet(), addressDTOList.get(ZERO).getStreet());
    assertEquals(addressList.get(ZERO).getExtNumber(), addressDTOList.get(ZERO).getExtNumber());
    assertEquals(addressList.get(ZERO).getIntNumber(), addressDTOList.get(ZERO).getIntNumber());
    assertEquals(addressList.get(ZERO).getColony(), addressDTOList.get(ZERO).getColony());
    assertEquals(addressList.get(ZERO).getMunicipality(), addressDTOList.get(ZERO).getMunicipality());
    assertEquals(addressList.get(ZERO).getState(), addressDTOList.get(ZERO).getState());
    assertEquals(addressList.get(ZERO).getZipCode(), addressDTOList.get(ZERO).getZipCode());

    assertEquals(addressList.get(ONE).getId(), addressDTOList.get(ONE).getId());
    assertEquals(addressList.get(ONE).getStreet(), addressDTOList.get(ONE).getStreet());
    assertEquals(addressList.get(ONE).getExtNumber(), addressDTOList.get(ONE).getExtNumber());
    assertEquals(addressList.get(ONE).getIntNumber(), addressDTOList.get(ONE).getIntNumber());
    assertEquals(addressList.get(ONE).getColony(), addressDTOList.get(ONE).getColony());
    assertEquals(addressList.get(ONE).getMunicipality(), addressDTOList.get(ONE).getMunicipality());
    assertEquals(addressList.get(ONE).getState(), addressDTOList.get(ONE).getState());
    assertEquals(addressList.get(ONE).getZipCode(), addressDTOList.get(ONE).getZipCode());
  }

  @Test
  public void whenAddAddress_ThenGetAddressDTO_Ok() {
    AddressDTO addressDTORequest = createAddressDTO();
    Address addressRequest = createAddress();

    Address addressResponse = createAddress();
    addressResponse.setId(ADDRESS_ID);

    AddressDTO addressDTOResponse = createAddressDTO();
    addressDTOResponse.setId(ADDRESS_ID);

    when(addressMapper.addressDTOToEntity(any(AddressDTO.class))).thenReturn(addressRequest);
    when(addressDAO.save(any(Address.class))).thenReturn(addressResponse);
    when(addressMapper.addressEntityToDTO(any(Address.class))).thenReturn(addressDTOResponse);

    AddressDTO response = addressService.addAddress(addressDTORequest);

    assertNotNull(response);
    assertEquals(response.getStreet(), addressDTORequest.getStreet());
    assertEquals(response.getExtNumber(), addressDTORequest.getExtNumber());
    assertEquals(response.getIntNumber(), addressDTORequest.getIntNumber());
    assertEquals(response.getColony(), addressDTORequest.getColony());
    assertEquals(response.getMunicipality(), addressDTORequest.getMunicipality());
    assertEquals(response.getState(), addressDTORequest.getState());
    assertEquals(response.getZipCode(), addressDTORequest.getZipCode());
    verify(addressMapper, times(ONE)).addressDTOToEntity(any(AddressDTO.class));
    verify(addressMapper, times(ONE)).addressEntityToDTO(any(Address.class));
    verify(addressDAO, times(ONE)).save(any(Address.class));
  }

  @Test
  public void whenUpdateAddress_ThenGetAddressDTO_Ok() {
    AddressDTO addressDTORequest = new AddressDTO();
    addressDTORequest.setId(ADDRESS_ID);
    addressDTORequest.setStreet(ADDRESS_STREET_UPDATE);
    addressDTORequest.setExtNumber(ADDRESS_EXT_NUMBER_UPDATE);
    addressDTORequest.setIntNumber(ADDRESS_INT_NUMBER_UPDATE);
    addressDTORequest.setColony(ADDRESS_COLONY_UPDATE);
    addressDTORequest.setMunicipality(ADDRESS_MUNICIPALITY_UPDATE);
    addressDTORequest.setState(ADDRESS_STATE_UPDATE);
    addressDTORequest.setZipCode(ADDRESS_ZIP_CODE_UPDATE);

    Address addressDb = createAddress();
    addressDb.setId(ADDRESS_ID);

    Address addressResponse = createAddress();
    addressResponse.setId(ADDRESS_ID);
    addressResponse.setStreet(ADDRESS_STREET_UPDATE);
    addressResponse.setExtNumber(ADDRESS_EXT_NUMBER_UPDATE);
    addressResponse.setIntNumber(ADDRESS_INT_NUMBER_UPDATE);
    addressResponse.setColony(ADDRESS_COLONY_UPDATE);
    addressResponse.setMunicipality(ADDRESS_MUNICIPALITY_UPDATE);
    addressResponse.setState(ADDRESS_STATE_UPDATE);
    addressResponse.setZipCode(ADDRESS_ZIP_CODE_UPDATE);

    when(addressService.findAddressById(ADDRESS_ID)).thenReturn(addressDb);
    when(addressService.fillAddress(addressDb, addressDTORequest)).thenReturn(addressResponse);
    when(addressDAO.save(any(Address.class))).thenReturn(addressResponse);
    when(addressMapper.addressEntityToDTO(any(Address.class))).thenReturn(addressDTORequest);

    AddressDTO response = addressService.updateAddress(ADDRESS_ID, addressDTORequest);

    assertNotNull(response);
    assertEquals(response.getId(), addressDTORequest.getId());
    assertEquals(response.getStreet(), addressDTORequest.getStreet());
    assertEquals(response.getExtNumber(), addressDTORequest.getExtNumber());
    assertEquals(response.getIntNumber(), addressDTORequest.getIntNumber());
    assertEquals(response.getColony(), addressDTORequest.getColony());
    assertEquals(response.getMunicipality(), addressDTORequest.getMunicipality());
    assertEquals(response.getState(), addressDTORequest.getState());
    assertEquals(response.getZipCode(), addressDTORequest.getZipCode());
    verify(addressService, times(ONE)).findAddressById(any(Long.class));
    verify(addressService, times(ONE)).fillAddress(any(Address.class), any(AddressDTO.class));
    verify(addressDAO, times(ONE)).save(any(Address.class));
    verify(addressMapper, times(ONE)).addressEntityToDTO(any(Address.class));
  }

  @Test
  public void whenDeleteAddress_ThenAddressDeletedSuccessfully_Ok() {
    AddressServiceImpl addressServiceMock = mock(AddressServiceImpl.class);

    Address addressDb = createAddress();
    addressDb.setId(ADDRESS_ID);

    when(ownerDAO.findByIdAddress(ADDRESS_ID)).thenReturn(Optional.empty());
    when(addressServiceMock.findAddressById(any(Long.class))).thenReturn(addressDb);
    doNothing().when(addressDAO).delete(any(Address.class));

    String response = addressService.deleteAddress(ADDRESS_ID);

    assertNotNull(response);
    verify(ownerDAO, times(ONE)).findByIdAddress(any(Long.class));
    verify(addressServiceMock, times(ONE)).findAddressById(any(Long.class));
    verify(addressDAO, times(ONE)).delete(any(Address.class));
  }

  @Test(expected = InvalidDataException.class)
  public void whenDeleteAddress_ThenAddressCannotBeDeleted() {
    Owner owner = new Owner();
    owner.setId(Constants.OWNER_ID);
    owner.setFirstName(OWNER_FIRST_NAME);
    owner.setLastName(OWNER_LAST_NAME);
    owner.setAge(OWNER_AGE);
    owner.setEmail(OWNER_EMAIL);
    owner.setPhone(OWNER_PHONE);
    owner.setActive(OWNER_ACTIVE);
    Optional<Owner> ownerOptional = Optional.of(owner);

    when(ownerDAO.findByIdAddress(ADDRESS_ID)).thenReturn(ownerOptional);

    String response = addressService.deleteAddress(any(Long.class));

    assertNull(response);
    verify(ownerDAO, times(ONE)).findByIdAddress(any(Long.class));
  }

  @Test
  public void whenFillAddress_ThenGetAddress_Ok() {
    Address address = createAddress();
    address.setId(ADDRESS_ID);

    AddressDTO addressDTO = createAddressDTO();
    addressDTO.setId(ADDRESS_ID);

    Address response = addressService.fillAddress(address, addressDTO);

    assertNotNull(response);
    assertEquals(response.getId(), addressDTO.getId());
    assertEquals(response.getStreet(), addressDTO.getStreet());
    assertEquals(response.getExtNumber(), addressDTO.getExtNumber());
    assertEquals(response.getIntNumber(), addressDTO.getIntNumber());
    assertEquals(response.getColony(), addressDTO.getColony());
    assertEquals(response.getMunicipality(), addressDTO.getMunicipality());
    assertEquals(response.getState(), addressDTO.getState());
    assertEquals(response.getZipCode(), addressDTO.getZipCode());
  }

  @Test
  public void whenFindAddress_ThenGetAddress_Ok() {
    Address address = createAddress();
    address.setId(ADDRESS_ID);
    Optional<Address> addressOptional = Optional.of(address);

    when(addressDAO.findById(any(Long.class))).thenReturn(addressOptional);

    Address response = addressService.findAddressById(ADDRESS_ID);

    assertNotNull(response);
    assertEquals(response.getId(), address.getId());
    assertEquals(response.getStreet(), address.getStreet());
    assertEquals(response.getExtNumber(), address.getExtNumber());
    assertEquals(response.getIntNumber(), address.getIntNumber());
    assertEquals(response.getColony(), address.getColony());
    assertEquals(response.getMunicipality(), address.getMunicipality());
    assertEquals(response.getState(), address.getState());
    assertEquals(response.getZipCode(), address.getZipCode());
    verify(addressDAO, times(ONE)).findById(any(Long.class));
  }

  @Test(expected = InvalidDataException.class)
  public void whenFindAddress_ThenAddressNotFound() {
    when(addressDAO.findById(any(Long.class))).thenReturn(Optional.empty());

    Address response = addressService.findAddressById(any(Long.class));

    assertNull(response);
    verify(addressDAO, times(ONE)).findById(any(Long.class));
  }

  @Test
  public void whenAddressEntityToDTO_ThenAddressDTO() {
    Address address = createAddress();
    address.setId(ADDRESS_ID);

    AddressDTO addressDTO = createAddressDTO();
    addressDTO.setId(ADDRESS_ID);

    when(addressMapper.addressEntityToDTO(address)).thenReturn(addressDTO);

    AddressDTO response = addressService.addressEntityToDTO(address);

    assertNotNull(response);
    assertEquals(response.getId(), address.getId());
    assertEquals(response.getStreet(), address.getStreet());
    assertEquals(response.getExtNumber(), address.getExtNumber());
    assertEquals(response.getIntNumber(), address.getIntNumber());
    assertEquals(response.getColony(), address.getColony());
    assertEquals(response.getMunicipality(), address.getMunicipality());
    assertEquals(response.getState(), address.getState());
    assertEquals(response.getZipCode(), address.getZipCode());
    verify(addressMapper, times(ONE)).addressEntityToDTO(any(Address.class));
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

  private Address createAddress() {
    Address address = new Address();
    address.setStreet(ADDRESS_STREET);
    address.setExtNumber(ADDRESS_EXT_NUMBER);
    address.setIntNumber(ADDRESS_INT_NUMBER);
    address.setColony(ADDRESS_COLONY);
    address.setMunicipality(ADDRESS_MUNICIPALITY);
    address.setState(ADDRESS_STATE);
    address.setZipCode(ADDRESS_ZIP_CODE);

    return address;
  }

}
