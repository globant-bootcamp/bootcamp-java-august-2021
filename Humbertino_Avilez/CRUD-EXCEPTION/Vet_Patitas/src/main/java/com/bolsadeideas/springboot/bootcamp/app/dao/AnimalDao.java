package com.bolsadeideas.springboot.bootcamp.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bolsadeideas.springboot.bootcamp.app.entity.Animal;

public interface AnimalDao extends JpaRepository<Animal, Long>{

}
