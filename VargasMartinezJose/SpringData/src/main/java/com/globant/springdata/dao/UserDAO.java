package com.globant.springdata.dao;

import com.globant.springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Long>{
}
