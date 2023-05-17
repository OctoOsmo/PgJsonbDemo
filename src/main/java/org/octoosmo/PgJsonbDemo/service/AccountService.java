package org.octoosmo.pgJsonbDemo.service;

import org.octoosmo.pgJsonbDemo.mapper.AccountEntityMapper;
import org.octoosmo.pgJsonbDemo.mapper.AccountMapper;
import org.octoosmo.pgJsonbDemo.model.Account;
import org.octoosmo.pgJsonbDemo.model.request.AccountCreateRequest;
import org.octoosmo.pgJsonbDemo.model.request.AccountUpdateRequest;
import org.octoosmo.pgJsonbDemo.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final PersonService personService;

    public AccountService(AccountRepository accountRepository,
                          PersonService personService) {
        this.accountRepository = accountRepository;
        this.personService = personService;
    }

    @Transactional
    public Account find(UUID uuid) {
        return accountRepository.findById(uuid)
                .map(AccountEntityMapper.INSTANCE::accountEntityToAccount)
                .orElseThrow();
    }

    @Transactional
    public Account create(AccountCreateRequest accountCreateRequest) {
        var person = personService.find(accountCreateRequest.personId());
        var account = AccountMapper.INSTANCE.accountCreateRequestToAccount(accountCreateRequest);
        account.setPerson(person);
        var accountEntity = AccountEntityMapper.INSTANCE.accountToAccountEntity(account);

        accountEntity = accountRepository.save(accountEntity);
        return AccountEntityMapper.INSTANCE.accountEntityToAccount(accountEntity);
    }

    @Transactional
    public Account update(UUID id, AccountUpdateRequest accountUpdateRequest) {
        var storedAccountEntity = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account with id = %s does not exist".formatted(id)));

        var accountEntity = Optional.of(accountUpdateRequest)
                .map(AccountMapper.INSTANCE::accountUpdateRequestToAccount)
                .map(AccountEntityMapper.INSTANCE::accountToAccountEntity)
                .map(accEntity -> {
                    accEntity.setPerson(storedAccountEntity.getPerson());
                    accEntity.setId(id);
                    return accEntity;
                }).orElseThrow();

        accountEntity = accountRepository.save(accountEntity);
        return AccountEntityMapper.INSTANCE.accountEntityToAccount(accountEntity);
    }

    @Transactional
    public void delete(UUID id) {
        accountRepository.deleteById(id);
    }
}
