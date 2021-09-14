package com.oswaldo.vetpatitas.dao;

import com.oswaldo.vetpatitas.entity.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetDAO extends CrudRepository<Pet, Long> {
}
