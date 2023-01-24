package org.octoosmo.PgJsonbDemo.request;

import java.util.Map;

public record PersonCreateRequest(String name,
                                  String email,
                                  String address,
                                  String phone,
                                  Map<String, Object> custom_attributes_json) {
}
