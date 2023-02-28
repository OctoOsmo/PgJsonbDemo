package org.octoosmo.PgJsonbDemo.service;

import org.octoosmo.PgJsonbDemo.entity.PersonEntity;
import org.octoosmo.PgJsonbDemo.request.PersonSearchRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PersonSpecificationBuilder {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";
    private static final String CUSTOM_ATTRIBUTES_JSON = "custom_attributes_json";

    public static Optional<Specification<PersonEntity>> build(PersonSearchRequest searchRequest) {
        List<Specification<PersonEntity>> specifications = new ArrayList<>();
        if (!CollectionUtils.isEmpty(searchRequest.ids())) {
            specifications.add(idIn(searchRequest.ids()));
        }
        if (!CollectionUtils.isEmpty(searchRequest.names())) {
            specifications.add(nameIn(searchRequest.names()));
        }
        if (!CollectionUtils.isEmpty(searchRequest.emails())) {
            specifications.add(emailIn(searchRequest.emails()));
        }
        if (!CollectionUtils.isEmpty(searchRequest.addresses())) {
            specifications.add(addressIn(searchRequest.addresses()));
        }
        if (!CollectionUtils.isEmpty(searchRequest.phones())) {
            specifications.add(phoneIn(searchRequest.phones()));
        }

        if (specifications.isEmpty()) {
            return Optional.empty();
        }

        Specification<PersonEntity> initialSpec = Specification.where(specifications.get(0));
        return Optional.of(specifications.stream()
                .skip(1)
                .reduce(initialSpec, Specification::and));
    }

    public static Specification<PersonEntity> idIn(List<UUID> ids) {
        return (root, query, criteriaBuilder) -> root.<String>get(ID).in(ids);
    }

    public static Specification<PersonEntity> nameIn(List<String> names) {
        return stringFieldIn(NAME, names);
    }

    public static Specification<PersonEntity> emailIn(List<String> emails) {
        return stringFieldIn(EMAIL, emails);
    }

    public static Specification<PersonEntity> addressIn(List<String> addresses) {
        return stringFieldIn(ADDRESS, addresses);
    }

    public static Specification<PersonEntity> phoneIn(List<String> phones) {
        return stringFieldIn(PHONE, phones);
    }

    private static Specification<PersonEntity> stringFieldIn(String fieldName, List<String> fieldValues) {
        return (root, query, criteriaBuilder) -> root.<String>get(fieldName).in(fieldValues);
    }
}
