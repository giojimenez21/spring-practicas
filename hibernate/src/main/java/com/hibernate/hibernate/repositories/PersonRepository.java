package com.hibernate.hibernate.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hibernate.hibernate.dto.PersonDto;
import com.hibernate.hibernate.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("select p from Person p where p.programmingLanguage = ?1")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage);

    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

    @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage = ?1")
    List<Object[]> obtenerPersonData(String programmingLanguage);

    @Query("select p from Person p where p.id = ?1")
    Optional<Person> findOne(Long id);

    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneLikeName(String name);

    Optional<Person> findByNameContaining(String name);

    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonDataFull(); 

    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p where p.id=?1")
    Object  obtenerPersonDataFullById(Long id); 

    @Query("select p, p.programmingLanguage from Person p")
    List<Object[]> findAllMixPerson();

    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllClassPerson();

    @Query("select new com.hibernate.hibernate.dto.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> findAllClassPersonDto();

    @Query("select p.name from Person p")
    List<String> findAllNames();

    @Query("select distinct(p.name) from Person p")
    List<String> findAllNamesDistinct();

    @Query("select distinct(p.programmingLanguage) from Person p")
    List<String> findAllLanguagesDistinct();

    @Query("select count(distinct(p.programmingLanguage)) from Person p")
    Long findAllLanguagesDistinctCount(); 

    @Query("select p from Person p where p.id between 2 and 5")
    List<Person> findAllBetween();

    @Query("select p from Person p where p.id between ?1 and ?2 order by p.name")
    List<Person> findAllBetween(Integer c1, Integer c2);

    List<Person> findByIdBetweenOrderByIdDesc(Long id1, Long id2);

    List<Person> findByNameBetween(String name1, String name2);  

    @Query("select count(p) from Person p")
    Long totalPerson();

    @Query("select min(p.id) from Person p")
    Long getMinId();

    @Query("select max(p.id) from Person p")
    Long getMaxId();

    @Query("select p.name, length(p.name) from Person p")
    List<Object[]> getPersonNameLength();

    @Query("select p.name, length(p.name) from Person p where length(p.name) = (select min(length(p.name from Person p)))")
    List<Object[]> getShorterName();

    @Query("select p from Person p where p.id in ?1")
    List<Person> getPersonByIds(List<Long> ids);
}
