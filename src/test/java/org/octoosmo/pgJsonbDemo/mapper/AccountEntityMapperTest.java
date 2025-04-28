package org.octoosmo.pgJsonbDemo.mapper;

import org.junit.jupiter.api.Test;
import org.octoosmo.pgJsonbDemo.AccountComparator;

class AccountEntityMapperTest {

    @Test
    void accountEntityToAccount() {
        var personModels = TestDataProducer.createPersonModels();
        var accountModels = TestDataProducer.createAccountModels(personModels);

        var mappedAccount = AccountEntityMapper.INSTANCE.accountEntityToAccount(accountModels.accountEntity());

        var account = accountModels.account();
        AccountComparator.compareAccounts(mappedAccount, account);

    }

    @Test
    void accountToAccountEntity() {
        var personModels = TestDataProducer.createPersonModels();
        var accountModels = TestDataProducer.createAccountModels(personModels);

        var mappedAccountEntity = AccountEntityMapper.INSTANCE.accountToAccountEntity(accountModels.account());

        AccountComparator.compareAccountEntities(mappedAccountEntity, accountModels.accountEntity());
    }

}
