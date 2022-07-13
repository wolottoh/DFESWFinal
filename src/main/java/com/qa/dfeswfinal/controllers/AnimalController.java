package com.qa.dfeswfinal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfeswfinal.entities.Animal;
import com.qa.dfeswfinal.services.AnimalService;

@RestController
public class AnimalController {

	private AnimalService service;

	// Dependency injection
	public AnimalController(AnimalService service) {
		this.service = service;
	}

	// POST - CREATE
	@PostMapping("/create") // localhost:8080/customer/create
	public Animal create(@RequestBody Animal animal) {

		return this.service.create(animal);
	}

	// GET - READ
	@GetMapping("/readAll")
	public List<Animal> readAll() {
		return this.service.readAll();
	}

	// ReadByID
	@GetMapping("/readById/{id}")
	public Animal readById(@PathVariable Long id) {
		return this.service.readById(id);
	}

	// PUT - UPDATE
	@PutMapping("/update/{id}")
	public Animal update(@PathVariable Long id, @RequestBody Animal animal) {

		return this.service.update(id, animal);
	}

	// DELETE - DELETE
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return this.service.delete(id);

	}
}
