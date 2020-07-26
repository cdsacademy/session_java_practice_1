package com.hpecds.academy.manager.bll;

import com.hpecds.academy.manager.model.Person;

public interface PersonService {

	public Person createPerson(String dni, String name, String surname);

	public Iterable<Person> lookup();

	public long total();

}
