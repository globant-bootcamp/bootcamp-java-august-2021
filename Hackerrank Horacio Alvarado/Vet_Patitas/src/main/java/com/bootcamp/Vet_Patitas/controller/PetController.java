package com.bootcamp.Vet_Patitas.controller;

import com.bootcamp.Vet_Patitas.dto.PetDTO;
import com.bootcamp.Vet_Patitas.entity.Pet;
import com.bootcamp.Vet_Patitas.service.PetService;
import com.bootcamp.Vet_Patitas.utils.Constants;
import com.bootcamp.Vet_Patitas.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping("/pet-list")
    public ResponseEntity<List<Pet>> petList(){

        List<Pet> pets = petService.petList();
        return new ResponseEntity<List<Pet>>(pets, HttpStatus.OK);
    }

    @GetMapping("/pet-detail/{petId}")
    public ResponseEntity<Pet> petById(@PathVariable("petId") Long petId){

        if (!petService.existsByPetId(petId))
            return new ResponseEntity(new Messages(Constants.PET_NOT_IN_DB), HttpStatus.NOT_FOUND);

        Pet pet = petService.getPet(petId).get();
        return new ResponseEntity(pet, HttpStatus.OK);
    }

    @GetMapping("/petName-detail/{petName}")
    public ResponseEntity<Pet> petByName(@PathVariable("petName") String petName){

        if (!petService.existsByPetName(petName))
            return new ResponseEntity(new Messages(Constants.PET_NOT_IN_DB), HttpStatus.NOT_FOUND);

        Pet pet = petService.getByPetName(petName).get();
        return new ResponseEntity(pet, HttpStatus.OK);
    }

    @PostMapping("/register-pet")
    public ResponseEntity<?> registerPet(@RequestBody PetDTO petDTO){


        if(petService.existsByPetName(petDTO.getPetName()))
            return new ResponseEntity(new Messages(Constants.PET_ALREADY_IN_DB), HttpStatus.BAD_REQUEST);

        Pet pet = new Pet(petDTO.getPetName(),petDTO.getRace(),petDTO.getWeight(),petDTO.getOwner(),petDTO.getPhoneNumber());
        petService.savePet(pet);
        return new ResponseEntity(new Messages(Constants.PET_REGISTERED), HttpStatus.OK);
    }

    @PutMapping("/update-pet/{petId}")
    public ResponseEntity<?> updatePet(@PathVariable("id") Long id, @RequestBody PetDTO petDTO){

        if (!petService.existsByPetId(id))
            return new ResponseEntity(new Messages(Constants.PET_NOT_IN_DB), HttpStatus.NOT_FOUND);

        if (petService.existsByPetName(petDTO.getPetName())
                && petService.getByPetName(petDTO.getPetName()).get().getPetId() != id)
            return new ResponseEntity(new Messages(Constants.PET_ALREADY_IN_DB), HttpStatus.NOT_FOUND);

        //To do: set all other pet parameters
        Pet pet = petService.getPet(id).get();
        pet.setName(petDTO.getPetName());
        petService.savePet(pet);
        return new ResponseEntity(new Messages(Constants.PET_UPDATED), HttpStatus.OK);
    }

    @DeleteMapping("/delete-pet/{petId}")
    public ResponseEntity<?> deletePet(@PathVariable("petId") Long id){
        if (!petService.existsByPetId(id))
            return new ResponseEntity(new Messages(Constants.PET_NOT_IN_DB), HttpStatus.NOT_FOUND);
        petService.deletePet(id);
        return new ResponseEntity(new Messages(Constants.PET_DELETED), HttpStatus.OK);
    }

}
