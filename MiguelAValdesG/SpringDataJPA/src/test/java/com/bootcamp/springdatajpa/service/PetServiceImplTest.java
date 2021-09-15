package com.bootcamp.springdatajpa.service;

import com.bootcamp.springdatajpa.dao.PetDAO;
import com.bootcamp.springdatajpa.dto.PetDTO;
import com.bootcamp.springdatajpa.entity.Pet;
import com.bootcamp.springdatajpa.entity.Owner;
import com.bootcamp.springdatajpa.exception.InvalidDataException;
import com.bootcamp.springdatajpa.mapper.PetMapper;
import com.bootcamp.springdatajpa.service.impl.OwnerServiceImpl;
import com.bootcamp.springdatajpa.service.impl.PetServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.bootcamp.springdatajpa.utils.Constants.OWNER_ACTIVE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_ADDRESS;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_AGE;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_EMAIL;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_FIRST_NAME;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_ID;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_LAST_NAME;
import static com.bootcamp.springdatajpa.utils.Constants.OWNER_PHONE;
import static com.bootcamp.springdatajpa.utils.Constants.PET_ACTIVE;
import static com.bootcamp.springdatajpa.utils.Constants.PET_AGE;
import static com.bootcamp.springdatajpa.utils.Constants.PET_AGE_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.PET_BREED;
import static com.bootcamp.springdatajpa.utils.Constants.PET_BREED_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.PET_COLOR;
import static com.bootcamp.springdatajpa.utils.Constants.PET_COLOR_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.PET_ID;
import static com.bootcamp.springdatajpa.utils.Constants.ONE;
import static com.bootcamp.springdatajpa.utils.Constants.PET_ID_OWNER;
import static com.bootcamp.springdatajpa.utils.Constants.PET_ID_OWNER_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.PET_NAME;
import static com.bootcamp.springdatajpa.utils.Constants.PET_NAME_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.PET_OWNER;
import static com.bootcamp.springdatajpa.utils.Constants.PET_OWNER_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.PET_SPECIES;
import static com.bootcamp.springdatajpa.utils.Constants.PET_SPECIES_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.PET_WEIGHT;
import static com.bootcamp.springdatajpa.utils.Constants.PET_WEIGHT_UPDATE;
import static com.bootcamp.springdatajpa.utils.Constants.ZERO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetServiceImplTest {

  @InjectMocks
  private PetServiceImpl petService;

  @InjectMocks
  private OwnerServiceImpl ownerService;

  @Mock
  private PetMapper petMapper;
  @Mock
  private PetDAO petDAO;

  @Test
  public void whenGetAllPets_ThenGetPetsDTO_Ok() {
    List<Pet> petList = new ArrayList<>();
    List<PetDTO> petDTOList = new ArrayList<>();

    Pet pet = createPet();
    pet.setId(PET_ID);
    Pet pet2 = createPet();
    pet2.setId(2L);

    petList.add(pet);
    petList.add(pet2);

    PetDTO petDTO = createPetDTO();
    petDTO.setId(PET_ID);
    PetDTO petDTO2 = createPetDTO();
    petDTO2.setId(2L);

    petDTOList.add(petDTO);
    petDTOList.add(petDTO2);

    when(petDAO.findAll()).thenReturn(petList);

    List<PetDTO> response = petService.getAllPets();

    assertNotNull(response);
    assertEquals(petList.get(ZERO).getId(), petDTOList.get(ZERO).getId());
    assertEquals(petList.get(ZERO).getOwner().getId(), petDTOList.get(ZERO).getIdOwner());
    assertEquals(petList.get(ZERO).getName(), petDTOList.get(ZERO).getName());
    assertEquals(petList.get(ZERO).getAge(), petDTOList.get(ZERO).getAge());
    assertEquals(petList.get(ZERO).getSpecies(), petDTOList.get(ZERO).getSpecies());
    assertEquals(petList.get(ZERO).getBreed(), petDTOList.get(ZERO).getBreed());
    assertEquals(petList.get(ZERO).getColor(), petDTOList.get(ZERO).getColor());
    assertEquals(petList.get(ZERO).getWeight(), petDTOList.get(ZERO).getWeight());
    assertEquals(petList.get(ZERO).isActive(), petDTOList.get(ZERO).isActive());

    assertEquals(petList.get(ONE).getId(), petDTOList.get(ONE).getId());
    assertEquals(petList.get(ONE).getOwner().getId(), petDTOList.get(ONE).getIdOwner());
    assertEquals(petList.get(ONE).getName(), petDTOList.get(ONE).getName());
    assertEquals(petList.get(ONE).getAge(), petDTOList.get(ONE).getAge());
    assertEquals(petList.get(ONE).getSpecies(), petDTOList.get(ONE).getSpecies());
    assertEquals(petList.get(ONE).getBreed(), petDTOList.get(ONE).getBreed());
    assertEquals(petList.get(ONE).getColor(), petDTOList.get(ONE).getColor());
    assertEquals(petList.get(ONE).getWeight(), petDTOList.get(ONE).getWeight());
    assertEquals(petList.get(ONE).isActive(), petDTOList.get(ONE).isActive());

  }

  @Test
  public void whenGetAllOwnersPets_ThenGetPetsDTO_Ok() {
    List<Pet> petList = new ArrayList<>();
    List<PetDTO> petDTOList = new ArrayList<>();

    Pet pet = createPet();
    pet.setId(PET_ID);
    Pet pet2 = createPet();
    pet2.setId(2L);

    petList.add(pet);
    petList.add(pet2);

    PetDTO petDTO = createPetDTO();
    petDTO.setId(PET_ID);
    PetDTO petDTO2 = createPetDTO();
    petDTO2.setId(2L);

    petDTOList.add(petDTO);
    petDTOList.add(petDTO2);

    when(petDAO.findAllOwnersPets(any(Long.class))).thenReturn(petList);

    List<PetDTO> response = petService.getAllOwnersPets(any(Long.class));

    assertNotNull(response);
    assertEquals(petList.get(ZERO).getId(), petDTOList.get(ZERO).getId());
    assertEquals(petList.get(ZERO).getOwner().getId(), petDTOList.get(ZERO).getIdOwner());
    assertEquals(petList.get(ZERO).getName(), petDTOList.get(ZERO).getName());
    assertEquals(petList.get(ZERO).getAge(), petDTOList.get(ZERO).getAge());
    assertEquals(petList.get(ZERO).getSpecies(), petDTOList.get(ZERO).getSpecies());
    assertEquals(petList.get(ZERO).getBreed(), petDTOList.get(ZERO).getBreed());
    assertEquals(petList.get(ZERO).getColor(), petDTOList.get(ZERO).getColor());
    assertEquals(petList.get(ZERO).getWeight(), petDTOList.get(ZERO).getWeight());
    assertEquals(petList.get(ZERO).isActive(), petDTOList.get(ZERO).isActive());

    assertEquals(petList.get(ONE).getId(), petDTOList.get(ONE).getId());
    assertEquals(petList.get(ONE).getOwner().getId(), petDTOList.get(ONE).getIdOwner());
    assertEquals(petList.get(ONE).getName(), petDTOList.get(ONE).getName());
    assertEquals(petList.get(ONE).getAge(), petDTOList.get(ONE).getAge());
    assertEquals(petList.get(ONE).getSpecies(), petDTOList.get(ONE).getSpecies());
    assertEquals(petList.get(ONE).getBreed(), petDTOList.get(ONE).getBreed());
    assertEquals(petList.get(ONE).getColor(), petDTOList.get(ONE).getColor());
    assertEquals(petList.get(ONE).getWeight(), petDTOList.get(ONE).getWeight());
    assertEquals(petList.get(ONE).isActive(), petDTOList.get(ONE).isActive());

  }

  @Test
  public void whenAddPet_ThenGetPetDTO_Ok() {
    PetDTO petDTORequest = createPetDTO();
    Pet petRequest = createPet();

    Pet petResponse = createPet();
    petResponse.setId(PET_ID);

    PetDTO petDTOResponse = createPetDTO();
    petDTOResponse.setId(PET_ID);

    when(petMapper.petDTOToEntity(any(PetDTO.class))).thenReturn(petRequest);
    when(petDAO.save(any(Pet.class))).thenReturn(petResponse);
    when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTOResponse);

    PetDTO response = petService.addPet(petDTORequest);

    assertNotNull(response);
    assertEquals(response.getId(), petDTORequest.getId());
    assertEquals(response.getIdOwner(), petDTORequest.getIdOwner());
    assertEquals(response.getName(), petDTORequest.getName());
    assertEquals(response.getAge(), petDTORequest.getAge());
    assertEquals(response.getSpecies(), petDTORequest.getSpecies());
    assertEquals(response.getBreed(), petDTORequest.getBreed());
    assertEquals(response.getColor(), petDTORequest.getColor());
    assertEquals(response.getWeight(), petDTORequest.getWeight());
    assertEquals(response.isActive(), petDTORequest.isActive());
    verify(petMapper, times(ONE)).petDTOToEntity(any(PetDTO.class));
    verify(petMapper, times(ONE)).petEntityToDTO(any(Pet.class));
    verify(petDAO, times(ONE)).save(any(Pet.class));
  }

  @Test
  public void whenUpdatePet_ThenGetPetDTO_Ok() {
    PetDTO petDTORequest = new PetDTO();
    petDTORequest.setId(PET_ID);
    petDTORequest.setIdOwner(PET_ID_OWNER_UPDATE);
    petDTORequest.setName(PET_NAME_UPDATE);
    petDTORequest.setAge(PET_AGE_UPDATE);
    petDTORequest.setSpecies(PET_SPECIES_UPDATE);
    petDTORequest.setBreed(PET_BREED_UPDATE);
    petDTORequest.setColor(PET_COLOR_UPDATE);
    petDTORequest.setWeight(PET_WEIGHT_UPDATE);
    petDTORequest.setActive(PET_ACTIVE);

    Pet petDb = createPet();
    petDb.setId(PET_ID);

    Pet petResponse = createPet();
    petResponse.setId(PET_ID);
    petResponse.setOwner(PET_OWNER_UPDATE);
    petResponse.setName(PET_NAME_UPDATE);
    petResponse.setAge(PET_AGE_UPDATE);
    petResponse.setSpecies(PET_SPECIES_UPDATE);
    petResponse.setBreed(PET_BREED_UPDATE);
    petResponse.setColor(PET_COLOR_UPDATE);
    petResponse.setWeight(PET_WEIGHT_UPDATE);
    petResponse.setActive(PET_ACTIVE);

    when(petService.findPetById(PET_ID)).thenReturn(petDb);
    when(petService.fillPet(petDb, petDTORequest)).thenReturn(petResponse);
    when(petDAO.save(any(Pet.class))).thenReturn(petResponse);
    when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTORequest);

    PetDTO response = petService.updatePet(PET_ID, petDTORequest);

    assertNotNull(response);
    assertEquals(response.getId(), petDTORequest.getId());
    assertEquals(response.getIdOwner(), petDTORequest.getIdOwner());
    assertEquals(response.getName(), petDTORequest.getName());
    assertEquals(response.getAge(), petDTORequest.getAge());
    assertEquals(response.getSpecies(), petDTORequest.getSpecies());
    assertEquals(response.getBreed(), petDTORequest.getBreed());
    assertEquals(response.getColor(), petDTORequest.getColor());
    assertEquals(response.getWeight(), petDTORequest.getWeight());
    assertEquals(response.isActive(), petDTORequest.isActive());
    verify(petService, times(ONE)).findPetById(any(Long.class));
    verify(petService, times(ONE)).fillPet(any(Pet.class), any(PetDTO.class));
    verify(petDAO, times(ONE)).save(any(Pet.class));
    verify(petMapper, times(ONE)).petEntityToDTO(any(Pet.class));
  }

  @Test
  public void whenDeletePet_ThenGetInactivePet_Ok() {
    PetServiceImpl petServiceMock = mock(PetServiceImpl.class);

    Pet petDb = createPet();
    petDb.setId(PET_ID);

    Pet pet = createPet();
    pet.setId(PET_ID);
    pet.setActive(false);

    PetDTO petDTO = createPetDTO();
    petDTO.setId(PET_ID);
    petDTO.setActive(false);

    when(petServiceMock.findPetById(PET_ID)).thenReturn(petDb);
    when(petDAO.save(any(Pet.class))).thenReturn(pet);
    when(petMapper.petEntityToDTO(any(Pet.class))).thenReturn(petDTO);

    PetDTO response = petService.deletePet(PET_ID);

    assertNotNull(response);
    assertEquals(response.getId(), petDTO.getId());
    assertEquals(response.getIdOwner(), petDTO.getIdOwner());
    assertEquals(response.getName(), petDTO.getName());
    assertEquals(response.getAge(), petDTO.getAge());
    assertEquals(response.getSpecies(), petDTO.getSpecies());
    assertEquals(response.getBreed(), petDTO.getBreed());
    assertEquals(response.getColor(), petDTO.getColor());
    assertEquals(response.getWeight(), petDTO.getWeight());
    assertNotSame(response.isActive(), petDTO.isActive());
    verify(petServiceMock, times(ONE)).findPetById(any(Long.class));
    verify(petDAO, times(ONE)).save(any(Pet.class));
    verify(petMapper, times(ONE)).petEntityToDTO(any(Pet.class));
  }

  @Test
  public void whenFillPet_ThenGetPet_Ok() {
    Pet pet = createPet();
    pet.setId(PET_ID);

    PetDTO petDTO = createPetDTO();
    petDTO.setId(PET_ID);

    Owner ownerDb = new Owner();
    ownerDb.setId(OWNER_ID);
    ownerDb.setAddress(OWNER_ADDRESS);
    ownerDb.setFirstName(OWNER_FIRST_NAME);
    ownerDb.setLastName(OWNER_LAST_NAME);
    ownerDb.setAge(OWNER_AGE);
    ownerDb.setEmail(OWNER_EMAIL);
    ownerDb.setPhone(OWNER_PHONE);
    ownerDb.setActive(OWNER_ACTIVE);

    when(ownerService.findOwnerById(any(Long.class))).thenReturn(ownerDb);

    Pet response = petService.fillPet(pet, petDTO);

    assertNotNull(response);
    assertEquals(response.getId(), petDTO.getId());
    assertEquals(response.getOwner().getId(), ownerDb.getId());
    assertEquals(response.getName(), petDTO.getName());
    assertEquals(response.getAge(), petDTO.getAge());
    assertEquals(response.getSpecies(), petDTO.getSpecies());
    assertEquals(response.getBreed(), petDTO.getBreed());
    assertEquals(response.getColor(), petDTO.getColor());
    assertEquals(response.getWeight(), petDTO.getWeight());
    assertEquals(response.isActive(), petDTO.isActive());
  }

  @Test
  public void whenFindPetById_ThenGetPet_Ok() {
    Pet pet = createPet();
    pet.setId(PET_ID);
    Optional<Pet> petOptional = Optional.of(pet);

    when(petDAO.findById(any(Long.class))).thenReturn(petOptional);

    Pet response = petService.findPetById(PET_ID);

    assertNotNull(response);
    assertEquals(response.getId(), pet.getId());
    assertEquals(response.getOwner().getId(), pet.getOwner().getId());
    assertEquals(response.getName(), pet.getName());
    assertEquals(response.getAge(), pet.getAge());
    assertEquals(response.getSpecies(), pet.getSpecies());
    assertEquals(response.getBreed(), pet.getBreed());
    assertEquals(response.getColor(), pet.getColor());
    assertEquals(response.getWeight(), pet.getWeight());
    assertEquals(response.isActive(), pet.isActive());
    verify(petDAO, times(ONE)).findById(any(Long.class));
  }

  @Test(expected = InvalidDataException.class)
  public void whenFindPetById_ThenPetNotFound() {
    when(petDAO.findById(any(Long.class))).thenReturn(Optional.empty());

    Pet response = petService.findPetById(any(Long.class));

    assertNull(response);
    verify(petDAO, times(ONE)).findById(any(Long.class));
  }

  private PetDTO createPetDTO() {
    PetDTO petDTO = new PetDTO();
    petDTO.setId(PET_ID);
    petDTO.setIdOwner(PET_ID_OWNER);
    petDTO.setName(PET_NAME);
    petDTO.setAge(PET_AGE);
    petDTO.setSpecies(PET_SPECIES);
    petDTO.setBreed(PET_BREED);
    petDTO.setColor(PET_COLOR);
    petDTO.setWeight(PET_WEIGHT);
    petDTO.setActive(PET_ACTIVE);

    return petDTO;
  }

  private Pet createPet() {
    Pet pet = new Pet();
    pet.setId(PET_ID);
    pet.setOwner(PET_OWNER);
    pet.setName(PET_NAME);
    pet.setAge(PET_AGE);
    pet.setSpecies(PET_SPECIES);
    pet.setBreed(PET_BREED);
    pet.setColor(PET_COLOR);
    pet.setWeight(PET_WEIGHT);
    pet.setActive(PET_ACTIVE);

    return pet;
  }

}
