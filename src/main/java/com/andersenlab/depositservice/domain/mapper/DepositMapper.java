package com.andersenlab.depositservice.domain.mapper;

import com.andersenlab.depositservice.domain.dto.RequestPlacingNewDepositDto;
import com.andersenlab.depositservice.domain.dto.ResponseAvailableDepositsDto;
import com.andersenlab.depositservice.domain.dto.ResponseCompletedDepositsDto;
import com.andersenlab.depositservice.domain.entity.Account;
import com.andersenlab.depositservice.domain.entity.Agreement;

import java.util.Collection;
import java.util.List;

public interface DepositMapper {

    List<ResponseCompletedDepositsDto> accountToResponseCompletedDepositsDto(Account account);

    Collection<ResponseAvailableDepositsDto> accountToResponseAvailableDepositsDto(Account account);

    Agreement requestPlacingNewDepositDtoToAgreement(RequestPlacingNewDepositDto requestPlacingNewDepositDto);

}
