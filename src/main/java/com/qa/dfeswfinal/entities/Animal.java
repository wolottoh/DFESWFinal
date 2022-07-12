package com.qa.dfeswfinal.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;  // <- Type of id
	
	private String name;
	
	private String colour;
	
	private String bodyCovering;
	
	
	
	public Animal() {}

	@Override
	public int hashCode() {
		return Objects.hash(bodyCovering, colour, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(bodyCovering, other.bodyCovering) && Objects.equals(colour, other.colour)
				&& id == other.id && Objects.equals(name, other.name);
	}

	public Animal(String name, String colour, String bodyCovering) {
		super();
		this.name = name;
		this.colour = colour;
		this.bodyCovering = bodyCovering;
	}

	public Animal(long id, String name, String colour, String bodyCovering) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.bodyCovering = bodyCovering;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getBodyCovering() {
		return bodyCovering;
	}

	public void setBodyCovering(String bodyCovering) {
		this.bodyCovering = bodyCovering;
	}
	
	
	
	
	
	

}
