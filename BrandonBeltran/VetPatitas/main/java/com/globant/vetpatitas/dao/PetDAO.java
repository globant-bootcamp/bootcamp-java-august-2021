package com.globant.vetpatitas.dao;

import com.globant.vetpatitas.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PetDAO extends JpaRepository<Pet, Long> {

    @Query("SELECT pet FROM Pet pet WHERE pet.id IN :id")
    Pet getPetById(Long id);
}