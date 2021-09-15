package com.bootcamp.springdatacrud.service;
import com.bootcamp.springdatacrud.dao.UserDAO;
import com.bootcamp.springdatacrud.dto.UserDTO;
import com.bootcamp.springdatacrud.entity.User;
import com.bootcamp.springdatacrud.exception.NotFoundException;
import com.bootcamp.springdatacrud.mapper.UserMapper;
import com.bootcamp.springdatacrud.service.impl.UserServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    UserMapper userMapper;

    @Mock
    UserDAO userDAO;

    @Test
    public void addUser_whenAgeOverSeventeen_Ok(){
        UserDTO userDTORequest = new UserDTO();
        userDTORequest.setFirstName("Generic FirstName");
        userDTORequest.setLastName("Generic LastName");
        userDTORequest.setAge(18);
        userDTORequest.setBootcampEvaluation(8.5);
        userDTORequest.setAttitude("POSITIVE");
        userDTORequest.setApproved(Boolean.FALSE);

        User userEntity = new User();
        userEntity.setFirstName("Generic FirstName");
        userEntity.setLastName("Generic LastName");
        userEntity.setAge(18);
        userEntity.setBootcampEvaluation(8.5);
        userEntity.setAttitude("POSITIVE");
        userEntity.setApproved(Boolean.FALSE);

        User userEntityResponse = new User();
        userEntityResponse.setId(1L);
        userEntityResponse.setFirstName("Generic FirstName");
        userEntityResponse.setLastName("Generic LastName");
        userEntityResponse.setAge(18);
        userEntityResponse.setBootcampEvaluation(8.5);
        userEntityResponse.setAttitude("POSITIVE");
        userEntityResponse.setApproved(Boolean.FALSE);

        UserDTO userDTOResponse = new UserDTO();
        userDTOResponse.setId(1L);
        userDTOResponse.setFirstName("Generic FirstName");
        userDTOResponse.setLastName("Generic LastName");
        userDTOResponse.setAge(18);
        userDTOResponse.setBootcampEvaluation(8.5);
        userDTOResponse.setAttitude("POSITIVE");
        userDTOResponse.setApproved(Boolean.FALSE);

        when(userMapper.userDTOToEntity(any(UserDTO.class))).thenReturn(userEntity);
        when(userDAO.save(any(User.class))).thenReturn(userEntityResponse);
        when(userMapper.userEntityToDTO(any(User.class))).thenReturn(userDTOResponse);

        UserDTO response = userService.addUser(userDTORequest);

        assertNotNull(response);
        assertEquals(response, userDTOResponse);
        assertEquals(response.getFirstName(), userDTOResponse.getFirstName());
        assertEquals(response.getLastName(), userDTOResponse.getLastName());
        assertEquals(response.getAge(), userDTOResponse.getAge());
        assertEquals(response.getBootcampEvaluation(), userDTOResponse.getBootcampEvaluation());
        assertEquals(response.getAttitude(), userDTOResponse.getAttitude());
        assertEquals(response.getApproved(), userDTOResponse.getApproved());

        Mockito.verify(userMapper, times(1)).userDTOToEntity((any(UserDTO.class)));
        Mockito.verify(userDAO, times(1)).save((any(User.class)));
        Mockito.verify(userMapper, times(1)).userEntityToDTO((any(User.class)));
    }


    @Test(expected = NotFoundException.class)
    public void addUser_whenAgeUnderSeventeen_thenNotFoundException(){
        UserDTO userDTORequest = new UserDTO();
        userDTORequest.setFirstName("Generic FirstName");
        userDTORequest.setLastName("Generic LastName");
        userDTORequest.setAge(16);
        userDTORequest.setBootcampEvaluation(8.5);
        userDTORequest.setAttitude("POSITIVE");
        userDTORequest.setApproved(Boolean.FALSE);

        userService.addUser(userDTORequest);
    }
}
