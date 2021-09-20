package com.globant.springdata.service;

import com.globant.springdata.dto.UserDTO;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);
    UserDTO deleteUser(Long id);
    UserDTO updateUser(UserDTO userDTO);
    UserDTO findById(Long id);
    UserDTO setApointment(UserDTO userDTO);
}
