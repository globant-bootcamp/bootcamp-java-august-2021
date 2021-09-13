package com.globant.springdata.service;

import com.globant.springdata.dto.RequestDTO;
import com.globant.springdata.entity.Owner;
import org.hibernate.mapping.List;

public interface InterfaceOwnerService {
    List<Owner> findAll() ;

    Owner save(RequestDTO requestDTO);

    Owner deleteOwner(Long id);
}
