package com.hibernate.hibernate;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.hibernate.entities.Person;
import com.hibernate.hibernate.repositories.PersonRepository;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {
	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		list();
		findOne();
		create();
	}

	@Transactional
	public void delete() {
		Scanner scanner = new Scanner(System.in);
		Long id = scanner.nextLong();
		//Forma 1
		personRepository.deleteById(id);

		//Forma 2
		Optional<Person> optionalPerson = personRepository.findById(id);
		optionalPerson.ifPresent(person -> {
			personRepository.delete(person);
		});

		scanner.close();

	}

	@Transactional
	public void delete2() {
		Scanner scanner = new Scanner(System.in);
		Long id = scanner.nextLong(); 

		//Forma 2
		Optional<Person> optionalPerson = personRepository.findById(id);
		optionalPerson.ifPresent(personRepository::delete);

		scanner.close();

	}

	@Transactional 
	public void update() {
		Scanner scanner = new Scanner(System.in);
		Long id = scanner.nextLong();
		Optional<Person> optionalPerson = personRepository.findById(id);
		optionalPerson.ifPresent(person -> {
			String programming = scanner.next();
			person.setProgrammingLanguage(programming);
			Person persondb = personRepository.save(person);
			System.out.println(persondb);
		});
		scanner.close();
	}

	@Transactional
	public void create() {
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		String lastName = scanner.next();
		String programmingLanguage = scanner.next();
		scanner.close();
		Person person = Person.builder()
				.name(name)
				.lastname(lastName)
				.programmingLanguage(programmingLanguage)
				.build();
		Person newPerson = personRepository.save(person);
		System.out.println(newPerson.getId());

		personRepository.findById(newPerson.getId())
			.ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findOne() {
		// Forma 1
		Person person = null;
		Optional<Person> optionalPerson = personRepository.findById(1L);
		if (optionalPerson.isPresent()) {
			person = optionalPerson.get();
		}
		System.out.println(person);

		// Forma 2
		personRepository.findById(1L).ifPresent(System.out::println);
		// Forma 3
		personRepository.findOne(1L);
	}

	public void list() {
		List<Person> persons = (List<Person>) personRepository.findByProgrammingLanguage("Java");
		persons
				.stream()
				.forEach(person -> System.out.println(person));

		List<Object[]> personValues = personRepository.obtenerPersonData("Python");
		personValues
				.stream()
				.forEach(person -> System.out.println(person[0] + "" + person[1]));
	}

}
