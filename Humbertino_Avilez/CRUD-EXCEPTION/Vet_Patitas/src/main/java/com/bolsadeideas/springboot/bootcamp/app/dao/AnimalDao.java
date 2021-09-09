package com.bolsadeideas.springboot.bootcamp.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.bootcamp.app.entity.Animal;

public interface AnimalDao extends CrudRepository<Animal, Long>{

}
