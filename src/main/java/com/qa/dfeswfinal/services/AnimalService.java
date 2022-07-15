package com.qa.dfeswfinal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dfeswfinal.entities.Animal;
import com.qa.dfeswfinal.repos.AnimalRepo;

@Service
public class AnimalService {

	private AnimalRepo repo;

	public AnimalService(AnimalRepo repo) {
		this.repo = repo;
	}

	// POST - CREATE
	public Animal create(Animal animal) {
		return this.repo.saveAndFlush(animal);
	}

	// GET - READ
	// ReadAll
	public List<Animal> readAll() {
		return this.repo.findAll();
	}

	// ReadByID
	public Animal readById(Long id) {
		return this.repo.findById(id).get();
	}

	// PUT - UPDATE
	public Animal update(Long id, Animal animal) {

		// 1) Get the existing entry.
		Animal existing = this.repo.findById(id).get();

		// 2) Change the existing entry, using our new animal object above.
		existing.setName(animal.getName());
		existing.setColour(animal.getColour());
		existing.setBodyCovering(animal.getBodyCovering());

		// 3) Save the entry back into the Database.
		return this.repo.saveAndFlush(existing);
	}

	// DELETE - DELETE
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id); // this should be false. If it's true, then the delete failed, somehow.
	}

}
