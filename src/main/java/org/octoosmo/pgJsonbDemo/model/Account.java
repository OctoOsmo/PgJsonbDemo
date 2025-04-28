package org.octoosmo.pgJsonbDemo.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public class Account {
    private UUID id;
    private Person person;
    private String currency;
    private BigDecimal balance;
    private Map<String, Object> customAttributesJson;

    public Account() {
    }

    public Account(UUID id, Person person, String currency, BigDecimal balance, Map<String, Object> customAttributesJson) {
        this.id = id;
        this.person = person;
        this.currency = currency;
        this.balance = balance;
        this.customAttributesJson = customAttributesJson;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Map<String, Object> getCustomAttributesJson() {
        return customAttributesJson;
    }

    public void setCustomAttributesJson(Map<String, Object> customAttributesJson) {
        this.customAttributesJson = customAttributesJson;
    }
}
