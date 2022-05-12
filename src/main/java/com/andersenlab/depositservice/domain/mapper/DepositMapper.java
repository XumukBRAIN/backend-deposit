package com.andersenlab.depositservice.domain.mapper;

import com.andersenlab.depositservice.domain.dto.ResponseCompletedDepositsDto;
import com.andersenlab.depositservice.domain.entity.Account;

import java.util.Collection;

public interface DepositMapper {

    Collection <ResponseCompletedDepositsDto> accountToResponseCompletedDepositsDto (Account account);



}
