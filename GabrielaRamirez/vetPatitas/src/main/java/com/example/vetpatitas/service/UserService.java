package com.example.vetpatitas.service;

import com.example.vetpatitas.dto.UserDTO;
import com.sun.media.sound.InvalidDataException;

public interface UserService {

    UserDTO validateUserBootcamp(UserDTO userDTO);

    UserDTO addUser(UserDTO userDTO) throws InvalidDataException;
}
