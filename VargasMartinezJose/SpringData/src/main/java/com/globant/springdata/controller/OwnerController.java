package com.globant.springdata.controller;

import com.globant.springdata.dto.RequestDTO;
import com.globant.springdata.dto.ResponseDTO;
import com.globant.springdata.dto.UserDTO;
import com.globant.springdata.entity.Response;
import com.globant.springdata.service.InterfaceOwnerService;
import com.globant.springdata.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.globant.springdata.utils.Constants.DELETED_USER;
import static com.globant.springdata.utils.Constants.USER_ADDED_SUCCESSFULLY;


@RestController
public class OwnerController {

    @Autowired
    private InterfaceOwnerService ownerService;

    @GetMapping("/owners")
    public List<Owner> findAll(){
        return ownerService.findAll();
    }

    @PostMapping("/owners")
    public ResponseEntity<Response<String>> add(@RequestBody RequestDTO requestDto) {
        Response response = new Response(Constants.ResponseConstants.SUCCESS,USER_ADDED_SUCCESSFULLY, ownerService.save(requestDto));
        return new ResponseEntity<RequestDTO<UserDTO>>(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/owners/{id}")
    public ResponseEntity<Response<String>> deleteOwner(@PathVariable Long id) {
        Response response = new Response(Constants.ResponseConstants.SUCCESS, DELETED_USER,ownerService.deleteOwner(id));
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
}