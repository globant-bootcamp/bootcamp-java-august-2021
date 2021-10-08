package com.vetpatitas.veterinary.service.implementation;

import com.vetpatitas.veterinary.dao.AnimalTreatmentDAO;
import com.vetpatitas.veterinary.dto.AnimalTreatmentDTO;
import com.vetpatitas.veterinary.entity.AnimalTreatment;
import com.vetpatitas.veterinary.exception.InvalidDataException;
import com.vetpatitas.veterinary.mapper.AnimalTreatmentMapper;
import com.vetpatitas.veterinary.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.vetpatitas.veterinary.utils.Constants.TREATMENT_INVALID_DATA;

@Service
public class TreatmentServiceImplementation implements TreatmentService {
    @Autowired
    private AnimalTreatmentDAO animalTreatmentDAO;
    @Autowired
    private AnimalTreatmentMapper animalTreatmentMapper;

    public void validTreatment(AnimalTreatmentDTO animalTreatmentDTO) {
        if (animalTreatmentDTO.getMedicine().isEmpty() || animalTreatmentDTO.getDateIn().isEmpty()) {
            throw new InvalidDataException(TREATMENT_INVALID_DATA);
        }
    }

    @Override
    public AnimalTreatmentDTO addTreatment(AnimalTreatmentDTO animalTreatmentDTO) {
        validTreatment(animalTreatmentDTO);
        return animalTreatmentMapper.animalTreatmentEntityToDTO(animalTreatmentDAO.save(animalTreatmentMapper.animalTreatmentDTOToEntity(animalTreatmentDTO)));
    }

    @Override
    public AnimalTreatmentDTO deleteTreatment(AnimalTreatmentDTO animalTreatmentDTO) {
        Optional<AnimalTreatment> animalTreatmentDTOOptional = animalTreatmentDAO.findById(animalTreatmentDTO.getId());
        if (animalTreatmentDTOOptional.isPresent()) {
            animalTreatmentDAO.deleteById(animalTreatmentDTO.getId());
        } else {
            throw new InvalidDataException(TREATMENT_INVALID_DATA);
        }
        return animalTreatmentDTO;
    }

    @Override
    public AnimalTreatmentDTO selectTreatment(long id) {
        Optional<AnimalTreatment> animalTreatmentDTOOptional = animalTreatmentDAO.findById(id);
        if (animalTreatmentDTOOptional.isPresent()) {
            return animalTreatmentMapper.animalTreatmentEntityToDTO(animalTreatmentDAO.getById(id));
        } else {
            throw new InvalidDataException(TREATMENT_INVALID_DATA);
        }

    }

    @Override
    public AnimalTreatmentDTO editTreatment(AnimalTreatmentDTO animalTreatmentDTO) {
        Optional<AnimalTreatment> animalTreatmentDTOOptional = animalTreatmentDAO.findById(animalTreatmentDTO.getId());
        if (animalTreatmentDTOOptional.isPresent()) {
            addTreatment(animalTreatmentDTO);
        } else {
            throw new InvalidDataException(TREATMENT_INVALID_DATA);
        }
        return animalTreatmentDTO;
    }
}
