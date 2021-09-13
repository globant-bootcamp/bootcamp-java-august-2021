package com.example.vetpatitas.service;

import com.example.vetpatitas.dao.UserDAO;
import com.example.vetpatitas.dto.UserDTO;
import com.example.vetpatitas.entity.User;
import com.example.vetpatitas.mapper.UserMapper;
import com.example.vetpatitas.service.impl.UserServiceIm;
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
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceIm userService;

    @Mock
    UserMapper userMapper;

    @Mock
    UserDAO userDAO;

    @Test
    public void addUser_WhenAgeOverOne_OK(){

        UserDTO userDTORequest = new UserDTO();
        userDTORequest.setName("GenericName");
        userDTORequest.setSpecies("GenereicSpecies");
        userDTORequest.setAge(3);
        userDTORequest.setWeight(5);
        userDTORequest.setOwner("GenericOwner");
        userDTORequest.setTelephone(3767L);

        UserDTO userDTOResponse = new UserDTO();
        userDTOResponse.setId(1l);
        userDTOResponse.setName("GenericName");
        userDTOResponse.setSpecies("GenereicSpecies");
        userDTOResponse.setAge(3);
        userDTOResponse.setWeight(5);
        userDTOResponse.setOwner("GenericOwner");
        userDTOResponse.setTelephone(3767L);

        User userRequest = new User();
        userRequest.setName("GenericName");
        userRequest.setSpecies("GenereicSpecies");
        userRequest.setAge(3);
        userRequest.setWeight(5);
        userRequest.setOwner("GenericOwner");
        userRequest.setTelephone(3767L);

        User userResponse = new User();
        userDTOResponse.setId(1l);
        userResponse.setName("GenericName");
        userResponse.setSpecies("GenereicSpecies");
        userResponse.setAge(3);
        userResponse.setWeight(5);
        userResponse.setOwner("GenericOwner");
        userResponse.setTelephone(3767L);

        when(userMapper.userEntityToDTO(any(User.class))).thenReturn(userDTOResponse);
        when(userDAO.save(any(User.class))).thenReturn(userResponse);
        when(userMapper.userDTOEntity(any(UserDTO.class))).thenReturn(userRequest);

        UserDTO response= userService.addUser(userDTORequest);

        assertNotNull(response);
        assertEquals(response, userDTOResponse);
        assertEquals(response.getName(), userDTORequest.getName());

        Mockito.verify(userMapper, times(1)).userDTOEntity(any(UserDTO.class));
        Mockito.verify(userDAO, times(1)).save(any(User.class));
        Mockito.verify(userMapper, times(1)).userEntityToDTO(any(User.class));
    }


}
