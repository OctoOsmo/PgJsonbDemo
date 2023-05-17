package org.octoosmo.pgJsonbDemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.octoosmo.pgJsonbDemo.mapper.TestDataProducer;
import org.octoosmo.pgJsonbDemo.repository.PersonRepository;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.octoosmo.pgJsonbDemo.PersonComparator.comparePeople;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    private final TestDataProducer.PersonModels personModels = TestDataProducer.createPersonModels();

    @BeforeEach
    void setUp() {
        lenient().when(personRepository.findById(any(UUID.class))).thenReturn(Optional.of(personModels.personEntity()));
        lenient().when(personRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
    }

    @Test
    void find() {
        var person = personService.find(UUID.randomUUID());

        comparePeople(personModels.person(), person);
    }

    @Test
    void create() {
        var expectedPerson = personModels.person();

        var person = personService.create(personModels.person());
        expectedPerson.setId(person.getId());

        comparePeople(expectedPerson, person);
    }

    @Test
    void update() {
        when(personRepository.existsById(any(UUID.class))).thenReturn(true);

        var person = personService.update(personModels.person());

        comparePeople(personModels.person(), person);
    }

    @Test
    void delete() {
        personService.delete(UUID.randomUUID());

        verify(personRepository).deleteById(any(UUID.class));
    }

    @Test
    void search() {
    }
}
