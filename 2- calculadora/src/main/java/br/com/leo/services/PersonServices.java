package br.com.leo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.leo.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("leo");
		person.setLastName("trevisol");
		person.setAdress("Caxias do sul");
		person.setGender("Masculino");
		return person;
		
	}
	
	public List<Person> findAll(){
		List<Person> lstPerson = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			lstPerson.add(person);
		}
		return lstPerson;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("leo");
		person.setLastName("trevisol");
		person.setAdress("Caxias do sul");
		person.setGender("Masculino");
		return person;
	}
	
	public Person create (Person person) {
		return person;
	}

	public Person update (Person person) {
		return person;
	}
	
	public void delete (String id) {
	}

}
