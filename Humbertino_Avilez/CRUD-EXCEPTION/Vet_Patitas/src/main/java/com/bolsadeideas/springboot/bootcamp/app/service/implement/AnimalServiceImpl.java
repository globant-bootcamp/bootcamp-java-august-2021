package com.bolsadeideas.springboot.bootcamp.app.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.bootcamp.app.dao.AnimalDao;
import com.bolsadeideas.springboot.bootcamp.app.entity.Animal;
import com.bolsadeideas.springboot.bootcamp.app.exception.AnimalNotFoundException;
import com.bolsadeideas.springboot.bootcamp.app.service.InterfaceAnimalService;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.NO_FOUND_ANIMAL;

@Service
public class AnimalServiceImpl implements InterfaceAnimalService {

	@Autowired
	private AnimalDao animalDao;

	@Override
	public List<Animal> findAll() {
		return (List<Animal>) animalDao.findAll();
	}

	@Override
	public Animal findById(Long id) {
		Animal animal = animalDao.findById(id).orElse(null);
		if (animal == null) {
			throw new AnimalNotFoundException(NO_FOUND_ANIMAL);
		}
		return animal;
	}

	@Override
	public Animal save(Animal animal) {
		return animalDao.save(animal);
	}

	@Override
	public Animal delete(Long id) {
		Animal animal = findById(id);
		animalDao.deleteById(id);
		return animal;
	}

	@Override
	public Animal update(Animal animalUpdate) {
		Animal animalDataBase = findById(animalUpdate.getId());
		animalDataBase.setName(animalUpdate.getName());
		animalDataBase.setAge(animalUpdate.getAge());
		animalDataBase.setType(animalUpdate.getType());
		save(animalDataBase);
		return animalDataBase;
	}

}
