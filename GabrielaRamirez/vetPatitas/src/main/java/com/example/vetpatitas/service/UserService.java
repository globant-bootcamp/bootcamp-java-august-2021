package com.example.vetpatitas.service;

import com.example.vetpatitas.dto.UserDTO;

public interface UserService {

    UserDTO validateUserBootcamp(UserDTO userDTO);

    UserDTO addUser(UserDTO userDTO);
}
