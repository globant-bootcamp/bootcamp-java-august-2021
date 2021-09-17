package com.vetpatitas.veterinary.mapper;


import com.vetpatitas.veterinary.dto.AnimalDTO;
import com.vetpatitas.veterinary.entity.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {
    public Animal animalDTOToEntity(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal.setId(animalDTO.getId());
        animal.setName(animalDTO.getName());
        animal.setSpecies(animalDTO.getSpecies());
        return animal;
    }

    public AnimalDTO animalEntityToDTO(Animal animal) {
        AnimalDTO animalDTO = new AnimalDTO();
        animalDTO.setId(animal.getId());
        animalDTO.setName(animal.getName());
        animalDTO.setSpecies(animal.getSpecies());
        return animalDTO;
    }
}
