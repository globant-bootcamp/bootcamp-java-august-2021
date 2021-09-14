package com.oswaldo.vetpatitas.dao;

import com.oswaldo.vetpatitas.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerDAO extends CrudRepository<Owner, Long> {
}
