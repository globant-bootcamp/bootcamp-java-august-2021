package com.globant.springdata.service.impl;

import com.globant.springdata.dao.UserDAO;
import com.globant.springdata.dto.UserDTO;
import com.globant.springdata.entity.User;
import com.globant.springdata.exception.InvalidDataException;
import com.globant.springdata.mapper.UserMapper;
import com.globant.springdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.globant.springdata.utils.Constants.DOG;
import static com.globant.springdata.utils.Constants.SET_APOINTMENT;
import static com.globant.springdata.utils.Constants.SPECIES_NOT_VALID;
import static com.globant.springdata.utils.Constants.USER_WAS_NOT_FOUND;


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

    @Override
    public UserDTO deleteUser(Long id) {
        UserDTO deletedUser = findById(id);
        userDAO.deleteById(id);
        return userMapper.userEntityToDTO(userDAO.save(userMapper.userDTOToEntity(deletedUser)));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        userDTO.setOwnersName(userDTO.getOwnersName());
        return userMapper.userEntityToDTO(userDAO.save(userMapper.userDTOToEntity(userDTO)));
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userDAO.findById(id).orElse(null);
        if(user == null){
            throw new IllegalArgumentException(USER_WAS_NOT_FOUND);
        }
        return userMapper.userEntityToDTO(userDAO.save(userMapper.userDTOToEntity(user)));
    }

    @Override
    public UserDTO setApointment(UserDTO userDTO) {
        if(userDTO.getHealthy().equals(false)){
            throw new InvalidDataException(SET_APOINTMENT);
    }
        return userMapper.userEntityToDTO(userDAO.save(userMapper.userDTOToEntity(userDTO)));
    }
}

