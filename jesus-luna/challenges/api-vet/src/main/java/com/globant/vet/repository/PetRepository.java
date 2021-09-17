package com.globant.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.vet.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer>{

}
