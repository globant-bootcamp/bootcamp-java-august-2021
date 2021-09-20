package com.globant.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.vet.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
