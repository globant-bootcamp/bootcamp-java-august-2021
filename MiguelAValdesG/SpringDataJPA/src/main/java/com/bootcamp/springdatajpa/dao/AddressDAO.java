package com.bootcamp.springdatajpa.dao;

import com.bootcamp.springdatajpa.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDAO extends JpaRepository<Address, Long> {

}
