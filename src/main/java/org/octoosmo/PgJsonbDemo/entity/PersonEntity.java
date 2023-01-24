package org.octoosmo.PgJsonbDemo.entity;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

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

    @Type(JsonType.class)
    @Column
    private Map<String, Object> custom_attributes_json;

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

    public Map<String, Object> getCustom_attributes_json() {
        return custom_attributes_json;
    }

    public void setCustom_attributes_json(Map<String, Object> custom_attributes_json) {
        this.custom_attributes_json = custom_attributes_json;
    }
}
