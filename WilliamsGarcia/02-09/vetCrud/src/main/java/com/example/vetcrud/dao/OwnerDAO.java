package com.example.vetcrud.dao;

import com.example.vetcrud.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerDAO extends JpaRepository<Owner, Long> {
}
