package com.bootcamp.springdatajpa.dao;

import com.bootcamp.springdatajpa.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetDAO extends JpaRepository<Pet, Long> {

  @Query("SELECT pet FROM Pet pet WHERE pet.active = true")
  List<Pet> findAllActive();

  @Query("SELECT pet FROM Pet pet WHERE pet.owner.id IN :id")
  List<Pet> findAllOwnersPets(Long id);
}
