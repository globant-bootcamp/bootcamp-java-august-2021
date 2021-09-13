package com.vetpatitas.veterinary.dao;


import com.vetpatitas.veterinary.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalDAO extends JpaRepository<Animal, Long> {
}
