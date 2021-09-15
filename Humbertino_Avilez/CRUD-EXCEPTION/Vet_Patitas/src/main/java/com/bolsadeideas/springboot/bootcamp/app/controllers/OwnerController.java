package com.bolsadeideas.springboot.bootcamp.app.controllers;

import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.OWNER_FOUND;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.OWNER_CREATED;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.OWNER_DELETED;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.OWNER_UPDATED;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.bootcamp.app.dto.RequestDTO;
import com.bolsadeideas.springboot.bootcamp.app.entity.Owner;
import com.bolsadeideas.springboot.bootcamp.app.entity.Response;
import com.bolsadeideas.springboot.bootcamp.app.service.InterfaceOwnerService;
import com.bolsadeideas.springboot.bootcamp.app.utils.Constants;

@RestController
public class OwnerController {
	
	@Autowired
	private InterfaceOwnerService ownerService;
	
	@GetMapping("/owners")
	public List<Owner> findAll(){
		return ownerService.findAll();
	}
	
	@GetMapping("/owners/{id}")
	public ResponseEntity<Response<String>>  findByIdOwner(@PathVariable Long id) {
		Response response = new Response(Constants.ResponseConstants.SUCCESS, OWNER_FOUND, ownerService.findById(id));
		return  new ResponseEntity<>(response, HttpStatus.FOUND);
	}
	
	@PostMapping("/owners")
	public ResponseEntity<Response<String>> add(@RequestBody RequestDTO requestDto) {
		Response response = new Response(Constants.ResponseConstants.SUCCESS, OWNER_CREATED, ownerService.save(requestDto));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/owners")
	public ResponseEntity<Response<String>> updateOwner(@RequestBody RequestDTO requestDto) {
		Response response = new Response(Constants.ResponseConstants.SUCCESS, OWNER_UPDATED, ownerService.updateOwner(requestDto));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/owners/{id}")
	public ResponseEntity<Response<String>> deleteOwner(@PathVariable Long id) {
		Response response = new Response(Constants.ResponseConstants.SUCCESS, OWNER_DELETED,  ownerService.deleteOwner(id));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
