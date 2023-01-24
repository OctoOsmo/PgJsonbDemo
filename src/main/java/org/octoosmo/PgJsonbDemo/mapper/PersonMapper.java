package org.octoosmo.PgJsonbDemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.octoosmo.PgJsonbDemo.model.Person;
import org.octoosmo.PgJsonbDemo.request.PersonCreateRequest;
import org.octoosmo.PgJsonbDemo.request.PersonUpdateRequest;
import org.octoosmo.PgJsonbDemo.response.PersonResponse;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonCreateRequest personCreateRequestToPerson(Person person);

    PersonUpdateRequest personUpdateRequestToPerson(Person person);

    Person personCreateRequestToPerson(PersonCreateRequest person);

    Person personUpdateRequestToPerson(PersonUpdateRequest person);

    PersonResponse personToPersonResponse(Person person);
}
