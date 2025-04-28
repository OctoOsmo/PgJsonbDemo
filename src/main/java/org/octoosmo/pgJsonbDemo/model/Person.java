package org.octoosmo.pgJsonbDemo.model;


import java.util.Map;
import java.util.UUID;

public class Person {
    private UUID id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private Map<String, Object> customAttributesJson;

    public Person() {
    }

    public Person(UUID id, String name, String email, String address, String phone, Map<String, Object> customAttributesJson) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.customAttributesJson = customAttributesJson;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<String, Object> getCustomAttributesJson() {
        return customAttributesJson;
    }

    public void setCustomAttributesJson(Map<String, Object> customAttributesJson) {
        this.customAttributesJson = customAttributesJson;
    }
}
