package com.oswaldo.vetpatitas.service.impl;

import com.oswaldo.vetpatitas.dao.OwnerDAO;
import com.oswaldo.vetpatitas.dao.PetDAO;
import com.oswaldo.vetpatitas.dto.OwnerDTO;
import com.oswaldo.vetpatitas.dto.PetDTO;
import com.oswaldo.vetpatitas.entity.Owner;
import com.oswaldo.vetpatitas.entity.Pet;
import com.oswaldo.vetpatitas.exception.RecordAlreadyExistsException;
import com.oswaldo.vetpatitas.exception.RecordNotFoundException;
import com.oswaldo.vetpatitas.mapper.OwnerMapper;
import com.oswaldo.vetpatitas.mapper.PetMapper;
import com.oswaldo.vetpatitas.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.oswaldo.vetpatitas.util.Constants.OWNER_ALREADY_EXISTS;
import static com.oswaldo.vetpatitas.util.Constants.OWNER_NOT_FOUND;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerDAO ownerDAO;
    @Autowired
    private PetDAO petDAO;

    @Autowired
    private OwnerMapper ownerMapper;
    @Autowired
    private PetMapper petMapper;

    @Override
    public OwnerDTO add(OwnerDTO ownerDTO) {
        Optional<Owner> optionalOwner;
        if (ownerDTO.getId() != null){
            optionalOwner = ownerDAO.findById(ownerDTO.getId());
            if (optionalOwner.isPresent()){
                throw new RecordAlreadyExistsException(OWNER_ALREADY_EXISTS);
            }else{
                return saveOwnerDTO(ownerDTO);
            }
        }else{
            return saveOwnerDTO(ownerDTO);
        }
    }

    private OwnerDTO saveOwnerDTO(OwnerDTO ownerDTO){
        return ownerMapper.ownerEntityToOwnerDTO(ownerDAO.save(ownerMapper.ownerDTOToEntity(ownerDTO)));
    }

    @Override
    public OwnerDTO getById(Long id) {
        Optional<Owner> optionalOwner =  ownerDAO.findById(id);
        return optionalOwner.map(owner -> ownerMapper.ownerEntityToOwnerDTO(owner)).orElse(null);
    }

    @Override
    public List<OwnerDTO> getAll() {
        List<OwnerDTO> ownerDTOList = new LinkedList<>();
        ownerDAO.findAll().forEach(owner -> {
            OwnerDTO ownerDTO = ownerMapper.ownerEntityToOwnerDTO(owner);
            ownerDTOList.add(ownerDTO);
        });
        return ownerDTOList;
    }

    @Override
    public OwnerDTO updateOwnerData(Long id, OwnerDTO ownerDTO) {
        Optional<Owner> ownerOptional = ownerDAO.findById(id);
        if (ownerOptional.isPresent()){
            ownerDTO.setId(id);
            Owner owner = ownerMapper.ownerDTOToEntity(ownerDTO);
            owner.setPetList(ownerOptional.get().getPetList());
            return ownerMapper.ownerEntityToOwnerDTO(ownerDAO.save(owner));
        }else{
            throw new RecordNotFoundException(OWNER_NOT_FOUND);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Owner> ownerOptional = ownerDAO.findById(id);
        if (ownerOptional.isPresent()){
            ownerDAO.delete(ownerOptional.get());
        }else {
            throw new RecordNotFoundException(OWNER_NOT_FOUND);
        }
    }

    @Override
    public OwnerDTO assignPetToOwner(Long ownerId, PetDTO petDTO) {
        Optional<Owner> ownerOptional = ownerDAO.findById(ownerId);
        if (ownerOptional.isPresent()){
            Owner owner = ownerOptional.get();
            Pet pet = petDAO.save(petMapper.petDTOToEntity(petDTO));
            owner.getPetList().add(pet);
            return ownerMapper.ownerEntityToOwnerDTO(ownerDAO.save(owner));
        } else {
            throw new RecordNotFoundException(OWNER_NOT_FOUND);
        }
    }

}
