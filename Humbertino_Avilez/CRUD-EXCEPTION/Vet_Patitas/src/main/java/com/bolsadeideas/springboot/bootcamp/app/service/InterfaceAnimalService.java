package com.bolsadeideas.springboot.bootcamp.app.service;

import java.util.List;

import com.bolsadeideas.springboot.bootcamp.app.entity.Animal;

public interface InterfaceAnimalService {
	public List<Animal> findAll() ;
	public Animal findById(Long id);
	public Animal save(Animal animal);
	public Animal update(Animal animal);
	public Animal delete(Long id);
}
