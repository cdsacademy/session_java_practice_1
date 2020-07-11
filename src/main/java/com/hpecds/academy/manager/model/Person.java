package com.hpecds.academy.manager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue
    @Column
    private Integer id;
    
    @Column(length = 10, unique = true)
    private String dni;
    
    @Column
    private String name;
    
    @Column
    private String surname;
    
    @Column
    private String surname2;
    
    protected Person() {
    }

    public Person(String dni, String name, String surname) {
    	this.dni = dni;
    	this.name = name;
    	this.surname = surname;
	}
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

}
