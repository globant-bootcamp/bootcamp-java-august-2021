package com.bootcamp.vetpatitas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.vetPatitas.entity.Pet;

public interface PetDAO extends JpaRepository<Pet, Long>{

}
