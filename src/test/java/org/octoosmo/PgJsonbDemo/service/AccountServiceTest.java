package org.octoosmo.pgJsonbDemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.octoosmo.pgJsonbDemo.AccountComparator;
import org.octoosmo.pgJsonbDemo.mapper.TestDataProducer;
import org.octoosmo.pgJsonbDemo.model.Account;
import org.octoosmo.pgJsonbDemo.repository.AccountRepository;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private PersonService personService;

    @InjectMocks
    private AccountService accountService;

    private TestDataProducer.PersonModels personModels;
    private TestDataProducer.AccountModels accountModels;

    @BeforeEach
    void setUp() {
        personModels = TestDataProducer.createPersonModels();
        accountModels = TestDataProducer.createAccountModels(personModels);
        lenient().when(accountRepository.findById(any(UUID.class))).thenReturn(Optional.of(accountModels.accountEntity()));
        lenient().when(accountRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
        lenient().when(personService.find(any(UUID.class))).thenReturn(personModels.person());
    }

    @Test
    void find() {
        var accountId = accountModels.account().getId();

        var account = accountService.find(accountId);

        AccountComparator.compareAccounts(accountModels.account(), account);
    }

    @Test
    void create() {
        var accountCreateRequest = TestDataProducer.createAccountCreateRequest();
        var expectedAccount = new Account(null,
                personModels.person(),
                accountCreateRequest.currency(),
                accountCreateRequest.balance(),
                accountCreateRequest.customAttributesJson());

        var account = accountService.create(accountCreateRequest);
        expectedAccount.setId(account.getId());

        AccountComparator.compareAccounts(expectedAccount, account);
    }

    @Test
    void update() {
        var accountUpdateRequest = TestDataProducer.createAccountUpdateRequest();
        var expectedAccount = new Account(null,
                personModels.person(),
                accountUpdateRequest.currency(),
                accountUpdateRequest.balance(),
                accountUpdateRequest.customAttributesJson());

        var account = accountService.update(UUID.randomUUID(), accountUpdateRequest);
        expectedAccount.setId(account.getId());

        AccountComparator.compareAccounts(expectedAccount, account);
    }

    @Test
    void delete() {
        accountService.delete(UUID.randomUUID());

        verify(accountRepository).deleteById(any(UUID.class));
    }
}
