package com.bolsadeideas.springboot.bootcamp.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bolsadeideas.springboot.bootcamp.app.entity.Owner;

public interface OwnerDao extends JpaRepository<Owner, Long>{

}
