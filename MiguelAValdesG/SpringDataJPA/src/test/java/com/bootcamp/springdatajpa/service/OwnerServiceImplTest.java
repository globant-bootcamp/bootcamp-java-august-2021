package com.bootcamp.springdatajpa.service;

import com.bootcamp.springdatajpa.dao.OwnerDAO;
import com.bootcamp.springdatajpa.dto.AddressDTO;
import com.bootcamp.springdatajpa.dto.OwnerDTO;
import com.bootcamp.springdatajpa.entity.Address;
import com.bootcamp.springdatajpa.entity.Owner;
import com.bootcamp.springdatajpa.exception.InvalidDataException;
import com.bootcamp.springdatajpa.mapper.OwnerMapper;
import com.bootcamp.springdatajpa.service.impl.AddressServiceImpl;
import com.bootcamp.springdatajpa.service.impl.OwnerServiceImpl;
import com.bootcamp.springdatajpa.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_COLONY_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_EXT_NUMBER_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_ID;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_INT_NUMBER_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_MUNICIPALITY_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_STATE_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_STREET_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ADDRESS_ZIP_CODE_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_ACTIVE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_ADDRESS;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_ADDRESS_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_AGE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_AGE_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_EMAIL;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_EMAIL_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_FIRST_NAME;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_FIRST_NAME_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_LAST_NAME;
import static com.bootcamp.springdatajpa.utils.Constants.ONE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_LAST_NAME_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_PHONE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_PHONE_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ZERO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OwnerServiceImplTest {

  @InjectMocks
  private OwnerServiceImpl ownerService;

  @InjectMocks
  private AddressServiceImpl addressService;

  @Mock
  private OwnerMapper ownerMapper;
  @Mock
  private OwnerDAO ownerDAO;

  @Test
  public void whenGetAllOwners_ThenGetOwnersDTO_Ok() {
    List<Owner> ownerList = new ArrayList<>();
    List<OwnerDTO> ownerDTOList = new ArrayList<>();

    Owner owner = createOwner();
    owner.setId(Constants.OWNER_ID);
    Owner owner2 = createOwner();
    owner2.setId(2L);

    ownerList.add(owner);
    ownerList.add(owner2);

    OwnerDTO ownerDTO = createOwnerDTO();
    ownerDTO.setId(Constants.OWNER_ID);
    OwnerDTO ownerDTO2 = createOwnerDTO();
    ownerDTO2.setId(2L);

    ownerDTOList.add(ownerDTO);
    ownerDTOList.add(ownerDTO2);

    when(ownerDAO.findAll()).thenReturn(ownerList);

    List<OwnerDTO> response = ownerService.getAllOwners();

    assertNotNull(response);
    assertEquals(ownerList.get(ZERO).getId(), ownerDTOList.get(ZERO).getId());
    assertEquals(ownerList.get(ZERO).getAddress(), ownerDTOList.get(ZERO).getAddress());
    assertEquals(ownerList.get(ZERO).getFirstName(), ownerDTOList.get(ZERO).getFirstName());
    assertEquals(ownerList.get(ZERO).getLastName(), ownerDTOList.get(ZERO).getLastName());
    assertEquals(ownerList.get(ZERO).getAge(), ownerDTOList.get(ZERO).getAge());
    assertEquals(ownerList.get(ZERO).getEmail(), ownerDTOList.get(ZERO).getEmail());
    assertEquals(ownerList.get(ZERO).getPhone(), ownerDTOList.get(ZERO).getPhone());
    assertEquals(ownerList.get(ZERO).isActive(), ownerDTOList.get(ZERO).isActive());

    assertEquals(ownerList.get(ONE).getId(), ownerDTOList.get(ONE).getId());
    assertEquals(ownerList.get(ONE).getAddress(), ownerDTOList.get(ONE).getAddress());
    assertEquals(ownerList.get(ONE).getFirstName(), ownerDTOList.get(ONE).getFirstName());
    assertEquals(ownerList.get(ONE).getLastName(), ownerDTOList.get(ONE).getLastName());
    assertEquals(ownerList.get(ONE).getAge(), ownerDTOList.get(ONE).getAge());
    assertEquals(ownerList.get(ONE).getEmail(), ownerDTOList.get(ONE).getEmail());
    assertEquals(ownerList.get(ONE).getPhone(), ownerDTOList.get(ONE).getPhone());
    assertEquals(ownerList.get(ONE).isActive(), ownerDTOList.get(ONE).isActive());
  }

  @Test
  public void whenAddOwner_ThenGetOwnerDTO_Ok() {
    OwnerDTO ownerDTORequest = createOwnerDTO();
    Owner ownerRequest = createOwner();

    Owner onwerResponse = createOwner();
    onwerResponse.setId(Constants.OWNER_ID);

    OwnerDTO ownerDTOResponse = createOwnerDTO();
    ownerDTOResponse.setId(Constants.OWNER_ID);

    when(ownerMapper.ownerDTOToEntity(any(OwnerDTO.class))).thenReturn(ownerRequest);
    when(ownerDAO.save(any(Owner.class))).thenReturn(onwerResponse);
    when(ownerMapper.ownerEntityToDTO(any(Owner.class))).thenReturn(ownerDTOResponse);

    OwnerDTO response = ownerService.addOwner(ownerDTORequest);

    assertNotNull(response);
    assertEquals(response.getAddress(), ownerDTORequest.getAddress());
    assertEquals(response.getFirstName(), ownerDTORequest.getFirstName());
    assertEquals(response.getLastName(), ownerDTORequest.getLastName());
    assertEquals(response.getAge(), ownerDTORequest.getAge());
    assertEquals(response.getEmail(), ownerDTORequest.getEmail());
    assertEquals(response.getPhone(), ownerDTORequest.getPhone());
    assertEquals(response.isActive(), ownerDTORequest.isActive());
    verify(ownerMapper, times(ONE)).ownerDTOToEntity(any(OwnerDTO.class));
    verify(ownerMapper, times(ONE)).ownerEntityToDTO(any(Owner.class));
    verify(ownerDAO, times(ONE)).save(any(Owner.class));
  }

  @Test
  public void whenUpdateOwner_ThenGetOwnerDTO_Ok() {
    OwnerDTO ownerDTORequest = new OwnerDTO();
    ownerDTORequest.setAddress(OWNER_ADDRESS_UPDATE);
    ownerDTORequest.setFirstName(OWNER_FIRST_NAME_UPDATE);
    ownerDTORequest.setLastName(OWNER_LAST_NAME_UPDATE);
    ownerDTORequest.setAge(OWNER_AGE_UPDATE);
    ownerDTORequest.setEmail(OWNER_EMAIL_UPDATE);
    ownerDTORequest.setPhone(OWNER_PHONE_UPDATE);
    ownerDTORequest.setActive(true);

    AddressDTO ownerAddressDTORequest = new AddressDTO();
    ownerAddressDTORequest.setId(ADDRESS_ID);
    ownerAddressDTORequest.setStreet(ADDRESS_STREET_UPDATE);
    ownerAddressDTORequest.setExtNumber(ADDRESS_EXT_NUMBER_UPDATE);
    ownerAddressDTORequest.setIntNumber(ADDRESS_INT_NUMBER_UPDATE);
    ownerAddressDTORequest.setColony(ADDRESS_COLONY_UPDATE);
    ownerAddressDTORequest.setMunicipality(ADDRESS_MUNICIPALITY_UPDATE);
    ownerAddressDTORequest.setState(ADDRESS_STATE_UPDATE);
    ownerAddressDTORequest.setZipCode(ADDRESS_ZIP_CODE_UPDATE);

    Owner ownerDb = createOwner();
    ownerDb.setId(Constants.OWNER_ID);

    Owner ownerResponse = createOwner();
    ownerResponse.setId(Constants.OWNER_ID);
    ownerResponse.setAddress(OWNER_ADDRESS_UPDATE);
    ownerResponse.setFirstName(OWNER_FIRST_NAME_UPDATE);
    ownerResponse.setLastName(OWNER_LAST_NAME_UPDATE);
    ownerResponse.setAge(OWNER_AGE_UPDATE);
    ownerResponse.setEmail(OWNER_EMAIL_UPDATE);
    ownerResponse.setPhone(OWNER_PHONE_UPDATE);
    ownerResponse.setActive(true);

    OwnerDTO ownerDTOResponse = new OwnerDTO();
    ownerDTOResponse.setId(Constants.OWNER_ID);
    ownerDTOResponse.setAddress(OWNER_ADDRESS_UPDATE);
    ownerDTOResponse.setFirstName(OWNER_FIRST_NAME_UPDATE);
    ownerDTOResponse.setLastName(OWNER_LAST_NAME_UPDATE);
    ownerDTOResponse.setAge(OWNER_AGE_UPDATE);
    ownerDTOResponse.setEmail(OWNER_EMAIL_UPDATE);
    ownerDTOResponse.setPhone(OWNER_PHONE_UPDATE);
    ownerDTOResponse.setActive(true);

    when(addressService.addressEntityToDTO(any(Address.class))).thenReturn(ownerAddressDTORequest);
    doNothing().when(addressService.updateAddress(ADDRESS_ID, ownerAddressDTORequest));

    when(ownerService.findOwnerById(Constants.OWNER_ID)).thenReturn(ownerDb);
    when(ownerService.fillOwner(ownerDb, ownerDTORequest)).thenReturn(ownerResponse);
    when(ownerDAO.save(any(Owner.class))).thenReturn(ownerResponse);
    when(ownerMapper.ownerEntityToDTO(any(Owner.class))).thenReturn(ownerDTOResponse);

    OwnerDTO response = ownerService.updateOwner(Constants.OWNER_ID, ownerDTORequest);

    assertNotNull(response);
    assertEquals(response.getId(), ownerDTORequest.getId());
    assertEquals(response.getAddress(), ownerDTORequest.getAddress());
    assertEquals(response.getFirstName(), ownerDTORequest.getFirstName());
    assertEquals(response.getLastName(), ownerDTORequest.getLastName());
    assertEquals(response.getAge(), ownerDTORequest.getAge());
    assertEquals(response.getEmail(), ownerDTORequest.getEmail());
    assertEquals(response.getPhone(), ownerDTORequest.getPhone());
    assertEquals(response.isActive(), ownerDTORequest.isActive());
    verify(addressService, times(ONE)).addressEntityToDTO(any(Address.class));
    verify(addressService, times(ONE)).updateAddress(any(Long.class), any(AddressDTO.class));
    verify(ownerService, times(ONE)).findOwnerById(any(Long.class));
    verify(ownerService, times(ONE)).fillOwner(any(Owner.class), any(OwnerDTO.class));
    verify(ownerDAO, times(ONE)).save(any(Owner.class));
    verify(ownerMapper, times(ONE)).ownerEntityToDTO(any(Owner.class));
  }

  @Test
  public void whenDeleteOwner_ThenGetInactiveOwner_Ok() {
    OwnerServiceImpl ownerServiceMock = mock(OwnerServiceImpl.class);

    Owner ownerDb = createOwner();
    ownerDb.setId(Constants.OWNER_ID);

    Owner owner = createOwner();
    owner.setId(Constants.OWNER_ID);
    owner.setActive(false);

    OwnerDTO ownerDTO = createOwnerDTO();
    ownerDTO.setId(Constants.OWNER_ID);
    ownerDTO.setActive(false);

    when(ownerServiceMock.findOwnerById(Constants.OWNER_ID)).thenReturn(ownerDb);
    when(ownerDAO.save(any(Owner.class))).thenReturn(owner);
    when(ownerMapper.ownerEntityToDTO(any(Owner.class))).thenReturn(ownerDTO);

    OwnerDTO response = ownerService.deleteOwner(Constants.OWNER_ID);

    assertNotNull(response);
    assertEquals(response.getId(), ownerDTO.getId());
    assertEquals(response.getAddress(), ownerDTO.getAddress());
    assertEquals(response.getFirstName(), ownerDTO.getFirstName());
    assertEquals(response.getLastName(), ownerDTO.getLastName());
    assertEquals(response.getAge(), ownerDTO.getAge());
    assertEquals(response.getEmail(), ownerDTO.getEmail());
    assertEquals(response.getPhone(), ownerDTO.getPhone());
    assertNotSame(response.isActive(), ownerDTO.isActive());
    verify(ownerServiceMock, times(ONE)).findOwnerById(any(Long.class));
    verify(ownerDAO, times(ONE)).save(any(Owner.class));
    verify(ownerMapper, times(ONE)).ownerEntityToDTO(any(Owner.class));
  }

  @Test
  public void whenFillOwner_ThenGetOwner_Ok() {
    Owner owner = createOwner();
    owner.setId(Constants.OWNER_ID);

    OwnerDTO ownerDTO = createOwnerDTO();
    ownerDTO.setId(Constants.OWNER_ID);

    Owner response = ownerService.fillOwner(owner, ownerDTO);

    assertNotNull(response);
    assertEquals(response.getId(), owner.getId());
    assertEquals(response.getAddress(), owner.getAddress());
    assertEquals(response.getFirstName(), owner.getFirstName());
    assertEquals(response.getLastName(), owner.getLastName());
    assertEquals(response.getAge(), owner.getAge());
    assertEquals(response.getEmail(), owner.getEmail());
    assertEquals(response.getPhone(), owner.getPhone());
    assertEquals(response.isActive(), owner.isActive());
  }

  @Test
  public void whenFindOwnerById_ThenGetOwner_Ok() {
    Owner owner = createOwner();
    owner.setId(Constants.OWNER_ID);
    Optional<Owner> ownerOptional = Optional.of(owner);

    when(ownerDAO.findById(any(Long.class))).thenReturn(ownerOptional);

    Owner response = ownerService.findOwnerById(Constants.OWNER_ID);

    assertNotNull(response);
    assertEquals(response.getId(), owner.getId());
    assertEquals(response.getAddress(), owner.getAddress());
    assertEquals(response.getFirstName(), owner.getFirstName());
    assertEquals(response.getLastName(), owner.getLastName());
    assertEquals(response.getAge(), owner.getAge());
    assertEquals(response.getEmail(), owner.getEmail());
    assertEquals(response.getPhone(), owner.getPhone());
    assertEquals(response.isActive(), owner.isActive());
    verify(ownerDAO, times(ONE)).findById(any(Long.class));
  }

  @Test(expected = InvalidDataException.class)
  public void whenFindOwnerById_ThenOwnerNotFound() {
    when(ownerDAO.findById(any(Long.class))).thenReturn(Optional.empty());

    Owner response = ownerService.findOwnerById(any(Long.class));

    assertNull(response);
    verify(ownerDAO, times(ONE)).findById(any(Long.class));
  }

  private OwnerDTO createOwnerDTO() {
    OwnerDTO ownerDTO = new OwnerDTO();
    ownerDTO.setAddress(OWNER_ADDRESS);
    ownerDTO.setFirstName(OWNER_FIRST_NAME);
    ownerDTO.setLastName(OWNER_LAST_NAME);
    ownerDTO.setAge(OWNER_AGE);
    ownerDTO.setEmail(OWNER_EMAIL);
    ownerDTO.setPhone(OWNER_PHONE);
    ownerDTO.setActive(OWNER_ACTIVE);

    return ownerDTO;
  }

  private Owner createOwner() {
    Owner owner = new Owner();
    owner.setAddress(OWNER_ADDRESS);
    owner.setFirstName(OWNER_FIRST_NAME);
    owner.setLastName(OWNER_LAST_NAME);
    owner.setAge(OWNER_AGE);
    owner.setEmail(OWNER_EMAIL);
    owner.setPhone(OWNER_PHONE);
    owner.setActive(OWNER_ACTIVE);

    return owner;
  }

}
