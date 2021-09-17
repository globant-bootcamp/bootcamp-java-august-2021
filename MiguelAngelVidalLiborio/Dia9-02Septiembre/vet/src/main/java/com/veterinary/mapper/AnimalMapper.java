package com.veterinary.mapper;

import org.springframework.stereotype.Component;

import com.veterinary.dto.AnimalDTO;
import com.veterinary.entity.Animal;

@Component
public class AnimalMapper {

	public Animal animalDTOToEntity(AnimalDTO animalDTO) {
		Animal animal = new Animal();
		animal.setId(animalDTO.getId());
		animal.setName(animalDTO.getName());
		animal.setType(animalDTO.getType());
		animal.setAge(animalDTO.getAge());

		return animal;
	}

	public AnimalDTO entityToAnimalDTO(Animal animal) {
		AnimalDTO animalDto = new AnimalDTO();
		animalDto.setId(animal.getId());
		animalDto.setName(animal.getName());
		animalDto.setAge(animal.getAge());
		animalDto.setType(animal.getType());

		return animalDto;
	}
}
