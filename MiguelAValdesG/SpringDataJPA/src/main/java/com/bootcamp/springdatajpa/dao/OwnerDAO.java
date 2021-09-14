package com.bootcamp.springdatajpa.dao;

import com.bootcamp.springdatajpa.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OwnerDAO extends JpaRepository<Owner, Long> {

  @Query("SELECT onwer FROM Owner onwer WHERE onwer.active = true")
  List<Owner> findAllActive();

  @Query(value = "SELECT owner FROM Owner owner WHERE owner.address.id IN :id")
  Optional<Owner> findByIdAddress(Long id);

}
