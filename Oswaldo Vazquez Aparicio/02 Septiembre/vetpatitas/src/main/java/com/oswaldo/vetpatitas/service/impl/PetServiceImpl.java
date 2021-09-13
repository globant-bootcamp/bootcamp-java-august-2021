package com.oswaldo.vetpatitas.service.impl;

import com.oswaldo.vetpatitas.dao.PetDAO;
import com.oswaldo.vetpatitas.dto.PetDTO;
import com.oswaldo.vetpatitas.entity.Pet;
import com.oswaldo.vetpatitas.exception.RecordAlreadyExistsException;
import com.oswaldo.vetpatitas.exception.RecordNotFoundException;
import com.oswaldo.vetpatitas.mapper.PetMapper;
import com.oswaldo.vetpatitas.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.oswaldo.vetpatitas.util.Constants.PET_ALREADY_EXISTS;
import static com.oswaldo.vetpatitas.util.Constants.PET_NOT_FOUND;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetDAO petDAO;

    @Autowired
    private PetMapper petMapper;

    @Override
    public PetDTO add(PetDTO petDTO) {
        Optional<Pet> optionalPet;
        if (petDTO.getId() != null){
            optionalPet = petDAO.findById(petDTO.getId());
            if (optionalPet.isPresent()){
                throw new RecordAlreadyExistsException(PET_ALREADY_EXISTS);
            }else{
                return savePetDTO(petDTO);
            }
        }else{
            return savePetDTO(petDTO);
        }
    }

    private PetDTO savePetDTO(PetDTO petDTO){
        return petMapper.petEntityToPetDTO(petDAO.save(petMapper.petDTOToEntity(petDTO)));
    }

    @Override
    public PetDTO getById(Long id) {
        Optional<Pet> optionalPet = petDAO.findById(id);
        return optionalPet.map(pet -> petMapper.petEntityToPetDTO(pet)).orElse(null);
    }

    @Override
    public List<PetDTO> getAll() {
        List<PetDTO> petDTOList = new LinkedList<>();
        petDAO.findAll().forEach(pet -> {
            PetDTO petDTO = petMapper.petEntityToPetDTO(pet);
            petDTOList.add(petDTO);
        });
        return petDTOList;
    }

    @Override
    public PetDTO update(Long id, PetDTO petDTO) {
        Optional<Pet> optionalPet = petDAO.findById(id);
        if (optionalPet.isPresent()) {
            petDTO.setId(id);
            return petMapper.petEntityToPetDTO(petDAO.save(petMapper.petDTOToEntity(petDTO)));
        } else {
            throw new RecordNotFoundException(PET_NOT_FOUND);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Pet> optionalPet = petDAO.findById(id);
        if (optionalPet.isPresent()) {
            petDAO.delete(optionalPet.get());
        } else {
            throw new RecordNotFoundException(PET_NOT_FOUND);
        }
    }
}
