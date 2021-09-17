package com.bootcamp.springdatacrud.dao;

import com.bootcamp.springdatacrud.entity.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOwnerDAO extends JpaRepository<PetOwner, Long> {
}
