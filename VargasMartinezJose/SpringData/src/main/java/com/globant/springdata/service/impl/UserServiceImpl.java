package com.globant.springdata.service.impl;


import com.globant.springdata.dao.UserDAO;
import com.globant.springdata.dto.UserDTO;
import com.globant.springdata.exception.InvalidDataException;
import com.globant.springdata.mapper.UserMapper;
import com.globant.springdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.globant.springdata.utils.Constants.DOG;
import static com.globant.springdata.utils.Constants.SPECIES_NOT_VALID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDTO addUser(UserDTO userDTO){
        if(!(userDTO.getSpecies().equals(DOG))){
            throw new InvalidDataException(SPECIES_NOT_VALID);
        }
        return userMapper.userEntityToDTO(userDAO.save(userMapper.userDTOToEntity(userDTO)));
    }
}
