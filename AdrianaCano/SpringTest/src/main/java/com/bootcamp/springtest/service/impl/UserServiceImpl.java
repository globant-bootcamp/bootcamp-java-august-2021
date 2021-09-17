package com.bootcamp.springtest.service.impl;

import com.bootcamp.springtest.dto.UserDTO;
import com.bootcamp.springtest.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO validateUserBootcamp(UserDTO userDTO){
        //here is all the logic o business rules
        if(userDTO.getBootcampEvaluation() >= 9 && userDTO.getAttitude().equals("POSITIVE")){
            userDTO.setApproved(Boolean.TRUE);
        }else{
            userDTO.setApproved(Boolean.FALSE);
        }
        return userDTO;
    }
}
