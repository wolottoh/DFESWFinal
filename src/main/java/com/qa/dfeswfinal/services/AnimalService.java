package com.qa.dfeswfinal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dfeswfinal.entities.Animal;

@Service
public class AnimalService {

	// TEMPORARY storage, until we implement the real database later!
	private List<Animal> animals = new ArrayList<>();

	// POST - CREATE
	public Animal create(Animal animal) {
		this.animals.add(animal);

		// Returns the latest entry added to the list
		return this.animals.get(this.animals.size() - 1);
	}

	// GET - READ
	// ReadAll
	public List<Animal> readAll() {
		return this.animals;
	}

	// ReadByID
	public Animal readById(int id) {
		return this.animals.get(id);
	}
	
	//PUT - UPDATE
		public Animal update(int id, Animal animal) {
			// Removing the original customer
			this.animals.remove(id);

			// Add the updated customer
			this.animals.add(id, animal);

			// Return the updated user
			return this.animals.get(id);
		}
		
		//DELETE - DELETE
		public Animal delete(int id) {
			return this.animals.remove(id);
		}

}
