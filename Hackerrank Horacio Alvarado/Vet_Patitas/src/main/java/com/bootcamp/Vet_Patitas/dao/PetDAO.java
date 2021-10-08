package com.bootcamp.Vet_Patitas.dao;

import com.bootcamp.Vet_Patitas.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetDAO extends JpaRepository<Pet, Long> {

    Optional<Pet> findByPetName(String petName);

    boolean existsByPetName(String petName);
}
