package com.vetpatitas.veterinary.dao;

import com.vetpatitas.veterinary.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerDAO extends JpaRepository<Owner, Long> {
}
