package com.vetpatitas.veterinary.mapper;

import com.vetpatitas.veterinary.dto.AnimalTreatmentDTO;
import com.vetpatitas.veterinary.entity.AnimalTreatment;
import org.springframework.stereotype.Component;

@Component
public class AnimalTreatmentMapper {
    public AnimalTreatment animalTreatmentDTOToEntity(AnimalTreatmentDTO animalTreatmentDTO) {
        AnimalTreatment animalTreatment = new AnimalTreatment();
        animalTreatment.setId(animalTreatmentDTO.getId());
        animalTreatment.setPetId(animalTreatmentDTO.getPetId());
        animalTreatment.setMedicine(animalTreatmentDTO.getMedicine());
        animalTreatment.setDateIn(animalTreatmentDTO.getDateIn());
        animalTreatment.setDateOut(animalTreatmentDTO.getDateOut());
        animalTreatment.setOwner(animalTreatmentDTO.getOwner());
        return animalTreatment;
    }

    public AnimalTreatmentDTO animalTreatmentEntityToDTO(AnimalTreatment animalTreatment) {
        AnimalTreatmentDTO animalTreatmentDTO = new AnimalTreatmentDTO();
        animalTreatmentDTO.setId(animalTreatment.getId());
        animalTreatmentDTO.setPetId(animalTreatment.getPetId());
        animalTreatmentDTO.setMedicine(animalTreatment.getMedicine());
        animalTreatmentDTO.setDateIn(animalTreatment.getDateIn());
        animalTreatmentDTO.setDateOut(animalTreatment.getDateOut());
        animalTreatmentDTO.setOwner(animalTreatment.getOwner());
        return animalTreatmentDTO;
    }
}
