package com.veterinary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinary.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
