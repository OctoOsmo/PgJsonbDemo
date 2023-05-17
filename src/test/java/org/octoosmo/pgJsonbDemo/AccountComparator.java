package org.octoosmo.pgJsonbDemo;

import org.octoosmo.pgJsonbDemo.entity.AccountEntity;
import org.octoosmo.pgJsonbDemo.model.Account;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComparator {
    public static void compareAccounts(Account account, Account expectedAccount) {
        assertEquals(expectedAccount.getId(), account.getId());
        assertEquals(expectedAccount.getCurrency(), account.getCurrency());
        assertEquals(expectedAccount.getBalance(), account.getBalance());
        assertEquals(expectedAccount.getCustomAttributesJson(), account.getCustomAttributesJson());
        assertEquals(expectedAccount.getPerson().getId(), account.getPerson().getId());
        assertEquals(expectedAccount.getPerson().getAddress(), account.getPerson().getAddress());
        assertEquals(expectedAccount.getPerson().getEmail(), account.getPerson().getEmail());
        assertEquals(expectedAccount.getPerson().getName(), account.getPerson().getName());
        assertEquals(expectedAccount.getPerson().getPhone(), account.getPerson().getPhone());
        assertEquals(expectedAccount.getPerson().getCustomAttributesJson(), account.getPerson().getCustomAttributesJson());
    }

    public static void compareAccountEntities(AccountEntity expectedAccountEntity, AccountEntity accountEntity) {
        assertEquals(expectedAccountEntity.getId(), accountEntity.getId());
        assertEquals(expectedAccountEntity.getCurrency(), accountEntity.getCurrency());
        assertEquals(expectedAccountEntity.getBalance(), accountEntity.getBalance());
        assertEquals(expectedAccountEntity.getCustomAttributesJson(), accountEntity.getCustomAttributesJson());
        assertEquals(expectedAccountEntity.getPerson().getId(), accountEntity.getPerson().getId());
        assertEquals(expectedAccountEntity.getPerson().getAddress(), accountEntity.getPerson().getAddress());
        assertEquals(expectedAccountEntity.getPerson().getEmail(), accountEntity.getPerson().getEmail());
        assertEquals(expectedAccountEntity.getPerson().getName(), accountEntity.getPerson().getName());
        assertEquals(expectedAccountEntity.getPerson().getPhone(), accountEntity.getPerson().getPhone());
        assertEquals(expectedAccountEntity.getPerson().getCustomAttributesJson(), accountEntity.getPerson().getCustomAttributesJson());
    }
}
