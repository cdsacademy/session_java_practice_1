package com.hpecds.academy.manager.controller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hpecds.academy.manager.bll.PersonService;
import com.hpecds.academy.manager.model.Person;

@RestController
@RequestMapping("/academy/persons")
public class PersonRestController {
	PersonService personService;

	@Autowired
	public PersonRestController(PersonService personService) {
		this.personService = personService;
	}

	protected PersonRestController() {

	}

	/**
	 * Register person in academy.
	 *
	 * @param dni
	 * @param name
	 * @param surname
	 * @return person
	 */
	@RequestMapping(value = "/create")
	private Person createPerson(String dni, String name, String surname) {
		return personService.createPerson(dni, name, surname);
	}

	/**
	 * Return all people registered in academy.
	 * 
	 * @return people list
	 */
	@RequestMapping(value = "/list")
	private List<Person> getPeopleList() {
		List<Person> response = new ArrayList<Person>();
		personService.lookup().forEach(response::add);
		return response;
	}

	/**
	 * Return number of people registered in academy.
	 * 
	 * @return people count
	 */
	@RequestMapping(value = "/count")
	private long getPeopleNumber() {
		return personService.total();
	}

	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 *
	 * @param ex
	 * @return Error message String.
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ex) {
		return ex.getMessage();
	}

}
