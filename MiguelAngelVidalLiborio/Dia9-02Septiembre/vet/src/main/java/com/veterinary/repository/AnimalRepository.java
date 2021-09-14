package com.veterinary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.veterinary.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
