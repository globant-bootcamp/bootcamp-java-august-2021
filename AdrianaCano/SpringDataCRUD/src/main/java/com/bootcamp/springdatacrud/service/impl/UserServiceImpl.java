package com.bootcamp.springdatacrud.service.impl;

import com.bootcamp.springdatacrud.dao.UserDAO;
import com.bootcamp.springdatacrud.dto.UserDTO;
import com.bootcamp.springdatacrud.exception.NotFoundException;
import com.bootcamp.springdatacrud.mapper.UserMapper;
import com.bootcamp.springdatacrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserDAO userDAO;

    @Override
    public UserDTO validateUserBootcamp(UserDTO userDTO){
        if(userDTO.getBootcampEvaluation() >= 9 && userDTO.getAttitude().equals("POSITIVE")){
            userDTO.setApproved(Boolean.TRUE);
        }else{
            userDTO.setApproved(Boolean.FALSE);
        }
        return userDTO;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO){
        if(userDTO.getAge() < 18){
            throw new NotFoundException("INVALID AGE");
        }
        return userMapper.userEntityToDTO(userDAO.save(userMapper.userDTOToEntity(userDTO)));
    }
}
