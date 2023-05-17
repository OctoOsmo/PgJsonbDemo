package org.octoosmo.pgJsonbDemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.octoosmo.pgJsonbDemo.model.Person;
import org.octoosmo.pgJsonbDemo.model.request.PersonCreateRequest;
import org.octoosmo.pgJsonbDemo.model.request.PersonUpdateRequest;
import org.octoosmo.pgJsonbDemo.model.response.PersonResponse;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonCreateRequest personCreateRequestToPerson(Person person);

    PersonUpdateRequest personUpdateRequestToPerson(Person person);

    Person personCreateRequestToPerson(PersonCreateRequest person);

    Person personUpdateRequestToPerson(PersonUpdateRequest person);

    PersonResponse personToPersonResponse(Person person);
}
