package com.globant.crudvetpet.repository;

import com.globant.crudvetpet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 06/09/21
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
