package com.bootcamp.crud.service.impl;

import com.bootcamp.crud.dao.OwnerDAO;
import com.bootcamp.crud.dto.OwnerDTO;
import com.bootcamp.crud.entity.Owner;
import com.bootcamp.crud.mapper.OwnerMapper;
import com.bootcamp.crud.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    OwnerMapper ownerMapper;

    @Autowired
    OwnerDAO ownerDAO;


    @Override
    public OwnerDTO addOwner(OwnerDTO ownerDTO) {

        return ownerMapper.ownerEntityToDTO(ownerDAO.save(ownerMapper.ownerDTOToEntity(ownerDTO)));
    }

    @Override
    public OwnerDTO updateOwner(OwnerDTO ownerDTO, Long id){
        return ownerMapper.ownerEntityToDTO(ownerDAO.save(setOwnerUpdate(findOwnerById(id), ownerDTO)));
    }

    @Override
    public OwnerDTO deleteOwner( Long id) {
        Owner owner = findOwnerById(id);
        owner.setIsActive(false);
        return ownerMapper.ownerEntityToDTO(ownerDAO.save(owner));
    }


    public Owner findOwnerById(Long id){
        Optional<Owner> optionalOwner = ownerDAO.findById(id);
        Owner owner = new Owner();

        if (optionalOwner.isPresent()) {
            owner = optionalOwner.get();

        }
        return owner;
    }

    public Owner setOwnerUpdate(Owner owner, OwnerDTO ownerDTO) {
        owner.setFirstName(ownerDTO.getFirstName());
        owner.setLastName(ownerDTO.getLastName());
        owner.setEmail(ownerDTO.getEmail());
        owner.setPhone(ownerDTO.getPhone());
        owner.setIsActive(ownerDTO.getIsActive());
        return owner;
    }
}
