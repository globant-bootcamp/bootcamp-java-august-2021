package com.bootcamp.crud.dao;

import com.bootcamp.crud.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerDAO extends JpaRepository<Owner, Long> {

}
