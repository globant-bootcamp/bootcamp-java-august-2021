package com.bootcamp.vetPatitas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.vetPatitas.dao.PetDAO;
import com.bootcamp.vetPatitas.dto.PetDTO;
import com.bootcamp.vetPatitas.entity.Pet;
import com.bootcamp.vetPatitas.mapper.PetMapper;

@Service
public class PetServiceImp implements PetService{

	@Autowired
	PetMapper petMapper;
	
	@Autowired
	PetDAO petDao;
	
	@Override
	public PetDTO addPet(PetDTO petDTO) {
		
		petDTO.setStatus(true);		
		return petMapper.EntityToUserDTO(petDao.save(petMapper.PetDTOToEntity(petDTO)));
	}

	@Override
	public PetDTO updatePet(PetDTO petDTO) {
		
		return petMapper.EntityToUserDTO(petDao.save(petDao.getById(petDTO.getId())));				 
	}

	public PetDTO getPet(Long petId) {

		return petMapper.EntityToUserDTO(petDao.getById(petId));
	}

	@Override
	public PetDTO deletePet(PetDTO petDTO) {

		PetDTO petToBeDesabled = new PetDTO();
		petToBeDesabled =  petMapper.EntityToUserDTO(petDao.getById(petDTO.getId()));
		petToBeDesabled.setStatus(false);
		return petMapper.EntityToUserDTO(petDao.save(petMapper.PetDTOToEntity(petToBeDesabled)));
	}

}
