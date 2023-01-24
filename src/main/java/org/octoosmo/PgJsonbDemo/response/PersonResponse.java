package org.octoosmo.PgJsonbDemo.response;

import java.util.Map;
import java.util.UUID;

public record PersonResponse(UUID id,
                             String name,
                             String email,
                             String address,
                             String phone,
                             Map<String, Object> custom_attributes_json) {
}
