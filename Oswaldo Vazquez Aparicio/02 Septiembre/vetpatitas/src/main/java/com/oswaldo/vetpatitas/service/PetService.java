package com.oswaldo.vetpatitas.service;

import com.oswaldo.vetpatitas.dto.PetDTO;

import java.util.List;

public interface PetService {

    PetDTO add(PetDTO petDTO);
    PetDTO getById(Long id);
    List<PetDTO> getAll();
    PetDTO update(Long id, PetDTO petDTO);
    void delete(Long id);

}
