package org.octoosmo.pgJsonbDemo.mapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PersonEntityMapperTest {

    @Test
    public void personEntityToPerson() {
        var personModels = TestDataProducer.createPersonModels();
        var personEntity = personModels.personEntity();
        var expectedPerson = personModels.person();

        var person = PersonEntityMapper.INSTANCE.personEntityToPerson(personEntity);

        assertNotEquals(expectedPerson, person);
        assertEquals(person.getId(), expectedPerson.getId());
        assertEquals(person.getName(), expectedPerson.getName());
        assertEquals(person.getEmail(), expectedPerson.getEmail());
        assertEquals(person.getAddress(), expectedPerson.getAddress());
        assertEquals(person.getPhone(), expectedPerson.getPhone());
        assertEquals(person.getCustomAttributesJson(), expectedPerson.getCustomAttributesJson());
    }

    @Test
    public void personToPersonEntity() {
        var personModels = TestDataProducer.createPersonModels();
        var person = personModels.person();
        var expectedPersonEntity = personModels.personEntity();

        var personEntity = PersonEntityMapper.INSTANCE.personToPersonEntity(person);

        assertNotEquals(expectedPersonEntity, personEntity);
        assertEquals(personEntity.getId(), expectedPersonEntity.getId());
        assertEquals(personEntity.getName(), expectedPersonEntity.getName());
        assertEquals(personEntity.getEmail(), expectedPersonEntity.getEmail());
        assertEquals(personEntity.getAddress(), expectedPersonEntity.getAddress());
        assertEquals(personEntity.getPhone(), expectedPersonEntity.getPhone());
        assertEquals(personEntity.getCustomAttributesJson(), expectedPersonEntity.getCustomAttributesJson());
    }
}
