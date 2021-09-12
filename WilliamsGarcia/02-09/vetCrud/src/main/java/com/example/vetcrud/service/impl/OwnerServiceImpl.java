package com.example.vetcrud.service.impl;

import com.example.vetcrud.dao.OwnerDAO;
import com.example.vetcrud.dto.OwnerDTO;
import com.example.vetcrud.entity.Owner;
import com.example.vetcrud.exception.EmptyListException;
import com.example.vetcrud.exception.NotFoundException;
import com.example.vetcrud.mapper.OwnerMapper;
import com.example.vetcrud.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.vetcrud.utils.Constants.EMPTY_OWNER_LIST;
import static com.example.vetcrud.utils.Constants.NOT_FOUND_OWNER;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerDAO ownerDAO;

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public List<OwnerDTO> getAllOwners() {
        if (!ownerDAO.findAll().isEmpty()) {
            return ownerMapper.ownerListToDTO(ownerDAO.findAll());
        } else {
            throw new EmptyListException(EMPTY_OWNER_LIST);
        }
    }

    @Override
    public OwnerDTO createOwner(OwnerDTO ownerDTO) {
        return ownerMapper.ownerToDTO(ownerDAO.save(ownerMapper.ownerDTOToOwner(ownerDTO)));
    }

    @Override
    public OwnerDTO updateOwner(OwnerDTO ownerDTO, long id) {

        if (ownerDAO.existsById(id)) {
            ownerDTO.setId(id);
            return ownerMapper.ownerToDTO(ownerDAO.save(ownerMapper.ownerDTOToOwner(ownerDTO)));
        } else {
            throw new NotFoundException(NOT_FOUND_OWNER);
        }
    }

    @Override
    public OwnerDTO getOwnerById(long id) {

        if (ownerDAO.existsById(id)) {
            return ownerMapper.ownerToDTO(ownerDAO.getById(id));
        } else {
            throw new NotFoundException(NOT_FOUND_OWNER);
        }
    }

    @Override
    public OwnerDTO deleteOwner(long id) {

        if (ownerDAO.existsById(id)) {
            ownerDAO.delete(ownerDAO.getById(id));
            return null;
        } else {
            throw new NotFoundException(NOT_FOUND_OWNER);
        }
    }
}