package org.octoosmo.PgJsonbDemo.service;

import org.octoosmo.PgJsonbDemo.mapper.PersonEntityMapper;
import org.octoosmo.PgJsonbDemo.model.Person;
import org.octoosmo.PgJsonbDemo.repository.PersonRepository;
import org.octoosmo.PgJsonbDemo.request.PersonSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public Person find(UUID uuid) {
        return personRepository.findById(uuid)
                .map(PersonEntityMapper.INSTANCE::personEntityToPerson)
                .orElseThrow();
    }

    @Transactional
    public Person create(Person person) {
        var personEntity = PersonEntityMapper.INSTANCE.personToPersonEntity(person);
        personEntity = personRepository.save(personEntity);
        return PersonEntityMapper.INSTANCE.personEntityToPerson(personEntity);
    }

    @Transactional
    public Person update(Person person) {
        if (!personRepository.existsById(person.id())) {
            throw new RuntimeException("Person with id = %s does not exist".formatted(person.id()));
        }
        var personEntity = PersonEntityMapper.INSTANCE.personToPersonEntity(person);
        personEntity = personRepository.save(personEntity);
        return PersonEntityMapper.INSTANCE.personEntityToPerson(personEntity);
    }

    @Transactional
    public void delete(UUID id) {
        personRepository.deleteById(id);
    }

    @Transactional
    public Page<Person> search(PersonSearchRequest personSearchRequest, Pageable pageable) {
        var specification = PersonSpecificationBuilder.build(personSearchRequest)
                .orElseThrow(() -> new RuntimeException("Specify at least one parameter"));
        var personEntityPage = personRepository.findAll(specification, pageable);

        return new PageImpl<>(personEntityPage.stream()
                .map(PersonEntityMapper.INSTANCE::personEntityToPerson)
                .toList(), pageable, personEntityPage.getTotalElements());
    }
}
