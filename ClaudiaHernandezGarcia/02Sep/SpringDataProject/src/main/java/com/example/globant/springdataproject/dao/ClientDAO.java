package com.example.globant.springdataproject.dao;

import com.example.globant.springdataproject.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDAO extends JpaRepository<Client, Long> {
    Client findClientById(Long id);
    List<Client> findAll();
}
