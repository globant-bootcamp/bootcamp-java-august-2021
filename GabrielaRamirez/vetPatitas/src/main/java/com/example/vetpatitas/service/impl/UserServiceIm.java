package com.example.vetpatitas.service.impl;

import com.example.vetpatitas.dao.UserDAO;
import com.example.vetpatitas.dto.UserDTO;
import com.example.vetpatitas.mapper.UserMapper;
import com.example.vetpatitas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.vetpatitas.utils.Constants.ResponseConstants.POSITIVE;

@Service
public class UserServiceIm implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserDAO userDAO;

//    @Override
//    public UserDTO validateUserBootcamp(UserDTO userDTO) {
//
//        if (userDTO.getWeight()>=9 && userDTO.getOwner().equals(POSITIVE)){
//            userDTO.setApproved(Boolean.TRUE);
//        }else {
//            userDTO.setApproved(Boolean.FALSE);
//        }
//
//        return userDTO;
//    }

    @Override
    public UserDTO validateUserBootcamp(UserDTO userDTO) {
        return userDTO;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {

        return  userMapper.userEntityToDTO(userDAO.save(userMapper.UserDTOEntity(userDTO)));

    }

}
