package com.bootcamp.springdatacrud.controller;

import com.bootcamp.springdatacrud.dto.ResponseDTO;
import com.bootcamp.springdatacrud.dto.UserDTO;
import com.bootcamp.springdatacrud.service.UserService;
import com.bootcamp.springdatacrud.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bootcamp.springdatacrud.utils.Constants.USER_ADDED_SUCCESSFULLY;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/{id}")
    public String hackerrank(@PathVariable Integer id, @RequestParam String name) {
        return "hola mundo!" + name;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUser(@RequestBody UserDTO userDTO) {
        return userDTO;
    }

    @PostMapping(path = "/bootcamp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUserBootcamp(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.validateUserBootcamp(userDTO), HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<UserDTO>> addUser(@RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, USER_ADDED_SUCCESSFULLY, userService.addUser(userDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
