package com.example.globant.springdataproject.dao;

import com.example.globant.springdataproject.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetDAO extends JpaRepository<Pet, Long> {
    Pet findPetById(Long id);
    List<Pet> findAll();
}
