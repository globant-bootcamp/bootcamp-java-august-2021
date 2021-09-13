package com.bootcamp.springdatacrud.dao;
import com.bootcamp.springdatacrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
}
