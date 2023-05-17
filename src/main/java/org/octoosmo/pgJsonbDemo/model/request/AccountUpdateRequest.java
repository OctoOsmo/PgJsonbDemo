package org.octoosmo.pgJsonbDemo.model.request;

import java.math.BigDecimal;
import java.util.Map;


public record AccountUpdateRequest(
        String currency,
        BigDecimal balance,
        Map<String, Object> customAttributesJson) {
}
