package com.example.vetpatitas.dao;

import com.example.vetpatitas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Long> {

}
