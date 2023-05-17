package org.octoosmo.pgJsonbDemo.model.request;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public record PersonSearchRequest(
        List<UUID> ids,
        List<String> names,
        List<String> emails,
        List<String> addresses,
        List<String> phones,
        Map<String, Object> customAttributesJson,
        List<Map<String, Object>> custom_attributes_jsons
) {
}
