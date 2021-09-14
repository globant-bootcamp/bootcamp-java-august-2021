package com.veterinary.service;

import java.util.List;

import com.veterinary.dto.AnimalDTO;
import com.veterinary.entity.Animal;

public interface AnimalService {

	AnimalDTO savePet(AnimalDTO clientsPet);

	List<Animal> getAllPets();

	AnimalDTO getPetById(long petId);

	AnimalDTO deletePetById(long petId);

	AnimalDTO updatePet(AnimalDTO petData);
}
