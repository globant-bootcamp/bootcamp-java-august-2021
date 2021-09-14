package com.bolsadeideas.springboot.bootcamp.app.service.implement;

import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.NO_FOUND_OWNER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.bootcamp.app.dao.OwnerDao;
import com.bolsadeideas.springboot.bootcamp.app.dto.RequestDTO;
import com.bolsadeideas.springboot.bootcamp.app.entity.Animal;
import com.bolsadeideas.springboot.bootcamp.app.entity.Owner;
import com.bolsadeideas.springboot.bootcamp.app.exception.AnimalNotFoundException;
import com.bolsadeideas.springboot.bootcamp.app.service.InterfaceOwnerService;

@Service
public class OwnerServiceImpl implements InterfaceOwnerService{

	@Autowired
	private OwnerDao ownerDao;
	
	@Override
	public List<Owner> findAll() {
		return (List<Owner>) ownerDao.findAll();
	}

	@Override
	public Owner save(RequestDTO requestDto) {
		return ownerDao.save(requestDto.getOwner());
	}

	@Override
	public Owner findById(Long id) {
		Owner owner = ownerDao.findById(id).orElse(null);
		if (owner == null) {
			throw new AnimalNotFoundException(NO_FOUND_OWNER);
		}
		return owner;
	}

	@Override
	public Owner deleteOwner(Long id) {
		Owner owner = findById(id);
		ownerDao.deleteById(id);
		return owner;
	}

	@Override
	public Owner updateOwner(RequestDTO requestDTO) {
		Owner ownerDataBase = findById(requestDTO.getOwner().getId());
		ownerDataBase.setName(requestDTO.getOwner().getName());
		ownerDataBase.setPhone(requestDTO.getOwner().getPhone());
		return ownerDataBase;
	}

}
