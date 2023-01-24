package org.octoosmo.PgJsonbDemo.model;

import io.soabase.recordbuilder.core.RecordBuilder;

import java.util.Map;
import java.util.UUID;

@RecordBuilder
public record Person(UUID id,
                     String name,
                     String email,
                     String address,
                     String phone,
                     Map<String, Object> custom_attributes_json) implements PersonBuilder.With {
}
