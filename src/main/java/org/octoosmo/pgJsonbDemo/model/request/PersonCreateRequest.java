package org.octoosmo.pgJsonbDemo.model.request;

import java.util.Map;

public record PersonCreateRequest(String name,
                                  String email,
                                  String address,
                                  String phone,
                                  Map<String, Object> customAttributesJson) {
}
