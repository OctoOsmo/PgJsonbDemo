package org.octoosmo.pgJsonbDemo;

import org.octoosmo.pgJsonbDemo.entity.PersonEntity;
import org.octoosmo.pgJsonbDemo.model.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonComparator {

    public static void comparePersonEntities(PersonEntity expected, PersonEntity actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getPhone(), actual.getPhone());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getAddress(), actual.getAddress());
        assertEquals(expected.getCustomAttributesJson(), actual.getCustomAttributesJson());
    }

    public static void comparePeople(Person expected, Person actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getPhone(), actual.getPhone());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getAddress(), actual.getAddress());
        assertEquals(expected.getCustomAttributesJson(), actual.getCustomAttributesJson());
    }
}
