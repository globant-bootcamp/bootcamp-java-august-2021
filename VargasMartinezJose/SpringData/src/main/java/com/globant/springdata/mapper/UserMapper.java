package com.globant.springdata.mapper;

import com.globant.springdata.dto.UserDTO;
import com.globant.springdata.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User userDTOToEntity(UserDTO userDTO){
        User user = new User();
        user.setSpecies(userDTO.getSpecies());
        user.setFirstName(userDTO.getFirstName());
        user.setOwnersName(userDTO.getOwnersName());
        user.setLastname(userDTO.getLastName());
        user.setRace(userDTO.getRace());
        user.setAge(userDTO.getAge());
        user.setWeight(userDTO.getWeight());
        user.setHealthy(userDTO.getHealthy());
        return user;
    }
    public UserDTO userEntityToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setSpecies(user.getSpecies());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setOwnersName(user.getOwnersName());
        userDTO.setLastName(user.getLastname());
        userDTO.setRace(user.getRace());
        userDTO.setAge(user.getAge());
        userDTO.setWeight(user.getWeight());
        userDTO.setHealthy(user.getHealthy());
        return userDTO;
    }
}
