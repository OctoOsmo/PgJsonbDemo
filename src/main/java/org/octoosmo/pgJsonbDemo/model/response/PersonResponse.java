package org.octoosmo.pgJsonbDemo.model.response;

import java.util.Map;
import java.util.UUID;

public record PersonResponse(UUID id,
                             String name,
                             String email,
                             String address,
                             String phone,
                             Map<String, Object> customAttributesJson) {
}
