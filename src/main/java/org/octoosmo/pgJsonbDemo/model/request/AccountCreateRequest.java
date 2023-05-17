package org.octoosmo.pgJsonbDemo.model.request;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;


public record AccountCreateRequest(
        UUID personId,
        String currency,
        BigDecimal balance,
        Map<String, Object> customAttributesJson) {
}
