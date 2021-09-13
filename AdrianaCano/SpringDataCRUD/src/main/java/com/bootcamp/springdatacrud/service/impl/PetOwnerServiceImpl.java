package com.bootcamp.springdatacrud.service.impl;

import com.bootcamp.springdatacrud.dao.PetOwnerDAO;
import com.bootcamp.springdatacrud.dto.PetOwnerDTO;
import com.bootcamp.springdatacrud.entity.PetOwner;
import com.bootcamp.springdatacrud.exception.NotFoundException;
import com.bootcamp.springdatacrud.mapper.PetOwnerMapper;
import com.bootcamp.springdatacrud.service.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bootcamp.springdatacrud.utils.Constants.USER_DOES_NOT_EXIST;

@Service
public class PetOwnerServiceImpl implements PetOwnerService {

    @Autowired
    PetOwnerMapper petOwnerMapper;

    @Autowired
    PetOwnerDAO petOwnerDAO;

    @Override
    public List<PetOwner> showList() {
        return petOwnerDAO.findAll();
    }

    @Override
    public PetOwnerDTO addPetOwner(PetOwnerDTO petOwnerDTO) {
        return petOwnerMapper.petOwnerEntityToDTO(petOwnerDAO.save(petOwnerMapper.petOwnerDTOToEntity(petOwnerDTO)));
    }

    @Override
    public PetOwnerDTO getPetOwnerById(Long id_owner) {
        PetOwner petOwner = petOwnerDAO.findById(id_owner).orElse(null);

        if(petOwner == null){
            throw new NotFoundException(USER_DOES_NOT_EXIST);
        }
        PetOwnerDTO petOwnerDTO = petOwnerMapper.petOwnerEntityToDTO(petOwner);
        return petOwnerDTO;
    }

    @Override
    public void deletePetOwner(Long id_owner) {
        getPetOwnerById(id_owner);
        petOwnerDAO.deleteById(id_owner);
    }

    @Override
    public PetOwnerDTO updatePetOwner(Long id_owner, PetOwnerDTO petOwnerDTO) {
        getPetOwnerById(id_owner);
        return petOwnerMapper.petOwnerEntityToDTO(petOwnerDAO.save(petOwnerMapper.petOwnerDTOToEntity(petOwnerDTO)));
    }

}
