package com.bootcamp.springdatacrud.service;

import com.bootcamp.springdatacrud.dto.UserDTO;

public interface UserService {
    UserDTO validateUserBootcamp(UserDTO userDTO);

    UserDTO addUser (UserDTO userDTO);
}
