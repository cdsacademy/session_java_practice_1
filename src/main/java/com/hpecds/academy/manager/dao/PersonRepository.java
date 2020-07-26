package com.hpecds.academy.manager.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hpecds.academy.manager.model.Person;

@RepositoryRestResource(exported=true)
public interface PersonRepository extends CrudRepository<Person, Integer> {

    Person findByDni(@Param("dni") String dni);

    Person findByNameAndSurname(@Param("alias") String name, @Param("secondName") String surname);

}
