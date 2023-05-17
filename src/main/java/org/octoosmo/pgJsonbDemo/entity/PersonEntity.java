package org.octoosmo.pgJsonbDemo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String address;
    @Column
    private String phone;

    @Column
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> customAttributesJson;

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
