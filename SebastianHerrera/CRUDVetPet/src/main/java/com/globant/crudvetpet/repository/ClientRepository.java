package com.globant.crudvetpet.repository;

import com.globant.crudvetpet.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sebastian Herrera (bermeosebas@gmail.com)
 * @created 08/09/21
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
