package com.vetpatitas.veterinary.service.implementation;

import com.vetpatitas.veterinary.dao.OwnerDAO;
import com.vetpatitas.veterinary.dto.OwnerDTO;
import com.vetpatitas.veterinary.entity.Owner;
import com.vetpatitas.veterinary.exception.InvalidDataException;
import com.vetpatitas.veterinary.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import com.vetpatitas.veterinary.mapper.OwnerMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.vetpatitas.veterinary.utils.Constants.OWNER_INVALID_DATA;


@Service
public class OwnerServiceImplementation implements OwnerService {
    @Autowired
    private OwnerMapper ownerMapper;
    @Autowired
    private OwnerDAO ownerDAO;


    public void validOwner(OwnerDTO ownerDTO) {
        if (ownerDTO.getPhoneNumber().isEmpty() || ownerDTO.getEmail().isEmpty() || ownerDTO.getName().isEmpty()) {
            throw new InvalidDataException(OWNER_INVALID_DATA);
        }
    }

    @Override
    public OwnerDTO addOwner(OwnerDTO ownerDTO) {
        validOwner(ownerDTO);
        return ownerMapper.ownerEntityToDTO(ownerDAO.save(ownerMapper.ownerDTOToEntity(ownerDTO)));
    }

    @Override
    public OwnerDTO deleteOwner(OwnerDTO ownerDTO) {
        Optional<Owner> ownerDTOOptional = ownerDAO.findById(ownerDTO.getId());
        if (ownerDTOOptional.isPresent()) {
            ownerDAO.deleteById(ownerDTO.getId());
        } else {
            throw new InvalidDataException(OWNER_INVALID_DATA);
        }
        return ownerDTO;
    }

    @Override
    public OwnerDTO selectOwner(long id) {

        Optional<Owner> ownerDTOOptional = ownerDAO.findById(id);
        if (ownerDTOOptional.isPresent()) {
            return ownerMapper.ownerEntityToDTO(ownerDAO.getById(id));
        } else {
            throw new InvalidDataException(OWNER_INVALID_DATA);
        }

    }

    @Override
    public OwnerDTO editOwner(OwnerDTO ownerDTO) {

        Optional<Owner> ownerDTOOptional = ownerDAO.findById(ownerDTO.getId());
        if (ownerDTOOptional.isPresent()) {
            addOwner(ownerDTO);
        } else {
            throw new InvalidDataException(OWNER_INVALID_DATA);
        }
        return ownerDTO;
    }
}
