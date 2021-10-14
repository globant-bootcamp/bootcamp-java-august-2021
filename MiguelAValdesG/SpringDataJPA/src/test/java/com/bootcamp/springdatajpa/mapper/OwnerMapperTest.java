package com.bootcamp.springdatajpa.mapper;

import com.bootcamp.springdatajpa.dto.OwnerDTO;
import com.bootcamp.springdatajpa.entity.Owner;
import com.bootcamp.springdatajpa.service.impl.OwnerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static com.bootcamp.springdatajpa.utils.Constants.ONE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_ACTIVE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_ADDRESS;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_AGE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_EMAIL;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_FIRST_NAME;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_ID;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_LAST_NAME;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_PHONE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OwnerMapperTest {

  @InjectMocks
  private OwnerMapper ownerMapper;

  @Test
  public void whenOwnerEntityToDTO() {
    Owner owner = createOwner();
    owner.setId(OWNER_ID);

    OwnerDTO ownerDTO = createOwnerDTO();
    ownerDTO.setId(OWNER_ID);

    OwnerDTO response = ownerMapper.ownerEntityToDTO(any(Owner.class));

    assertNotNull(response);
    assertEquals(response.getId(), owner.getId());
    assertEquals(response.getAddress(), owner.getAddress());
    assertEquals(response.getFirstName(), owner.getFirstName());
    assertEquals(response.getLastName(), owner.getLastName());
    assertEquals(response.getAge(), owner.getAge());
    assertEquals(response.getEmail(), owner.getEmail());
    assertEquals(response.getPhone(), owner.getPhone());
    assertEquals(response.isActive(), owner.isActive());
    verify(ownerMapper, times(ONE)).ownerEntityToDTO(any(Owner.class));

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
