package com.vetpatitas.veterinary.service.implementation;


import com.vetpatitas.veterinary.dao.AnimalDAO;
import com.vetpatitas.veterinary.dto.AnimalDTO;
import com.vetpatitas.veterinary.entity.Animal;
import com.vetpatitas.veterinary.exception.InvalidDataException;
import com.vetpatitas.veterinary.mapper.AnimalMapper;
import com.vetpatitas.veterinary.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.vetpatitas.veterinary.utils.Constants.ANIMAL_INVALID_DATA;


@Service
public class AnimalServiceImplementation implements AnimalService {
    @Autowired
    private AnimalMapper animalMapper;
    @Autowired
    private AnimalDAO animalDAO;

    public void validAnimal(AnimalDTO animalDTO) {
        if (animalDTO.getName().isEmpty() || animalDTO.getSpecies().isEmpty()) {
            throw new InvalidDataException(ANIMAL_INVALID_DATA);
        }
    }

    @Override
    public AnimalDTO addAnimal(AnimalDTO animalDTO) {
        validAnimal(animalDTO);
        return animalMapper.animalEntityToDTO(animalDAO.save(animalMapper.animalDTOToEntity(animalDTO)));
    }


    @Override
    public AnimalDTO deleteAnimal(long id) {
        if (animalDAO.existsById(id)) {
            animalDAO.delete(animalDAO.getById(id));
        } else {
            throw new InvalidDataException(ANIMAL_INVALID_DATA);
        }
        return animalMapper.animalEntityToDTO(animalDAO.getById(id));
    }

    @Override
    public AnimalDTO selectAnimal(long id) {
        Optional<Animal> animalDTOOptional = animalDAO.findById(id);
        if (animalDTOOptional.isPresent()) {
            return animalMapper.animalEntityToDTO(animalDAO.getById(id));
        } else {
            throw new InvalidDataException(ANIMAL_INVALID_DATA);
        }
    }

    @Override
    public AnimalDTO editAnimal(AnimalDTO animalDTO) {
        Optional<Animal> animalDTOOptional = animalDAO.findById(animalDTO.getId());
        if (animalDTOOptional.isPresent()) {
            addAnimal(animalDTO);
        } else {
            throw new InvalidDataException(ANIMAL_INVALID_DATA);
        }
        return animalDTO;
    }
}

