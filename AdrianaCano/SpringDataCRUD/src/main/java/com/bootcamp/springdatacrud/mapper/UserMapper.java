package com.bootcamp.springdatacrud.mapper;

import com.bootcamp.springdatacrud.dto.UserDTO;
import com.bootcamp.springdatacrud.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User userDTOToEntity(UserDTO userDTO){
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAge(userDTO.getAge());
        user.setBootcampEvaluation(userDTO.getBootcampEvaluation());
        user.setAttitude(userDTO.getAttitude());
        user.setApproved(userDTO.getApproved());
        return user;
    }

    public UserDTO userEntityToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAge(user.getAge());
        userDTO.setBootcampEvaluation(user.getBootcampEvaluation());
        userDTO.setAttitude(user.getAttitude());
        userDTO.setApproved(user.getApproved());
        return userDTO;
    }
}
