package com.example.vetpatitas.controller;

import com.example.vetpatitas.dto.ResponseDTO;
import com.example.vetpatitas.dto.UserDTO;
import com.example.vetpatitas.service.UserService;
import com.example.vetpatitas.utils.Constants;
import com.sun.media.sound.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.vetpatitas.utils.Constants.ResponseConstants.USER_ADDED_SUCCESSFULLY;
import static com.example.vetpatitas.utils.Constants.ResponseConstants.VALIDATION_USER_BOOTCAMP;

@RestController
@RequestMapping("pet")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUser(@RequestBody UserDTO userDTO){
        return userDTO;
    }

    @PostMapping(path = "bootcamp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<UserDTO>> getUserBootCamp(@RequestBody UserDTO userDTO){
        ResponseDTO responseDTO= new ResponseDTO(Constants.ResponseConstants.SUCCESS, VALIDATION_USER_BOOTCAMP, userService.validateUserBootcamp(userDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<UserDTO>> addUser(@RequestBody UserDTO userDTO) throws InvalidDataException {
        ResponseDTO responseDTO= new ResponseDTO(Constants.ResponseConstants.SUCCESS, USER_ADDED_SUCCESSFULLY, userService.addUser(userDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
