package com.example.vetpatitas.service.impl;

import com.example.vetpatitas.dao.UserDAO;
import com.example.vetpatitas.dto.UserDTO;
import com.example.vetpatitas.exception.InvalidDataException;
import com.example.vetpatitas.mapper.UserMapper;
import com.example.vetpatitas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.vetpatitas.utils.Constants.ResponseConstants.INVALID_USER_AGE;

@Service
public class UserServiceIm implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDTO validateUserBootcamp(UserDTO userDTO) {
        return userDTO;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO){

        if (userDTO.getAge() < 0){
            throw new InvalidDataException(INVALID_USER_AGE);
        }

        return userMapper.userEntityToDTO(userDAO.save(userMapper.userDTOEntity(userDTO)));

    }

}
