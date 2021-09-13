package com.example.vetpatitas.mapper;

import com.example.vetpatitas.dto.UserDTO;
import com.example.vetpatitas.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User userDTOEntity(UserDTO userDTO){

        User user = new User();

        user.setName(userDTO.getName());
        user.setSpecies(userDTO.getSpecies());
        user.setAge(userDTO.getAge());
        user.setWeight(userDTO.getWeight());
        user.setOwner(userDTO.getOwner());
        user.setTelephone(userDTO.getTelephone());

        return user;
    }

    public UserDTO userEntityToDTO(User user){

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSpecies(user.getSpecies());
        userDTO.setAge(user.getAge());
        userDTO.setWeight(user.getWeight());
        userDTO.setOwner(user.getOwner());
        userDTO.setTelephone(user.getTelephone());

        return userDTO;
    }
}
