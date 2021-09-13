package com.bolsadeideas.springboot.bootcamp.app.service;

import java.util.List;

import com.bolsadeideas.springboot.bootcamp.app.dto.RequestDTO;
import com.bolsadeideas.springboot.bootcamp.app.entity.Owner;

public interface InterfaceOwnerService {
	public List<Owner> findAll() ;
	
	public Owner save(RequestDTO requestDTO);
	
	public Owner findById(Long id);
	
	public Owner deleteOwner(Long id);
	
	public Owner updateOwner(RequestDTO requestDTO);
}
