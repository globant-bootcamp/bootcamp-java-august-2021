package com.bootcamp.springdatacrud.dao;

import com.bootcamp.springdatacrud.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDAO extends JpaRepository<Pet, Long> {
}
