package com.veterinary.controller;

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

import com.veterinary.dto.AnimalDTO;
import com.veterinary.dto.ResponseDTO;
import com.veterinary.entity.Animal;
import com.veterinary.service.AnimalService;
import com.veterinary.utils.Constants;

@RestController
@RequestMapping("/api/vet/pets")
public class AnimalController {

	@Autowired
	private AnimalService vetService;

	@GetMapping("/")
	public ResponseEntity<ResponseDTO<Animal>> getAllPets() {
		ResponseDTO<Animal> response = new ResponseDTO<Animal>(Constants.ENTITY_GET_REQUEST, vetService.getAllPets());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO<AnimalDTO>> getPet(@PathVariable("id") long petId) {
		ResponseDTO<AnimalDTO> response = new ResponseDTO<AnimalDTO>(Constants.ENTITY_GET_REQUEST,
				vetService.getPetById(petId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<ResponseDTO<AnimalDTO>> updatePet(@RequestBody AnimalDTO animal) {
		ResponseDTO<AnimalDTO> response = new ResponseDTO<AnimalDTO>(Constants.ENTITY_UPDATED,
				vetService.updatePet(animal));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO<AnimalDTO>> deletePet(@PathVariable("id") long petId) {
		ResponseDTO<AnimalDTO> response = new ResponseDTO<AnimalDTO>(Constants.ENTITY_DELETED,
				vetService.deletePetById(petId));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDTO<AnimalDTO>> savePet(@RequestBody AnimalDTO clientsPet) {
		ResponseDTO<AnimalDTO> response = new ResponseDTO<AnimalDTO>(Constants.ENTITY_CREATED,
				vetService.savePet(clientsPet));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
