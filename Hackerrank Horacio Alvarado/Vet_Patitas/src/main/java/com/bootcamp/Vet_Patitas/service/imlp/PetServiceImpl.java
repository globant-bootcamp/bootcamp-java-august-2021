package com.bootcamp.Vet_Patitas.service.imlp;

import com.bootcamp.Vet_Patitas.dao.PetDAO;
import com.bootcamp.Vet_Patitas.dto.PetDTO;
import com.bootcamp.Vet_Patitas.entity.Pet;
import com.bootcamp.Vet_Patitas.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PetServiceImpl implements PetService {

    @Autowired
    PetDAO petDAO;

    @Override
    public List<Pet> petList(){
        return  petDAO.findAll();
    }
    @Override
    public Optional<Pet> getPet(Long petId){
        return  petDAO.findById(petId);
    }
    @Override
    public Optional<Pet> getByPetName(String petName){
        return petDAO.findByPetName(petName);
    }
    @Override
    public void savePet(Pet pet){
        petDAO.save(pet);
    }
    @Override
    public void deletePet(Long petId){
        petDAO.deleteById(petId);
    }
    @Override
    public boolean existsByPetId(Long petId){
        return petDAO.existsById(petId);
    }
    @Override
    public boolean existsByPetName(String petName){
        return petDAO.existsByPetName(petName);
    }

    @Override
    public PetDTO isDischarged(PetDTO petDTO) {
        return null;
    }
}
