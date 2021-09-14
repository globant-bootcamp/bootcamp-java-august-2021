package com.veterinary.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veterinary.dto.AnimalDTO;
import com.veterinary.entity.Animal;
import com.veterinary.exception.ModelNotFoundException;
import com.veterinary.exception.EmptyInputException;
import com.veterinary.mapper.AnimalMapper;
import com.veterinary.repository.AnimalRepository;
import com.veterinary.service.AnimalService;
import com.veterinary.utils.Constants;

@Service
public class AnimalServiceImp implements AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private AnimalMapper animalMapper;

	@Override
	public AnimalDTO savePet(AnimalDTO clientsPet) {

		validationData(clientsPet);
		return animalMapper.entityToAnimalDTO(animalRepository.save(animalMapper.animalDTOToEntity(clientsPet)));

	}

	public void validationData(AnimalDTO clientsPet) {
		if (clientsPet.getName().isEmpty() || clientsPet.getAge() < 0 || clientsPet.getType().isEmpty()) {
			throw new EmptyInputException(Constants.INPUT_FROM_USER_NOT_VALID);
		}
	}

	@Override
	public List<Animal> getAllPets() {

		List<Animal> allAnimals = animalRepository.findAll();

		return allAnimals;
	}

	@Override
	public AnimalDTO getPetById(long petId) {
		long getIdPetFromUserInput = petId;
		Animal animalFromBd = animalRepository.findById(getIdPetFromUserInput)
				.orElseThrow(() -> new ModelNotFoundException(Constants.ENTITY_PET_NOT_FOUND));

		AnimalDTO animalDto = animalMapper.entityToAnimalDTO(animalFromBd);
		return animalDto;
	}

	@Override
	public AnimalDTO deletePetById(long petId) {
		AnimalDTO getPetIfExists = getPetById(petId);
		animalRepository.delete(animalMapper.animalDTOToEntity(getPetIfExists));
		return getPetIfExists;
	}

	@Override
	public AnimalDTO updatePet(AnimalDTO petData) {
		getPetById(petData.getId());
		AnimalDTO animalDto = animalMapper
				.entityToAnimalDTO(animalRepository.save(animalMapper.animalDTOToEntity(petData)));
		return animalDto;
	}

}
