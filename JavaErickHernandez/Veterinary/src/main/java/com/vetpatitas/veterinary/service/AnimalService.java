package com.vetpatitas.veterinary.service;

import com.vetpatitas.veterinary.dto.AnimalDTO;

public interface AnimalService {
    AnimalDTO addAnimal(AnimalDTO animalDTO);
    AnimalDTO deleteAnimal(long id);
    AnimalDTO selectAnimal(long id);
    AnimalDTO editAnimal(AnimalDTO animalDTO);
}
