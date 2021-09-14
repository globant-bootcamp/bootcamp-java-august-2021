package com.bootcamp.vetpatitas.service;

import static com.bootcamp.vetpatitas.utils.Constants.PET_INVALID_PHONE;
import static com.bootcamp.vetpatitas.utils.Constants.PET_NULL_NAME;
import static com.bootcamp.vetpatitas.utils.Constants.PET_NULL_TYPE;
import static com.bootcamp.vetpatitas.utils.Constants.PET_NULL_AGE;
import static com.bootcamp.vetpatitas.utils.Constants.PET_NULL_OWNER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.vetpatitas.dao.PetDAO;
import com.bootcamp.vetpatitas.dto.PetDTO;
import com.bootcamp.vetpatitas.exception.InvalidDataException;
import com.bootcamp.vetpatitas.mapper.PetMapper;


@Service
public class PetServiceImp implements PetService{

	@Autowired
	PetMapper petMapper;
	
	@Autowired
	PetDAO petDao;
	
	@Override
	public PetDTO addPet(PetDTO petDTO) {
		
		if(petDTO.getPhoneNumber().length() != 10) {			
			throw new InvalidDataException(PET_INVALID_PHONE);
		}
		
		if(petDTO.getName() == null) {
			throw new InvalidDataException(PET_NULL_NAME);
		}
		
		if(petDTO.getType() == null) {
			throw new InvalidDataException(PET_NULL_TYPE);
		}
		
		if(petDTO.getAge() == null) {
			throw new InvalidDataException(PET_NULL_AGE);
		}
		
		if(petDTO.getOwner() == null) {
			throw new InvalidDataException(PET_NULL_OWNER);
		}
			
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
