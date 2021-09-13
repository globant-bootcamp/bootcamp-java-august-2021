package com.globant.springdata.dao;

import com.globant.springdata.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerDao extends JpaRepository<Owner, Long> {
}
