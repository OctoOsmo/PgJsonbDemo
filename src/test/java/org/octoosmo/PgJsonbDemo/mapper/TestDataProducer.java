package org.octoosmo.pgJsonbDemo.mapper;

import net.datafaker.Faker;
import org.octoosmo.pgJsonbDemo.entity.AccountEntity;
import org.octoosmo.pgJsonbDemo.entity.PersonEntity;
import org.octoosmo.pgJsonbDemo.model.Account;
import org.octoosmo.pgJsonbDemo.model.Person;
import org.octoosmo.pgJsonbDemo.model.request.AccountCreateRequest;
import org.octoosmo.pgJsonbDemo.model.request.AccountUpdateRequest;
import org.octoosmo.pgJsonbDemo.model.request.PersonCreateRequest;
import org.octoosmo.pgJsonbDemo.model.response.AccountResponse;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TestDataProducer {
    private static final Faker FAKER = new Faker();

    public static AccountCreateRequest createAccountCreateRequest() {
        return new AccountCreateRequest(
                UUID.randomUUID(),
                "USD",
                new BigDecimal(FAKER.commerce().price()),
                new HashMap<>() {{
                    put("age", FAKER.number());
                    put("isPremium", true);
                    put("favoriteHotels", List.of("Ritz Carlton", "W Hotel"));
                    put("secondName", "Wick");
                    put("hasDiscount", true);
                }});
    }

    public static AccountUpdateRequest createAccountUpdateRequest() {
        return new AccountUpdateRequest(
                "USD",
                new BigDecimal(FAKER.commerce().price()),
                new HashMap<>() {{
                    put("age", FAKER.number());
                    put("isPremium", true);
                    put("favoriteHotels", List.of("Ritz Carlton", "W Hotel"));
                    put("secondName", "Wick");
                    put("hasDiscount", true);
                }});
    }

    public static AccountResponse createAccountResponse() {
        return new AccountResponse(
                UUID.randomUUID(),
                createPersonModels().person(),
                "USD",
                new BigDecimal(FAKER.commerce().price()),
                new HashMap<>() {{
                    put("age", 24);
                    put("isPremium", true);
                    put("favoriteHotels", List.of("Ritz Carlton", "W Hotel"));
                    put("secondName", "Wick");
                    put("hasDiscount", true);
                }});
    }

    public static AccountModels createAccountModels(PersonModels personModels) {
        var accountId = UUID.randomUUID();
        var balance = new BigDecimal(FAKER.commerce().price());
        var currency = "USD";
        var accountCustomAttributesJson = new HashMap<String, Object>() {{
            put("age", 24);
            put("isPremium", true);
            put("favoriteHotels", List.of("Ritz Carlton", "W Hotel"));
            put("secondName", "Garcia");
            put("hasDiscount", true);
        }};
        var accountEntity = new AccountEntity() {{
            setId(accountId);
            setBalance(balance);
            setCurrency(currency);
            setPerson(personModels.personEntity());
            setCustomAttributesJson(accountCustomAttributesJson);
        }};

        var account = new Account(
                accountId,
                personModels.person(),
                currency,
                balance,
                accountCustomAttributesJson);
        return new AccountModels(accountEntity, account);
    }

    public static PersonModels createPersonModels() {
        var personId = UUID.randomUUID();
        var personAddress = FAKER.address().fullAddress();
        var personName = FAKER.name().fullName();
        var personEmail = FAKER.internet().emailAddress();
        var personPhone = FAKER.phoneNumber().phoneNumber();
        var personCustomAttributesJson = new HashMap<String, Object>() {{
            put("special_offers", "5% discount");
            put("personal_manager", FAKER.name().fullName());
        }};

        var personEntity = new PersonEntity() {{
            setId(personId);
            setAddress(personAddress);
            setName(personName);
            setEmail(personEmail);
            setPhone(personPhone);
            setCustomAttributesJson(personCustomAttributesJson);
        }};
        var person = new Person(
                personId,
                personName,
                personEmail,
                personAddress,
                personPhone,
                personCustomAttributesJson
        );
        return new PersonModels(personEntity, person);
    }

    public static PersonCreateRequest createPersonCreateRequest() {
        return new PersonCreateRequest(
                FAKER.address().fullAddress(),
                FAKER.name().fullName(),
                FAKER.internet().emailAddress(),
                FAKER.phoneNumber().phoneNumber(),
                new HashMap<>() {{
                    put("special_offers", "5% discount");
                    put("personal_manager", FAKER.name().fullName());
                }});
    }

    public record AccountModels(AccountEntity accountEntity, Account account) {
    }

    public record PersonModels(PersonEntity personEntity, Person person) {
    }
}
