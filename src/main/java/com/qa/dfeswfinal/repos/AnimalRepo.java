package com.qa.dfeswfinal.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dfeswfinal.entities.Animal;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {

}
