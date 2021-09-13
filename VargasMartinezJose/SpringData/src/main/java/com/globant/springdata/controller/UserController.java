package com.globant.springdata.controller;

import com.globant.springdata.dto.ResponseDTO;
import com.globant.springdata.dto.UserDTO;
import com.globant.springdata.service.UserService;
import com.globant.springdata.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.globant.springdata.utils.Constants.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<UserDTO>> addUser(@RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, USER_ADDED_SUCCESSFULLY, userService.addUser(userDTO));
        return new ResponseEntity<ResponseDTO<UserDTO>>(responseDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("animals/{id}")
    public ResponseEntity<ResponseDTO<String>> deleteAnimal(@PathVariable Long id){
        ResponseDTO responseDTO= new ResponseDTO(Constants.ResponseConstants.SUCCESS,DELETED_USER, userService.addUser(UserDTO));
        return  new ResponseEntity<ResponseDTO<UserDTO>>(responseDTO, HttpStatus.DELETED);
    }

}


