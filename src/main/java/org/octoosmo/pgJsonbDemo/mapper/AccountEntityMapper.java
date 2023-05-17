package org.octoosmo.pgJsonbDemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.octoosmo.pgJsonbDemo.entity.AccountEntity;
import org.octoosmo.pgJsonbDemo.model.Account;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountEntityMapper {
    AccountEntityMapper INSTANCE = Mappers.getMapper(AccountEntityMapper.class);

    Account accountEntityToAccount(AccountEntity accountEntity);

    AccountEntity accountToAccountEntity(Account account);
}
