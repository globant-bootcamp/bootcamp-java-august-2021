package com.example.vetcrud.dao;

import com.example.vetcrud.entity.Owner;
import com.example.vetcrud.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetDAO extends JpaRepository<Pet, Long> {

    @Query(value = "SELECT p FROM Pet p where p.owner = ?1")
    List<Pet> getPetsByOwner(Owner owner);
}
