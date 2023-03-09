package org.octoosmo.PgJsonbDemo.service;

import org.json.JSONObject;
import org.octoosmo.PgJsonbDemo.entity.PersonEntity;
import org.octoosmo.PgJsonbDemo.request.PersonSearchRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.*;

public class PersonSpecificationBuilder {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";
    private static final String CUSTOM_ATTRIBUTES_JSON = "custom_attributes_json";

    public static Optional<Specification<PersonEntity>> build(PersonSearchRequest searchRequest) {
        var specifications = new ArrayList<Specification<PersonEntity>>();

        idIn(searchRequest.ids()).ifPresent(specifications::add);
        nameIn(searchRequest.names()).ifPresent(specifications::add);
        emailIn(searchRequest.emails()).ifPresent(specifications::add);
        addressIn(searchRequest.addresses()).ifPresent(specifications::add);
        phoneIn(searchRequest.phones()).ifPresent(specifications::add);
        customAttributesIn(searchRequest.custom_attributes_json()).ifPresent(specifications::add);
        customAttributesIn(searchRequest.custom_attributes_jsons()).ifPresent(specifications::add);

        return specifications.stream().reduce(Specification::and);
    }

    private static Optional<Specification<PersonEntity>> idIn(List<UUID> ids) {
        return Optional.ofNullable(ids).filter(idList -> ids.size() > 0)
                .map(idList -> (root, query, criteriaBuilder) -> root.<String>get(ID).in(ids));
    }

    private static Optional<Specification<PersonEntity>> nameIn(List<String> names) {
        return stringFieldIn(NAME, names);
    }

    private static Optional<Specification<PersonEntity>> emailIn(List<String> emails) {
        return stringFieldIn(EMAIL, emails);
    }

    private static Optional<Specification<PersonEntity>> addressIn(List<String> addresses) {
        return stringFieldIn(ADDRESS, addresses);
    }

    private static Optional<Specification<PersonEntity>> phoneIn(List<String> phones) {
        return stringFieldIn(PHONE, phones);
    }

    private static Optional<Specification<PersonEntity>> stringFieldIn(String fieldName, List<String> fieldValues) {
        return Optional.ofNullable(fieldValues).filter(valueList -> valueList.size() > 0)
                .map(valueList -> (root, query, criteriaBuilder) -> root.<String>get(fieldName).in(valueList));
    }

    private static Optional<Specification<PersonEntity>> customAttributesIn(Map<String, ?> jsonMap) {
        return Optional.ofNullable(jsonMap).filter(json -> json.size() > 0)
                .map(json -> (root, query, criteriaBuilder) -> {
                    var expression = criteriaBuilder.function(
                            "internal_jsonb_contains",
                            Boolean.class,
                            root.get(CUSTOM_ATTRIBUTES_JSON),
                            criteriaBuilder.literal(new JSONObject(jsonMap).toString())
                    );
                    return criteriaBuilder.isTrue(expression);
                });
    }

    private static Optional<Specification<PersonEntity>> customAttributesIn(List<Map<String, Object>> jsonMaps) {
        return Optional.ofNullable(jsonMaps).orElse(List.of()).stream()
                .map(PersonSpecificationBuilder::customAttributesIn)
                .flatMap(Optional::stream)
                .reduce(Specification::or);
    }
}
