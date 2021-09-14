package com.bolsadeideas.springboot.bootcamp.app.service.implement;

import com.bolsadeideas.springboot.bootcamp.app.dao.OwnerDao;
import com.bolsadeideas.springboot.bootcamp.app.dto.RequestDTO;
import com.bolsadeideas.springboot.bootcamp.app.entity.Animal;
import com.bolsadeideas.springboot.bootcamp.app.entity.Owner;
import com.bolsadeideas.springboot.bootcamp.app.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.NO_FOUND_OWNER;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OwnerServiceImplTests {

    @InjectMocks
    private OwnerServiceImpl ownerService;

    @Mock
    private OwnerDao ownerDao;

    @Test
    public void findAllTest_findAllOwner(){
        Animal animal = new Animal();
        animal.setName("Don perro");
        animal.setType("Dog");
        animal.setSterilization(true);
        animal.setAge(3);
        List<Animal>list = new ArrayList<>();
        list.add(animal);

        Owner ownerRequest = new Owner();
        ownerRequest.setName("pedro");
        ownerRequest.setPhone("7778881155");
        ownerRequest.setAnimals(list);

        when(ownerDao.findAll()).thenReturn(List.of(ownerRequest));

        List<Owner> ownerList = ownerService.findAll();
        assertNotNull(ownerList);
        assertEquals("pedro", ownerList.get(0).getName());
    }

    @Test
    public void saveTest_saveOwner(){
        Animal animalRequest = new Animal();
        animalRequest.setName("Don perro");
        animalRequest.setType("Dog");
        animalRequest.setSterilization(true);
        animalRequest.setAge(3);

        Animal animalResponse = new Animal();
        animalResponse.setId(1L);
        animalResponse.setName("Don perro");
        animalResponse.setType("Dog");
        animalResponse.setSterilization(true);
        animalResponse.setAge(3);

        Owner ownerRequest = new Owner();
        ownerRequest.setName("pedro");
        ownerRequest.setPhone("7778881155");
        ownerRequest.setAnimals(List.of(animalRequest));

        Owner ownerResponse = new Owner();
        ownerResponse.setId(1L);
        ownerResponse.setName("pedro");
        ownerResponse.setPhone("7778881155");
        ownerResponse.setAnimals(List.of(animalResponse));

        RequestDTO requestDTO = new RequestDTO(ownerRequest);
        RequestDTO requestDTOMock = mock(RequestDTO.class);

        when(requestDTOMock.getOwner()).thenReturn(ownerRequest);
        when(ownerDao.save(any(Owner.class))).thenReturn(ownerResponse);

        Owner owner = ownerService.save(requestDTO);

        assertNotNull(owner);
        assertEquals("pedro",owner.getName());

    }

    @Test
    public void findById_findOwnerId_ok(){
        Animal animalRequest = new Animal();
        animalRequest.setName("Don perro");
        animalRequest.setType("Dog");
        animalRequest.setSterilization(true);
        animalRequest.setAge(3);

        Owner ownerRequest = new Owner();
        ownerRequest.setId(1L);
        ownerRequest.setName("pedro");
        ownerRequest.setPhone("7778881155");
        ownerRequest.setAnimals(List.of(animalRequest));
        Optional<Owner> ownerOptional = Optional.of(ownerRequest);

        when(ownerDao.findById(any(Long.class))).thenReturn(ownerOptional);

        Owner owner = ownerService.findById(1L);
        assertNotNull(owner);
        assertEquals("pedro", owner.getName());
    }

    @Test(expected = NotFoundException.class)
    public void findById_findOwnerId_exceptionOwnerNotFound(){
        when(ownerDao.findById(any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_OWNER));
        Owner ownerError = ownerService.findById(2L);
        assertNull(ownerError);
    }

    @Test
    public void deleteOwnerTest_deleteOwner_ok(){
        Animal animalResponse = new Animal();
        animalResponse.setId(1L);
        animalResponse.setName("Don perro");
        animalResponse.setType("Dog");
        animalResponse.setSterilization(true);
        animalResponse.setAge(3);

        Owner ownerResponse = new Owner();
        ownerResponse.setId(1L);
        ownerResponse.setName("pedro");
        ownerResponse.setPhone("7778881155");
        ownerResponse.setAnimals(List.of(animalResponse));
        Optional<Owner> ownerOptional = Optional.of(ownerResponse);

        doNothing().when(ownerDao).deleteById(any(Long.class));
        OwnerServiceImpl ownerServiceMock = mock(OwnerServiceImpl.class);
        when(ownerDao.findById(any(Long.class))).thenReturn(ownerOptional);
        when(ownerServiceMock.findById(any(Long.class))).thenReturn(ownerResponse);

        Owner owner = ownerService.deleteOwner(1L);

        assertNotNull(owner);
        assertEquals("pedro",owner.getName());
        verify(ownerDao,times(1)).deleteById(1L);

    }

    @Test(expected = NotFoundException.class)
    public void deleteOwnerTest_deleteOwner_exceptionOwnerNotFound(){
        Animal animalResponse = new Animal();
        animalResponse.setId(1L);
        animalResponse.setName("Don perro");
        animalResponse.setType("Dog");
        animalResponse.setSterilization(true);
        animalResponse.setAge(3);

        Owner ownerResponse = new Owner();
        ownerResponse.setId(1L);
        ownerResponse.setName("pedro");
        ownerResponse.setPhone("7778881155");
        ownerResponse.setAnimals(List.of(animalResponse));
        Optional<Owner> ownerOptional = Optional.of(ownerResponse);

        OwnerServiceImpl ownerServiceMock = mock(OwnerServiceImpl.class);
        when(ownerDao.findById(any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_OWNER));
        when(ownerServiceMock.findById(any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_OWNER));

        Owner ownerError = ownerService.deleteOwner(1L);
        assertNull(ownerError);
    }

    @Test
    public void updateOwner_updateOwner_ok(){
        Animal animalRequest = new Animal();
        animalRequest.setId(1L);
        animalRequest.setName("Don perro");
        animalRequest.setType("Dog");
        animalRequest.setSterilization(true);
        animalRequest.setAge(3);

        Owner ownerRequest = new Owner();
        Owner ownerRequestSpy = Mockito.spy(ownerRequest);
        ownerRequestSpy.setId(1L);
        ownerRequestSpy.setName("pedro");
        ownerRequestSpy.setPhone("7778881155");
        ownerRequestSpy.setAnimals(List.of(animalRequest));

        Animal animalResponse = new Animal();
        animalResponse.setId(1L);
        animalResponse.setName("Don perro");
        animalResponse.setType("Dog");
        animalResponse.setSterilization(true);
        animalResponse.setAge(3);

        Owner ownerResponse = new Owner();
        Owner ownerResponseSpy = Mockito.spy(ownerResponse);
        ownerResponseSpy.setId(1L);
        ownerResponseSpy.setName("pancho");
        ownerResponseSpy.setPhone("1118884869");
        ownerResponseSpy.setAnimals(List.of(animalResponse));
        Optional<Owner> ownerOptional = Optional.of(ownerResponseSpy);

        RequestDTO requestDTO = new RequestDTO(ownerRequestSpy);
        RequestDTO requestDTOSpy = Mockito.spy(requestDTO);
        OwnerServiceImpl ownerServiceImplMock = mock(OwnerServiceImpl.class);

        when(ownerDao.save(any(Owner.class))).thenReturn(ownerRequestSpy);
        when(ownerServiceImplMock.save(any(RequestDTO.class))).thenReturn(ownerRequestSpy);
        when(ownerDao.findById(any(Long.class))).thenReturn(ownerOptional);
        when(ownerServiceImplMock.findById(any(Long.class))).thenReturn(ownerResponseSpy);

        Owner owner = ownerService.updateOwner(requestDTOSpy);

        assertNotNull(owner);
        verify(requestDTOSpy.getOwner(),times(1)).getName();
        verify(ownerResponseSpy,times(1)).setPhone("7778881155");
    }

    @Test(expected = NotFoundException.class)
    public void updateOwner_updateOwnerNotFoundException(){
        Animal animalResponse = new Animal();
        animalResponse.setId(1L);
        animalResponse.setName("Don perro");
        animalResponse.setType("Dog");
        animalResponse.setSterilization(true);
        animalResponse.setAge(3);

        Owner ownerResponse = new Owner();
        ownerResponse.setId(1L);
        ownerResponse.setName("pancho");
        ownerResponse.setPhone("1118884869");
        ownerResponse.setAnimals(List.of(animalResponse));
        Optional<Owner> ownerOptional = Optional.of(ownerResponse);

        OwnerServiceImpl ownerServiceImplMock = mock(OwnerServiceImpl.class);

        when(ownerDao.findById(any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_OWNER));
        when(ownerServiceImplMock.findById(any(Long.class))).thenThrow(new NotFoundException(NO_FOUND_OWNER));

        Owner owner = ownerService.deleteOwner(2L);
        assertNotNull(owner);
        verify(ownerDao,times(1)).findById(2L);
    }
}
