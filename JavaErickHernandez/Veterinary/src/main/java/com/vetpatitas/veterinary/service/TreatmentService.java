package com.vetpatitas.veterinary.service;

import com.vetpatitas.veterinary.dto.AnimalTreatmentDTO;



public interface TreatmentService {
    AnimalTreatmentDTO addTreatment(AnimalTreatmentDTO animalTreatmentDTO);
    AnimalTreatmentDTO deleteTreatment(AnimalTreatmentDTO animalTreatmentDTO);
    AnimalTreatmentDTO selectTreatment(long id);
    AnimalTreatmentDTO editTreatment(AnimalTreatmentDTO animalTreatmentDTO);
}
