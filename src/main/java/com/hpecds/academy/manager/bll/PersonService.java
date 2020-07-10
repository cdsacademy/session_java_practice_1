package com.hpecds.academy.manager.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpecds.academy.manager.dao.PersonRepository;
import com.hpecds.academy.manager.model.Person;

@Service
public class PersonService {
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public Person createPerson(String dni, String name, String surname) {
		return personRepository.save(new Person(dni, name, surname));
	}

	public Iterable<Person> lookup() {
		return personRepository.findAll();
	}

	public long total() {
		return personRepository.count();
	}

}
