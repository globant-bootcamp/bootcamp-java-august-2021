package com.vetpatitas.veterinary.dao;


import com.vetpatitas.veterinary.entity.AnimalTreatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalTreatmentDAO extends JpaRepository<AnimalTreatment, Long> {
}
