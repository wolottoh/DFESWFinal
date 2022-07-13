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

@RestController
public class AnimalController {

	// TEMPORARY storage, until we implement the real database later!

	private List<Animal> animals = new ArrayList<>();

//    @GetMapping("/test")
//    public String test() {
//        return "Hello, World!";
//}

	// POST - CREATE
	@PostMapping("/create") // localhost:8080/customer/create
	public Animal create(@RequestBody Animal animal) {
		this.animals.add(animal);

		// Returns the latest entry added to the list
		return this.animals.get(this.animals.size() - 1);
	}

	// GET - READ
	@GetMapping("/readAll")
	public List<Animal> readAll() {
		return this.animals;
	}

	// ReadByID
	@GetMapping("/readById/{id}")
	public Animal readById(@PathVariable int id) {
		return this.animals.get(id);
	}

	// PUT - UPDATE
	@PutMapping("/update/{id}")
	public Animal update(@PathVariable int id, @RequestBody Animal animal) {
		// Removing the original customer
		this.animals.remove(id);

		// Add the updated customer
		this.animals.add(id, animal);

		// Return the updated user
		return this.animals.get(id);
	}

	// DELETE - DELETE
	@DeleteMapping("/delete/{id}")
	public Animal delete(@PathVariable int id) {
		return this.animals.remove(id);

	}
}
