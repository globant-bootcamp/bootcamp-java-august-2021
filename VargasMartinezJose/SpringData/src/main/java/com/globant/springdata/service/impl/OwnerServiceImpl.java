package com.globant.springdata.service.impl;

import com.globant.springdata.dao.OwnerDao;
import com.globant.springdata.dto.RequestDTO;
import com.globant.springdata.entity.Owner;
import com.globant.springdata.service.InterfaceOwnerService;
import org.springframework.beans.factory.annotation.Autowired;

import static com.globant.springdata.utils.Constants.USER_WAS_NOT_FOUND;

public class OwnerServiceImpl implements InterfaceOwnerService {
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
            throw new AnimalNotFoundException(USER_WAS_NOT_FOUND);
        }
        return owner;
    }

    @Override
    public Owner deleteOwner(Long id) {
        Owner owner = findById(id);
        ownerDao.deleteById(id);
        return owner;
    }
}
