package com.bolsadeideas.springboot.bootcamp.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.bootcamp.app.dto.RequestDTO;
import com.bolsadeideas.springboot.bootcamp.app.entity.Animal;
import com.bolsadeideas.springboot.bootcamp.app.entity.Owner;
import com.bolsadeideas.springboot.bootcamp.app.entity.Response;
import com.bolsadeideas.springboot.bootcamp.app.service.InterfaceAnimalService;
import com.bolsadeideas.springboot.bootcamp.app.service.InterfaceOwnerService;
import com.bolsadeideas.springboot.bootcamp.app.utils.Constants;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.ANIMAL_CREATED;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.ANIMAL_FOUND;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.ANIMAL_UPDATED;
import static com.bolsadeideas.springboot.bootcamp.app.utils.Constants.ANIMAL_DELETED;

@RestController
public class AnimalController {

	@Autowired
	private InterfaceAnimalService animalService;
	
	@Autowired
	private InterfaceOwnerService ownerService;

	@GetMapping("/animals")
	public List<Animal> toList() {
		return animalService.findAll();
	}

	@GetMapping("/animals/{id}")
	public ResponseEntity<Response<String>> detailsAnimal(@PathVariable Long id) {
		Response responseAnimal = new Response(Constants.ResponseConstants.SUCCESS, ANIMAL_FOUND, animalService.findById(id));
		return new ResponseEntity<>(responseAnimal, HttpStatus.FOUND);
	}

	@PostMapping("/animals/{idOwner}")
	public ResponseEntity<Response<String>> addAnimal(@RequestBody Animal animal, @PathVariable Long idOwner) {
		RequestDTO owner= new RequestDTO(ownerService.findById(idOwner));
		owner.getOwner().addAnimal(animal);
		Response responseAnimal = new Response(Constants.ResponseConstants.SUCCESS, ANIMAL_CREATED, ownerService.save(owner));
		return new ResponseEntity<>(responseAnimal, HttpStatus.CREATED);
	}

	@PutMapping("/animals")
	public ResponseEntity<Response<String>> updateAnimal(@RequestBody Animal animal) {
		Response responseAnimal = new Response(Constants.ResponseConstants.SUCCESS, ANIMAL_UPDATED,animalService.update(animal));
		return new ResponseEntity<>(responseAnimal, HttpStatus.OK);
	}

	@DeleteMapping("animals/{id}")
	public ResponseEntity<Response<String>> deleteAnimal(@PathVariable Long id) {
		Response responseAnimal = new Response(Constants.ResponseConstants.SUCCESS, ANIMAL_DELETED,animalService.delete(id));
		return new ResponseEntity<>(responseAnimal, HttpStatus.OK);
	}
}
