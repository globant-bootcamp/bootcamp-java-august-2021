package com.bootcamp.crud.dao;

import com.bootcamp.crud.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDAO extends JpaRepository<Pet, Long> {

}
