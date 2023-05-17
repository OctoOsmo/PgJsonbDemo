package org.octoosmo.pgJsonbDemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.octoosmo.pgJsonbDemo.entity.PersonEntity;
import org.octoosmo.pgJsonbDemo.model.Person;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonEntityMapper {
    PersonEntityMapper INSTANCE = Mappers.getMapper(PersonEntityMapper.class);

    Person personEntityToPerson(PersonEntity personEntity);

    PersonEntity personToPersonEntity(Person person);
}
