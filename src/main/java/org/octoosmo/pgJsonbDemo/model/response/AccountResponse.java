package org.octoosmo.pgJsonbDemo.model.response;

import org.octoosmo.pgJsonbDemo.model.Person;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;


public record AccountResponse(UUID id,
                              Person person,
                              String currency,
                              BigDecimal balance,
                              Map<String, Object> customAttributesJson
) {
}
