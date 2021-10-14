package com.bootcamp.springdatajpa.controller;

import com.bootcamp.springdatajpa.dto.OwnerDTO;
import com.bootcamp.springdatajpa.dto.ResponseDTO;
import com.bootcamp.springdatajpa.service.OwnerService;
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

import static com.bootcamp.springdatajpa.utils.Constants.ONE;
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
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_LAST_NAME_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_PHONE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_PHONE_UPDATE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OwnerControllerTest {

  @InjectMocks
  private OwnerController ownerController;

  @Mock
  private OwnerService ownerService;

  @Test
  public void whenGetAllOwners_ThenGetOwnersDTO_Ok() {
    List<OwnerDTO> ownerDTOList = new ArrayList<>();

    OwnerDTO ownerDTO = createOwnerDTO();
    ownerDTO.setId(Constants.OWNER_ID);
    OwnerDTO ownerDTO2 = createOwnerDTO();
    ownerDTO2.setId(2L);

    ownerDTOList.add(ownerDTO);
    ownerDTOList.add(ownerDTO2);

    when(ownerService.getAllOwners()).thenReturn(ownerDTOList);

    ResponseEntity<ResponseDTO<List<OwnerDTO>>> response = ownerController.getAllOwners();

    assertNotNull(response);
    verify(ownerService, times(ONE)).getAllOwners();
  }

  @Test
  public void whenAddOwner_ThenGetOwnerDTO_Ok() {
    OwnerDTO ownerDTORequest = createOwnerDTO();

    OwnerDTO ownerDTOResponse = createOwnerDTO();
    ownerDTOResponse.setId(Constants.OWNER_ID);

    when(ownerService.addOwner(any(OwnerDTO.class))).thenReturn(ownerDTOResponse);

    ResponseEntity<ResponseDTO<OwnerDTO>> response = ownerController.addOwner(ownerDTORequest);

    assertNotNull(response);
    assertEquals(Objects.requireNonNull(response.getBody()).getContent().getAddress(), ownerDTORequest.getAddress());
    assertEquals(response.getBody().getContent().getFirstName(), ownerDTORequest.getFirstName());
    assertEquals(response.getBody().getContent().getLastName(), ownerDTORequest.getLastName());
    assertEquals(response.getBody().getContent().getAge(), ownerDTORequest.getAge());
    assertEquals(response.getBody().getContent().getEmail(), ownerDTORequest.getEmail());
    assertEquals(response.getBody().getContent().getPhone(), ownerDTORequest.getPhone());
    assertEquals(response.getBody().getContent().isActive(), ownerDTORequest.isActive());
    verify(ownerService, times(ONE)).addOwner(any(OwnerDTO.class));
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

    OwnerDTO ownerDTOResponse = new OwnerDTO();
    ownerDTOResponse.setId(Constants.OWNER_ID);
    ownerDTOResponse.setAddress(OWNER_ADDRESS_UPDATE);
    ownerDTOResponse.setFirstName(OWNER_FIRST_NAME_UPDATE);
    ownerDTOResponse.setLastName(OWNER_LAST_NAME_UPDATE);
    ownerDTOResponse.setAge(OWNER_AGE_UPDATE);
    ownerDTOResponse.setEmail(OWNER_EMAIL_UPDATE);
    ownerDTOResponse.setPhone(OWNER_PHONE_UPDATE);
    ownerDTOResponse.setActive(true);

    when(ownerService.updateOwner(any(Long.class), any(OwnerDTO.class))).thenReturn(ownerDTOResponse);

    ResponseEntity<ResponseDTO<OwnerDTO>> response = ownerController.updateOwner(any(Long.class), ownerDTORequest);

    assertNotNull(response);
    assertEquals(Objects.requireNonNull(response.getBody()).getContent().getAddress(), ownerDTORequest.getAddress());
    assertEquals(response.getBody().getContent().getFirstName(), ownerDTORequest.getFirstName());
    assertEquals(response.getBody().getContent().getLastName(), ownerDTORequest.getLastName());
    assertEquals(response.getBody().getContent().getAge(), ownerDTORequest.getAge());
    assertEquals(response.getBody().getContent().getEmail(), ownerDTORequest.getEmail());
    assertEquals(response.getBody().getContent().getPhone(), ownerDTORequest.getPhone());
    assertEquals(response.getBody().getContent().isActive(), ownerDTORequest.isActive());
    verify(ownerService, times(ONE)).updateOwner(any(Long.class), any(OwnerDTO.class));
  }

  @Test
  public void whenDeleteOwner_ThenGetInactiveOwner_Ok() {
    OwnerDTO ownerDTORequest = createOwnerDTO();

    OwnerDTO ownerDTOResponse = createOwnerDTO();
    ownerDTOResponse.setId(Constants.OWNER_ID);

    when(ownerService.deleteOwner(any(Long.class))).thenReturn(ownerDTOResponse);

    ResponseEntity<ResponseDTO<OwnerDTO>> response = ownerController.deleteOwner(any(Long.class));

    assertNotNull(response);
    assertEquals(Objects.requireNonNull(response.getBody()).getContent().getAddress(), ownerDTORequest.getAddress());
    assertEquals(response.getBody().getContent().getFirstName(), ownerDTORequest.getFirstName());
    assertEquals(response.getBody().getContent().getLastName(), ownerDTORequest.getLastName());
    assertEquals(response.getBody().getContent().getAge(), ownerDTORequest.getAge());
    assertEquals(response.getBody().getContent().getEmail(), ownerDTORequest.getEmail());
    assertEquals(response.getBody().getContent().getPhone(), ownerDTORequest.getPhone());
    assertEquals(response.getBody().getContent().isActive(), ownerDTORequest.isActive());
    verify(ownerService, times(ONE)).deleteOwner(any(Long.class));
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

}
