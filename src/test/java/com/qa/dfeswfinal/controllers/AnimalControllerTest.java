package com.qa.dfeswfinal.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dfeswfinal.entities.Animal;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testschema.sql",
		"classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class AnimalControllerTest {

	@Autowired
	private MockMvc mvc; // used for sending mock requests

	@Autowired
	private ObjectMapper mapper; // used for converting objects to JSON

	@Test
	public void createTest() throws Exception {
		Animal entry = new Animal("Tiger", "Orange", "Fur");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Animal result = new Animal(2L, "Tiger", "Orange", "Fur");
		String resultAsJSON = mapper.writeValueAsString(result);

		mvc.perform(post("/create").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));

	}

	@Test
	public void readAllTest() throws Exception {
		// Setting up my expected output object
		List<Animal> output = new ArrayList<>();

		Animal entry = new Animal(1L, "Lion", "Gold", "Fur");
		output.add(entry);

		// Convert my expected output to JSON
		String outputAsJSON = mapper.writeValueAsString(output);

		mvc.perform(get("/readAll").contentType(MediaType.APPLICATION_JSON)).andExpect(content().json(outputAsJSON));

	}

	@Test
	public void readByIdTest() throws Exception {

		Animal entry = new Animal(1L, "Lion", "Gold", "Fur");

		String outputAsJSON = mapper.writeValueAsString(entry);

		mvc.perform(get("/readById/1").contentType(MediaType.APPLICATION_JSON)).andExpect(content().json(outputAsJSON));

	}

	@Test
	public void updateTest() throws Exception {
		Animal entry = new Animal("Tiger", "Orange", "Fur");

		Animal result = new Animal(1L, "Tiger", "Orange", "Fur");

		String entryAsJSON = this.mapper.writeValueAsString(entry);

		String resultAsJSON = this.mapper.writeValueAsString(result);

		mvc.perform(put("/update/1").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}

	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/delete/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
}
