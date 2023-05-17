package org.octoosmo.pgJsonbDemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.octoosmo.pgJsonbDemo.model.Account;
import org.octoosmo.pgJsonbDemo.model.request.AccountCreateRequest;
import org.octoosmo.pgJsonbDemo.model.request.AccountUpdateRequest;
import org.octoosmo.pgJsonbDemo.model.response.AccountResponse;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountCreateRequest accountCreateRequestToAccount(Account account);

    AccountUpdateRequest accountUpdateRequestToAccount(Account account);

    Account accountCreateRequestToAccount(AccountCreateRequest account);

    Account accountUpdateRequestToAccount(AccountUpdateRequest account);

    AccountResponse accountToAccountResponse(Account account);
}
