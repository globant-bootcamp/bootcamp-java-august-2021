package com.globant.springdata.service;

import com.globant.springdata.dao.UserDAO;
import com.globant.springdata.dto.UserDTO;
import com.globant.springdata.entity.User;
import com.globant.springdata.exception.InvalidDataException;
import com.globant.springdata.mapper.UserMapper;
import com.globant.springdata.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    UserMapper userMapper;

    @Mock
    UserDAO userDAO;

    @Test
    public void addUserTest_WhenSpeciesIsDog_Ok(){

        UserDTO userDTORequest= new UserDTO();
        userDTORequest.setFirstName("Rocky");
        userDTORequest.setLastName("Vargas");
        userDTORequest.setOwnersName("José");
        userDTORequest.setSpecies("DOG");
        userDTORequest.setRace("Dogo");
        userDTORequest.setAge(2);
        userDTORequest.setWeight(45);
        userDTORequest.setHealthy(Boolean.TRUE);

        UserDTO userDTOResponse = new UserDTO();
        userDTOResponse.setId(1);
        userDTOResponse.setFirstName("Rocky");
        userDTOResponse.setLastName("Vargas");
        userDTOResponse.setOwnersName("José");
        userDTOResponse.setSpecies("DOG");
        userDTOResponse.setRace("Dogo");
        userDTOResponse.setAge(2);
        userDTOResponse.setWeight(45);
        userDTOResponse.setHealthy(Boolean.TRUE);

        User userRequest= new User();
        userRequest.setFirstName("Rocky");
        userRequest.setLastName("Vargas");
        userRequest.setOwnersName("José");
        userRequest.setSpecies("DOG");
        userRequest.setRace("Dogo");
        userRequest.setAge(2);
        userRequest.setWeight(45);
        userRequest.setHealthy(Boolean.TRUE);

        User userResponse = new User();
        userResponse.setId(1);
        userResponse.setFirstName("Rocky");
        userResponse.setLastName("Vargas");
        userResponse.setOwnersName("José");
        userResponse.setSpecies("DOG");
        userResponse.setRace("Dogo");
        userResponse.setAge(2);
        userResponse.setWeight(45);
        userResponse.setHealthy(Boolean.TRUE);

        when(userMapper.userDTOToEntity(any(UserDTO.class))).thenReturn(userRequest);
        when(userDAO.save(any(User.class))).thenReturn(userResponse);
        when(userMapper.userEntityToDTO(any(User.class))).thenReturn(userDTOResponse);

        UserDTO response= userService.addUser(userDTORequest);

        assertNotNull(response);
        assertEquals(response.getFirstName(),userDTOResponse.getFirstName());
        assertEquals(response.getLastName(),userDTOResponse.getLastName());
        assertEquals(response.getOwnersName(),userDTOResponse.getOwnersName());
        assertEquals(response.getSpecies(),userDTOResponse.getSpecies());
        assertEquals(response.getRace(),userDTOResponse.getRace());
        assertEquals(response.getAge(),userDTOResponse.getAge());
        assertEquals(response.getWeight(),userDTOResponse.getWeight());
        assertEquals(response.getHealthy(),userDTOResponse.getHealthy());

        Mockito.verify(userMapper,times(1)).userDTOToEntity(any(UserDTO.class));
        Mockito.verify(userDAO,times(1)).save(any(User.class));
        Mockito.verify(userMapper,times(1)).userEntityToDTO(any(User.class));
    }
    @Test(expected = InvalidDataException.class)
    public void addUserTest_WhenSpeciesNotDog_ThenInvalidException(){
        UserDTO userDTORequest= new UserDTO();
        userDTORequest.setFirstName("Rocky");
        userDTORequest.setLastName("Vargas");
        userDTORequest.setOwnersName("José");
        userDTORequest.setSpecies("CAT");
        userDTORequest.setRace("Dogo");
        userDTORequest.setAge(2);
        userDTORequest.setWeight(45);
        userDTORequest.setHealthy(Boolean.TRUE);

        userService.addUser(userDTORequest);
    }
}
